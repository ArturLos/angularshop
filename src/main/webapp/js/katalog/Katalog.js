var angularshop = angular.module('AngularSHOP');
angularshop.controller('KatalogController',function($scope, KatalogService, $routeParams){
  var katalogController = this;
  katalogController.produkty = undefined;
  katalogController.loadProdukty = function() {
  if ($routeParams.kategoriaKod === undefined) {
    KatalogService.getProdukty().success(function(result){
      katalogController.produkty = result;
    });
  } else {
    KatalogService.getProduktyZKategorii($routeParams.kategoriaKod).success(function(result){
      katalogController.produkty = result;
    });
  }
  }
});

angularshop.service('KatalogService',function($http){
  var katalogService = this;
  katalogService.getProdukty = function() {
    return $http.get('/angularshop/katalog/produkty');
  };
  katalogService.getProduktyZKategorii = function(kategoriaKod) {
    return $http.get('/angularshop/katalog/produkty/kategoria/'+kategoriaKod);
  };
  katalogService.addProdukt = function(produkt) {
    return $http.post('/angularshop/katalog/produkty', produkt);
  };
});