angular.module('app', []).controller('ProductCrudController', function($scope, $http){
    $http({method: 'GET', url: 'http://localhost:8080/productController/'})
        .then(function successCallback(response) {
            $scope.products = response.data;
        }, function errorCallback(response) {
      });
});