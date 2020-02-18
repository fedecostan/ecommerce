angular.module('app', []).controller('ProductCrudController', function($scope, $http) {

    var self = this;
    $scope.tvInputs = false;
    $scope.smartphoneInputs = false;
    $scope.laptopInputs = false;
    $scope.years = [2020, 2019, 2018, 2017, 2016, 2015, 2014];
    $scope.operatingSystems = [
        {code: 'WIN',description: 'Windows'},
        {code: 'LNX',description: 'Linux'},
        {code: 'IOS',description: 'IOS'},
        {code: 'AND',description: 'Android'},
        {code: 'SS',description: 'Sin OS'}
    ];
    $scope.sims = [
        {code: 'NS',description: 'N/A'},
        {code: 'NA',description: 'NanoSim'},
        {code: 'MI',description: 'MicroSim'},
        {code: 'SI',description: 'Sim'}
    ];
    $scope.modalProduct = [];
    var operation = 0;
    var productToDelete;

    showLoading = function() {
        $('#modal-cargando').modal('show');
    }

    hideLoading = function() {
        $('#modal-cargando').modal('hide');
    }

    showLoading();

    loadProductTable = function() {
        $scope.products = [];
        $http({
                method: 'GET',
                url: 'http://localhost:8080/productController/'
            })
            .then(function successCallback(response) {
                $scope.products = response.data;
                hideLoading();
            }, function errorCallback(response) {});
    }
    loadProductTable();

    $scope.typeSelected = function(type) {
        if (type == 0) {
            $scope.tvInputs = false;
            $scope.smartphoneInputs = false;
            $scope.laptopInputs = false;
        } else if (type == 1) {
            $scope.modalProduct.type = "TV";
            $scope.tvInputs = true;
            $scope.smartphoneInputs = false;
            $scope.laptopInputs = false;
        } else if (type == 2) {
            $scope.modalProduct.type = "PHONE";
            $scope.tvInputs = false;
            $scope.smartphoneInputs = true;
            $scope.laptopInputs = false;
        } else if (type == 3) {
            $scope.modalProduct.type = "LAPTOP";
            $scope.tvInputs = false;
            $scope.smartphoneInputs = false;
            $scope.laptopInputs = true;
        }
    }

    $scope.newProduct = function() {
        $scope.modalInputsDisabled = false;
        $scope.typeSelected(0);
        $scope.isNewProduct = true;
        $scope.showSaveButton = true;
        $scope.productModalTitle = "Nuevo Producto";
        $scope.modalProduct = [];
        operation = 1;
    }

    $scope.productDetail = function(id) {
        $scope.modalProduct = [];
        showLoading();
        $scope.isNewProduct = false;
        $scope.modalInputsDisabled = true;
        $scope.showSaveButton = false;
        $scope.typeSelected(0);
        $http({
                method: 'GET',
                url: 'http://localhost:8080/productController/details/' + id
            })
            .then(function successCallback(response) {
                loadModalProductInputs(response.data);
                hideLoading();
            }, function errorCallback(response) {});
    }

    $scope.productEdit = function(id) {
        $scope.modalProduct = [];
        showLoading();
        $scope.isNewProduct = false;
        $scope.modalInputsDisabled = false;
        $scope.showSaveButton = true;
        $scope.typeSelected(0);
        operation = 2;
        $http({
                method: 'GET',
                url: 'http://localhost:8080/productController/details/' + id
            })
            .then(function successCallback(response) {
                loadModalProductInputs(response.data);
                hideLoading();
            }, function errorCallback(response) {});
    }

    $scope.productDelete = function(id) {
        productToDelete = id;
    }

    $scope.confirmDelete = function() {
    showLoading();
    $http({
            method: 'GET',
            url: 'http://localhost:8080/productController/delete/' + productToDelete
        })
        .then(function successCallback(response) {
            $('#modal-bot-borrar').modal('hide');
            loadProductTable();
        }, function errorCallback(response) {});
    }

    $scope.saveOperation = function() {
        showLoading();
        var body = {
            type: $scope.modalProduct.type,
            code: $scope.modalProduct.code,
            price: $scope.modalProduct.price,
            discount: $scope.modalProduct.discount,
            stock: $scope.modalProduct.stock,
            name: $scope.modalProduct.name,
            description: $scope.modalProduct.description,
            screenInches: $scope.modalProduct.screenInches,
            screenTechnology: $scope.modalProduct.screenTechnology,
            screenType: $scope.modalProduct.screenType,
            screenResolution: $scope.modalProduct.screenResolution,
            screenRefreshRate: $scope.modalProduct.screenRefreshRate,
            screenAdditionalInfo: $scope.modalProduct.screenAdditionalInfo,
            manufacturerName: $scope.modalProduct.manufacturerName,
            manufacturerModel: $scope.modalProduct.manufacturerModel,
            manufacturerCode: $scope.modalProduct.manufacturerCode,
            smartTv: $scope.modalProduct.smartTv == 'Y'?true:false,
            year: $scope.modalProduct.year,
            operatingSystem: $scope.modalProduct.operatingSystem,
            hardDriveSize: $scope.modalProduct.hardDriveSize,
            ramSize: $scope.modalProduct.ramSize,
            battery: $scope.modalProduct.battery,
            backCamera: $scope.modalProduct.backCamera,
            frontCamera: $scope.modalProduct.frontCamera,
            simType: $scope.modalProduct.simType,
            videoRecorder: $scope.modalProduct.videoRecorder,
            nfcCapable: $scope.modalProduct.nfcCapable == 'Y'?true:false,
            processor: $scope.modalProduct.processor,
            graphics: $scope.modalProduct.graphics,
            size: $scope.modalProduct.size,
            weight: $scope.modalProduct.weight
        };
        var url;
        if (operation == 1) {
            url = 'http://localhost:8080/productController/newProduct';
        } else if (operation == 2) {
            url = 'http://localhost:8080/productController/editProduct/' + $scope.modalProduct.id;
        }
        $http.post(url, body).then(
            function successCallback(response) {
                loadProductTable();
                $('#modal-nvo-produc').modal('hide');
            }, function errorCallback(response) {});

    }

    loadModalProductInputs = function(p) {
        $scope.modalProduct.id = p.id;
        $scope.modalProduct.type = p.productType.description;
        $scope.modalProduct.code = p.product.code;
        $scope.modalProduct.price = p.product.price;
        $scope.modalProduct.discount = p.product.discount;
        $scope.modalProduct.stock = p.product.stock;
        $scope.modalProduct.name = p.product.name;
        $scope.modalProduct.description = p.product.description;
        $scope.modalProduct.year = p.product.year;
        if (p.tvInfo != null) {
            $scope.productModalTitle = "TV";
            $scope.typeSelected(1);
            $scope.modalProduct.screenInches = p.tvInfo.screen.inches;
            $scope.modalProduct.screenTechnology = p.tvInfo.screen.technology;
            $scope.modalProduct.screenType = p.tvInfo.screen.type;
            $scope.modalProduct.screenResolution = p.tvInfo.screen.resolution;
            $scope.modalProduct.screenRefreshRate = p.tvInfo.screen.refreshRate;
            $scope.modalProduct.screenAdditionalInfo = p.tvInfo.screen.additionalInfo;
            $scope.modalProduct.manufacturerName = p.tvInfo.manufacturer.name;
            $scope.modalProduct.manufacturerModel = p.tvInfo.manufacturer.model;
            $scope.modalProduct.manufacturerCode = p.tvInfo.manufacturer.code;
            $scope.modalProduct.smartTv = p.tvInfo.smartTv;
            $scope.modalProduct.size = p.tvInfo.size;
            $scope.modalProduct.weight = p.tvInfo.weight;
        } else if (p.phoneInfo != null) {
            $scope.productModalTitle = "Móvil";
            $scope.typeSelected(2);
            $scope.modalProduct.screenInches = p.phoneInfo.screen.inches;
            $scope.modalProduct.screenTechnology = p.phoneInfo.screen.technology;
            $scope.modalProduct.screenType = p.phoneInfo.type;
            $scope.modalProduct.screenResolution = p.phoneInfo.screen.resolution;
            $scope.modalProduct.screenRefreshRate = p.phoneInfo.screen.refreshRate;
            $scope.modalProduct.screenAdditionalInfo = p.phoneInfo.screen.additionalInfo;
            $scope.modalProduct.manufacturerName = p.phoneInfo.manufacturer.name;
            $scope.modalProduct.manufacturerModel = p.phoneInfo.manufacturer.model;
            $scope.modalProduct.manufacturerCode = p.phoneInfo.manufacturer.code;
            $scope.modalProduct.operatingSystem = p.phoneInfo.operatingSystem;
            $scope.modalProduct.hardDriveSize = p.phoneInfo.hardDriveSize;
            $scope.modalProduct.ramSize = p.phoneInfo.ramSize;
            $scope.modalProduct.battery = p.phoneInfo.battery;
            $scope.modalProduct.backCamera = p.phoneInfo.backCamera;
            $scope.modalProduct.frontCamera = p.phoneInfo.frontCamera;
            $scope.modalProduct.simType = p.phoneInfo.simType;
            $scope.modalProduct.videoRecorder = p.phoneInfo.videoRecorder;
            $scope.modalProduct.nfcCapable = p.phoneInfo.nfcCapable;
            $scope.modalProduct.processor = p.phoneInfo.processor;
            $scope.modalProduct.graphics = p.phoneInfo.graphics;
            $scope.modalProduct.size = p.phoneInfo.size;
            $scope.modalProduct.weight = p.phoneInfo.weight;
        } else if (p.laptopInfo != null) {
            $scope.productModalTitle = "Ordenador";
            $scope.typeSelected(3);
            $scope.modalProduct.screenInches = p.laptopInfo.screen.inches;
            $scope.modalProduct.screenTechnology = p.laptopInfo.screen.technology;
            $scope.modalProduct.screenType = p.laptopInfo.type;
            $scope.modalProduct.screenResolution = p.laptopInfo.screen.resolution;
            $scope.modalProduct.screenRefreshRate = p.laptopInfo.screen.refreshRate;
            $scope.modalProduct.screenAdditionalInfo = p.laptopInfo.screen.additionalInfo;
            $scope.modalProduct.manufacturerName = p.laptopInfo.manufacturer.name;
            $scope.modalProduct.manufacturerModel = p.laptopInfo.manufacturer.model;
            $scope.modalProduct.manufacturerCode = p.laptopInfo.manufacturer.code;
            $scope.modalProduct.operatingSystem = p.laptopInfo.operatingSystem;
            $scope.modalProduct.hardDriveSize = p.laptopInfo.hardDriveSize;
            $scope.modalProduct.ramSize = p.laptopInfo.ramSize;
            $scope.modalProduct.battery = p.laptopInfo.battery;
            $scope.modalProduct.frontCamera = p.laptopInfo.frontCamera;
            $scope.modalProduct.processor = p.laptopInfo.processor;
            $scope.modalProduct.graphics = p.laptopInfo.graphics;
            $scope.modalProduct.size = p.laptopInfo.size;
            $scope.modalProduct.weight = p.laptopInfo.weight;
        }
    }

});