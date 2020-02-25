package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.repository.ProductDetailRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.ProductTypeRepository;
import com.ecommerce.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<ProductDetail> getDetailsById(Long id) {
        return productDetailRepository.findByProductId(id);
    }

    @Override
    public GenericResponse deleteById(Long id) {
        try {
            ProductDetail productDetail = productDetailRepository.findByProductId(id).orElse(null);
            productDetail.setProductType(null);
            productDetailRepository.deleteById(id);
        } catch (Exception e) {
            return new GenericResponse(ErrorEnum.GENERIC_ERROR.getErrorMessage());
        }
        return new GenericResponse();
    }

    @Override
    public GenericResponse createProduct(FullProductDTO fullProductDTO) {
        try {
            Product product = new Product(fullProductDTO);
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProduct(product);
            ProductType productType = getProductType(fullProductDTO);
            productDetail.setProductType(productType);
            Screen screen = new Screen(fullProductDTO);
            Manufacturer manufacturer = new Manufacturer(fullProductDTO);
            if (productType.getId() == 1L) {
                TvInfo tvInfo = new TvInfo(fullProductDTO);
                tvInfo.setScreen(screen);
                tvInfo.setManufacturer(manufacturer);
                productDetail.setTvInfo(tvInfo);
            } else if (productType.getId() == 2L) {
                PhoneInfo phoneInfo = new PhoneInfo(fullProductDTO);
                phoneInfo.setScreen(screen);
                phoneInfo.setManufacturer(manufacturer);
                productDetail.setPhoneInfo(phoneInfo);
            } else if (productType.getId() == 3L) {
                LaptopInfo laptopInfo = new LaptopInfo(fullProductDTO);
                laptopInfo.setScreen(screen);
                laptopInfo.setManufacturer(manufacturer);
                productDetail.setLaptopInfo(laptopInfo);
            }
            productDetailRepository.save(productDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return new GenericResponse(ErrorEnum.GENERIC_ERROR.getErrorMessage());
        }
        return new GenericResponse();
    }

    @Override
    public GenericResponse editProduct(Long id, FullProductDTO fullProductDTO) {
        ProductDetail productDetail = productDetailRepository.findByProductId(id).orElse(null);
        if (productDetail == null) {
            return new GenericResponse(ErrorEnum.GENERIC_ERROR.getErrorMessage());
        } else {
            updateProductInformation(productDetail, fullProductDTO);
        }
        return new GenericResponse();
    }

    @Override
    public List<Product> getOrder(String order) {
        List<Product> allProducts = productRepository.findAll();
        if (OrderEnum.NAME_ASC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getName));
        else if (OrderEnum.NAME_DESC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getName).reversed());
        else if (OrderEnum.PRICE_ASC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getPrice));
        else if (OrderEnum.PRICE_DESC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        return allProducts;
    }

    //@Override
    public ProductTablePageDTO getOrder(int page, int size, String order) {
        ProductTablePageDTO productTablePageDTO = new ProductTablePageDTO();
        List<Product> allProducts = productRepository.findAll();
        if (OrderEnum.NAME_ASC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getName));
        else if (OrderEnum.NAME_DESC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getName).reversed());
        else if (OrderEnum.PRICE_ASC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getPrice));
        else if (OrderEnum.PRICE_DESC.name().equals(order))
            allProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        int element = size * (page - 1);
        List<Product> filteredProducts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (element < allProducts.size()) {
                filteredProducts.add(allProducts.get(element));
            }
            element++;
        }
        productTablePageDTO.setPage(page);
        productTablePageDTO.setSize(size);
        productTablePageDTO.setData(filteredProducts);
        productTablePageDTO.setHasNextPage(element < allProducts.size());
        productTablePageDTO.setTotalPages(totalNumberOfPages(size, allProducts.size()));
        return productTablePageDTO;
    }

    @Override
    public List<Product> getBySearch(String data) {
        return productRepository.findBySearch("%" + data + "%");
    }

    private int totalNumberOfPages(int size, int totalElements) {
        if (totalElements % size == 0)
            return totalElements / size;
        else
            return ((totalElements + (size - (totalElements % size))) / size);
    }

    private ProductType getProductType(FullProductDTO fullProductDTO) {
        ProductTypeEnum productTypeEnum = null;
        if (ProductTypeEnum.TV_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.TV_INFO;
        if (ProductTypeEnum.PHONE_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.PHONE_INFO;
        if (ProductTypeEnum.LAPTOP_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.LAPTOP_INFO;
        return productTypeRepository.findById(productTypeEnum.getProductTypeId()).orElse(null);
    }

    private void updateProductInformation(ProductDetail productDetail, FullProductDTO fullProductDTO) {
        productDetail.getProduct().setCode(fullProductDTO.getCode());
        productDetail.getProduct().setPrice(fullProductDTO.getPrice());
        productDetail.getProduct().setDiscount(fullProductDTO.getDiscount());
        productDetail.getProduct().setStock(fullProductDTO.getStock());
        productDetail.getProduct().setName(fullProductDTO.getName());
        productDetail.getProduct().setDescription(fullProductDTO.getDescription());
        productDetail.getProduct().setYear(fullProductDTO.getYear());
        productDetail.getProduct().setSize(fullProductDTO.getSize());
        productDetail.getProduct().setWeight(fullProductDTO.getWeight());
        if (productDetail.getProductType().getId() == 1L) {
            productDetail.getTvInfo().getScreen().setInches(fullProductDTO.getScreenInches());
            productDetail.getTvInfo().getScreen().setTechnology(fullProductDTO.getScreenTechnology());
            productDetail.getTvInfo().getScreen().setType(fullProductDTO.getScreenType());
            productDetail.getTvInfo().getScreen().setResolution(fullProductDTO.getScreenResolution());
            productDetail.getTvInfo().getScreen().setRefreshRate(fullProductDTO.getScreenRefreshRate());
            productDetail.getTvInfo().getScreen().setAdditionalInfo(fullProductDTO.getScreenAdditionalInfo());
            productDetail.getTvInfo().getManufacturer().setName(fullProductDTO.getManufacturerName());
            productDetail.getTvInfo().getManufacturer().setModel(fullProductDTO.getManufacturerModel());
            productDetail.getTvInfo().getManufacturer().setCode(fullProductDTO.getManufacturerCode());
            productDetail.getTvInfo().setSmartTv(fullProductDTO.getSmartTv());
        } else if (productDetail.getProductType().getId() == 2L) {
            productDetail.getPhoneInfo().getScreen().setInches(fullProductDTO.getScreenInches());
            productDetail.getPhoneInfo().getScreen().setTechnology(fullProductDTO.getScreenTechnology());
            productDetail.getPhoneInfo().getScreen().setType(fullProductDTO.getScreenType());
            productDetail.getPhoneInfo().getScreen().setResolution(fullProductDTO.getScreenResolution());
            productDetail.getPhoneInfo().getScreen().setRefreshRate(fullProductDTO.getScreenRefreshRate());
            productDetail.getPhoneInfo().getScreen().setAdditionalInfo(fullProductDTO.getScreenAdditionalInfo());
            productDetail.getPhoneInfo().getManufacturer().setName(fullProductDTO.getManufacturerName());
            productDetail.getPhoneInfo().getManufacturer().setModel(fullProductDTO.getManufacturerModel());
            productDetail.getPhoneInfo().getManufacturer().setCode(fullProductDTO.getManufacturerCode());
            productDetail.getPhoneInfo().setOperatingSystem(fullProductDTO.getOperatingSystem());
            productDetail.getPhoneInfo().setHardDriveSize(fullProductDTO.getHardDriveSize());
            productDetail.getPhoneInfo().setRamSize(fullProductDTO.getRamSize());
            productDetail.getPhoneInfo().setBattery(fullProductDTO.getBattery());
            productDetail.getPhoneInfo().setBackCamera(fullProductDTO.getBackCamera());
            productDetail.getPhoneInfo().setFrontCamera(fullProductDTO.getFrontCamera());
            productDetail.getPhoneInfo().setSimType(fullProductDTO.getSimType());
            productDetail.getPhoneInfo().setVideoRecorder(fullProductDTO.getVideoRecorder());
            productDetail.getPhoneInfo().setNfcCapable(fullProductDTO.getNfcCapable());
        } else if (productDetail.getProductType().getId() == 3L) {
            productDetail.getLaptopInfo().getScreen().setInches(fullProductDTO.getScreenInches());
            productDetail.getLaptopInfo().getScreen().setTechnology(fullProductDTO.getScreenTechnology());
            productDetail.getLaptopInfo().getScreen().setType(fullProductDTO.getScreenType());
            productDetail.getLaptopInfo().getScreen().setResolution(fullProductDTO.getScreenResolution());
            productDetail.getLaptopInfo().getScreen().setRefreshRate(fullProductDTO.getScreenRefreshRate());
            productDetail.getLaptopInfo().getScreen().setAdditionalInfo(fullProductDTO.getScreenAdditionalInfo());
            productDetail.getLaptopInfo().getManufacturer().setName(fullProductDTO.getManufacturerName());
            productDetail.getLaptopInfo().getManufacturer().setModel(fullProductDTO.getManufacturerModel());
            productDetail.getLaptopInfo().getManufacturer().setCode(fullProductDTO.getManufacturerCode());
            productDetail.getLaptopInfo().setOperatingSystem(fullProductDTO.getOperatingSystem());
            productDetail.getLaptopInfo().setHardDriveSize(fullProductDTO.getHardDriveSize());
            productDetail.getLaptopInfo().setRamSize(fullProductDTO.getRamSize());
            productDetail.getLaptopInfo().setProcessor(fullProductDTO.getProcessor());
            productDetail.getLaptopInfo().setGraphics(fullProductDTO.getGraphics());
            productDetail.getLaptopInfo().setCamera(fullProductDTO.getFrontCamera());
        }
        productDetailRepository.save(productDetail);
    }
}
