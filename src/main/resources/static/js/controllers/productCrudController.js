angular.module('app', []).controller('ProductCrudController', function($scope, $http) {

    var self = this;
    $scope.tvInputs = false;
    $scope.smartphoneInputs = false;
    $scope.laptopInputs = false;
    $scope.isTv = true;
    $scope.isPhone = true;
    $scope.isLaptop = true;
    $scope.years = [2020, 2019, 2018, 2017, 2016, 2015, 2014];
    $scope.operatingSystems = ["Windows", "Linux", "IOS", "Android", "Sin OS"];
    $scope.sims = ["N/A", "NanoSIM", "MiniSim", "Sim"];

    $http({
            method: 'GET',
            url: 'http://localhost:8080/productController/'
        })
        .then(function successCallback(response) {
            $scope.products = response.data;
        }, function errorCallback(response) {});

    $scope.typeSelected = function(type) {
        if (type == 1) {
            $scope.tvInputs = true;
            $scope.smartphoneInputs = false;
            $scope.laptopInputs = false;
        } else if (type == 2) {
            $scope.tvInputs = false;
            $scope.smartphoneInputs = true;
            $scope.laptopInputs = false;
        } else if (type == 3) {
            $scope.tvInputs = false;
            $scope.smartphoneInputs = false;
            $scope.laptopInputs = true;
        }
    }

    $scope.newProduct = function() {
        $scope.modalInputsDisabled = false;
        $scope.typeSelected(0);
        $scope.isTv = true;
        $scope.isPhone = true;
        $scope.isLaptop = true;
        $scope.isNewProduct = true;
        $scope.productModalTitle = "Nuevo Producto";
    }

    $scope.productoDetail = function(id) {
        $scope.isNewProduct = false;
        $scope.modalInputsDisabled = true;
        $http({
                method: 'GET',
                url: 'http://localhost:8080/productController/details/' + id
            })
            .then(function successCallback(response) {
                $scope.modalProduct.code = response.data.product.code;
                $scope.modalProduct.price = response.data.product.price;
                $scope.modalProduct.discount = response.data.product.discount;
                $scope.modalProduct.stock = response.data.product.stock;
                $scope.modalProduct.name = response.data.product.name;
                $scope.modalProduct.description = response.data.product.description;
                $scope.modalProduct.year = response.data.product.year;
                if (response.data.tvInfo != null) {
                    $scope.productModalTitle = "TV";
                    $scope.typeSelected(1);
                    $scope.isTv = true;
                    $scope.isPhone = false;
                    $scope.isLaptop = false;
                    $scope.modalProduct.screenInches = response.data.tvInfo.screen.inches;
                    $scope.modalProduct.screenTechnology = response.data.tvInfo.screen.technology;
                    $scope.modalProduct.screenType = response.data.tvInfo.screen.type;
                    $scope.modalProduct.screenResolution = response.data.tvInfo.screen.resolution;
                    $scope.modalProduct.screenRefreshRate = response.data.tvInfo.screen.refreshRate;
                    $scope.modalProduct.screenAdditionalInfo = response.data.tvInfo.screen.additionalInfo;
                    $scope.modalProduct.manufacturerName = response.data.tvInfo.manufacturer.name;
                    $scope.modalProduct.manufacturerModel = response.data.tvInfo.manufacturer.model;
                    $scope.modalProduct.manufacturerCode = response.data.tvInfo.manufacturer.code;
                    $scope.modalProduct.smartTv = response.data.tvInfo.smartTv;
                    $scope.modalProduct.size = response.data.tvInfo.size;
                    $scope.modalProduct.weight = response.data.tvInfo.weight;
                } else if (response.data.phoneInfo != null) {
                    $scope.productModalTitle = "Móvil";
                    $scope.typeSelected(2);
                    $scope.isTv = false;
                    $scope.isPhone = true;
                    $scope.isLaptop = false;
                    $scope.modalProduct.screenInches = response.data.phoneInfo.screen.inches;
                    $scope.modalProduct.screenTechnology = response.data.phoneInfo.screen.technology;
                    $scope.modalProduct.screenType = response.data.phoneInfo.type;
                    $scope.modalProduct.screenResolution = response.data.phoneInfo.screen.resolution;
                    $scope.modalProduct.screenRefreshRate = response.data.phoneInfo.screen.refreshRate;
                    $scope.modalProduct.screenAdditionalInfo = response.data.phoneInfo.screen.additionalInfo;
                    $scope.modalProduct.manufacturerName = response.data.phoneInfo.manufacturer.name;
                    $scope.modalProduct.manufacturerModel = response.data.phoneInfo.manufacturer.model;
                    $scope.modalProduct.manufacturerCode = response.data.phoneInfo.manufacturer.code;
                    $scope.modalProduct.operatingSystem = response.data.phoneInfo.operatingSystem;
                    $scope.modalProduct.hardDriveSize = response.data.phoneInfo.hardDriveSize;
                    $scope.modalProduct.ramSize = response.data.phoneInfo.ramSize;
                    $scope.modalProduct.battery = response.data.phoneInfo.battery;
                    $scope.modalProduct.backCamera = response.data.phoneInfo.backCamera;
                    $scope.modalProduct.frontCamera = response.data.phoneInfo.frontCamera;
                    $scope.modalProduct.simType = response.data.phoneInfo.simType;
                    $scope.modalProduct.videoRecorder = response.data.phoneInfo.videoRecorder;
                    $scope.modalProduct.nfcCapable = response.data.phoneInfo.nfcCapable;
                    $scope.modalProduct.processor = response.data.phoneInfo.processor;
                    $scope.modalProduct.graphics = response.data.phoneInfo.graphics;
                    $scope.modalProduct.size = response.data.phoneInfo.size;
                    $scope.modalProduct.weight = response.data.phoneInfo.weight;
                } else if (response.data.laptopInfo != null) {
                    $scope.productModalTitle = "Ordenador";
                    $scope.typeSelected(3);
                    $scope.isTv = false;
                    $scope.isPhone = false;
                    $scope.isLaptop = true;
                    $scope.modalProduct.screenInches = response.data.laptopInfo.screen.inches;
                    $scope.modalProduct.screenTechnology = response.data.laptopInfo.screen.technology;
                    $scope.modalProduct.screenType = response.data.laptopInfo.type;
                    $scope.modalProduct.screenResolution = response.data.laptopInfo.screen.resolution;
                    $scope.modalProduct.screenRefreshRate = response.data.laptopInfo.screen.refreshRate;
                    $scope.modalProduct.screenAdditionalInfo = response.data.laptopInfo.screen.additionalInfo;
                    $scope.modalProduct.manufacturerName = response.data.laptopInfo.manufacturer.name;
                    $scope.modalProduct.manufacturerModel = response.data.laptopInfo.manufacturer.model;
                    $scope.modalProduct.manufacturerCode = response.data.laptopInfo.manufacturer.code;
                    $scope.modalProduct.operatingSystem = response.data.laptopInfo.operatingSystem;
                    $scope.modalProduct.hardDriveSize = response.data.laptopInfo.hardDriveSize;
                    $scope.modalProduct.ramSize = response.data.laptopInfo.ramSize;
                    $scope.modalProduct.battery = response.data.laptopInfo.battery;
                    $scope.modalProduct.frontCamera = response.data.laptopInfo.frontCamera;
                    $scope.modalProduct.processor = response.data.laptopInfo.processor;
                    $scope.modalProduct.graphics = response.data.laptopInfo.graphics;
                    $scope.modalProduct.size = response.data.laptopInfo.size;
                    $scope.modalProduct.weight = response.data.laptopInfo.weight;
                }
            }, function errorCallback(response) {});
    }

    $scope.productoModal = function(disabled) {
        $scope.modalInputsDisabled = disabled;
    }

});