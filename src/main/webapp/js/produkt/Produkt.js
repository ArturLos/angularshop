var angularshop = angular.module('AngularSHOP');

angularshop.controller("ProduktController",function($routeParams, $location, ProduktService, ZamowienieService){
  var produktController = this;
  produktController.produktId = $routeParams.produktId;
  produktController.produkt = {};
  ProduktService.getProduktById(produktController.produktId).success(function(result){
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
  produktService.getProduktById = function(id){
    return $http.get('/angularshop/katalog/produkty/'+id);
  };
});