var angularshop = angular.module('AngularSHOP');
angularshop.controller('KategoriaController',function(KategoriaService, $routeParams){
  var kategoriaController = this;
  var kategoriaAll = {"id":-1,"kod":"","nazwa":"Wszystkie"}
  kategoriaController.kategorie = undefined;
  KategoriaService.getKategorie().success(function(result){
    kategoriaController.kategorie = [kategoriaAll];
    kategoriaController.kategorie = kategoriaController.kategorie.concat(result);
  });
  kategoriaController.isActive = function(kategoriaKod) {
    return $routeParams.kategoriaKod === kategoriaKod
  };
});

angularshop.service('KategoriaService',function($http){
  var kategoriaService = this;
  kategoriaService.getKategorie = function() {
    return $http.get('/angularshop/kategoria/wszystkie');
  };
});