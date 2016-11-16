var angularshop = angular.module('AngularSHOP');

angularshop.controller("ProduktController",function($routeParams, $location, ProduktService, ZamowienieService){
  var produktController = this;
  produktController.produktKod = $routeParams.produktKod;
  produktController.produkt = {};
  ProduktService.getProduktByKod(produktController.produktKod).success(function(result){
    produktController.produkt = result;
  });
  
  produktController.zamow = function(){
    ZamowienieService.addProdukt(produktController.produkt).success(function(result){
      $location.path('/zamowienie');
    });
    
  };
});

angularshop.service("ProduktService",function($http){
  var produktService = this;
  produktService.getProduktByKod = function(kod){
    return $http.get('/angularshop/katalog/produkty/'+kod);
  };
});