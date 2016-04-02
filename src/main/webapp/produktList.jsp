<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="row" ng-controller="KatalogController as katalog" ng-init="katalog.loadProdukty()">
  <div class="col-md-4" ng-repeat="produkt in ::katalog.produkty">
    <div class="panel panel-primary fixed-panel">
      <div class="panel-heading "><span class="panel-title">{{::produkt.nazwa}}</span></div>
      <div class="panel-body fixed-panel-body">
        <div bo-if="::produkt.obrazek.length > 0">
          <img ng-src="{{::produkt.obrazek[0]}}" class="kafelek_produktu_img center-block img-responsive"/>
        </div>
        <div>{{::produkt.krotkiOpis}}</div>
      </div>
      <div class="panel-footer"><a href="#/produkt/{{::produkt.id}}">Szczegóły</a></div>
    </div>
  </div>
</div>