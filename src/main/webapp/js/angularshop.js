/* global angular */

var angularshop = angular.module('AngularSHOP', ['ngRoute', 'ngSanitize']);

angularshop.config(function($routeProvider, $locationProvider) {
  $routeProvider
          .when("/", {
            templateUrl: "produktList.jsp"
          })
          .when("/kategoria/:kategoriaKod?",{
              templateUrl: "produktList.jsp",
          })
          .when("/produkt/:produktId",{
            templateUrl: "produktSzczegoly.jsp"
          })
          .when("/zamowienie",{
            templateUrl: "zamowienieForm.jsp"
          })
          .otherwise({redirectTo: "/"});
});

angularshop.controller('MainController', function(KatalogService) {
  var main = this;
  main.currentProdukt = {};
  main.setCurrentProdukt = function(produkt) {
    main.currentProdukt = produkt;
  };
  main.addProdukt = function(produkt) {
    KatalogService.addProdukt(angular.copy(produkt));
  };
});