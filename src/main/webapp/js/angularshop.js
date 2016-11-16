/* global angular */

var angularshop = angular.module('AngularSHOP', ['ngRoute', 'ngSanitize', 'ngAnimate', 'ui.bootstrap']);

angularshop.config(function($routeProvider, $locationProvider) {
  $routeProvider
          .when("/", {redirectTo: "/kategoria//1"})
          .when("/kategoria/:kategoriaKod?/:page?",{
              templateUrl: "produktList.jsp",
          })
          .when("/produkt/:produktKod",{
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