var angularshop = angular.module('AngularSHOP');
angularshop.controller('KatalogController',function($scope, KatalogService, $routeParams, $route){
  var katalogController = this;
  katalogController.currentPage = $routeParams.page!==undefined? $routeParams.page : 1;
  katalogController.totalItems = 170;
  katalogController.maxSize = 10;
  katalogController.itemsPerPage = 10
  katalogController.zmienionoStrone = function (){
    $route.updateParams({"page":katalogController.currentPage});
  };
  katalogController.produkty = undefined;
  katalogController.loadProdukty = function() {
    if ($routeParams.kategoriaKod === undefined) {
      KatalogService.getProdukty($routeParams.page).success(function(result){
        katalogController.produkty = result;
      });
    } else {
      KatalogService.getProduktyZKategorii($routeParams.kategoriaKod, $routeParams.page).success(function(result){
        katalogController.produkty = result;
      });
    }
  };
});

angularshop.service('KatalogService',function($http){
  var katalogService = this;
  katalogService.getProdukty = function(page) {
    if(page===undefined) {
      return $http.get('/angularshop/katalog/produkty');
    } else {
      return $http.get('/angularshop/katalog/produkty?page='+page);
    }
  };
  katalogService.getProduktyZKategorii = function(kategoriaKod, page) {
    if(page===undefined) {
      return $http.get('/angularshop/katalog/produkty/kategoria/' + kategoriaKod);
    } else {
      return $http.get('/angularshop/katalog/produkty/kategoria/' + kategoriaKod + '?page='+page);
    }
  };
  katalogService.addProdukt = function(produkt) {
    return $http.post('/angularshop/katalog/produkty', produkt);
  };
});