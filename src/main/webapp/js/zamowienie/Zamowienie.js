var angularshop = angular.module('AngularSHOP');

angularshop.controller("ZamowienieController",function(ZamowienieService, $location){
  var zamowienieController = this;

  var zabowienieObj = {

  }

  zamowienieController.zamowienie = {};
  
  zamowienieController.wyslij = function wyslij(){
    console.log("Zamowienie: " + JSON.stringify(zamowienieController.zamowienie));
    ZamowienieService.wyslij(zamowienieController.zamowienie).success(function(result){
      $location.path('/');
    });
  };
  
  zamowienieController.getZamownienie = function getZamownienie(){
    console.log("Pobieranie aktualnego zamówienia");
    ZamowienieService.getZamowienie().success(function(result){
      zamowienieController.zamowienie = result;
    });
  };
  
});

angularshop.service("ZamowienieService",function($http){
  var zamowienieService = this;
  
  zamowienieService.addProdukt = function(produkt){
    return $http.post('/angularshop/zamowienie', JSON.stringify(produkt));
  };
  
  zamowienieService.getZamowienie = function(){
    return $http.get('/angularshop/zamowienie');
  };

  zamowienieService.wyslij = function(zamowienie){
    return $http.post('/angularshop/zamowienie/wyslij', JSON.stringify(zamowienie));
  };
});