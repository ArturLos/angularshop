<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="row" ng-controller="KatalogController as katalog" ng-init="katalog.loadProdukty()">
  <row>
      <div class="col-md-12">
        <table>
        </table>
      </div>
      <div class="col-md-4" ng-repeat="produkt in ::katalog.produkty">
        <div class="panel panel-primary fixed-panel">
          <div class="panel-heading "><span class="panel-title">{{::produkt.nazwa}}</span></div>
          <div class="panel-body fixed-panel-body">
            <div bo-if="::produkt.obrazek.length > 0">
              <img ng-src="{{::produkt.obrazek[0]}}" class="kafelek_produktu_img center-block img-responsive"/>
            </div>
            <div>{{::produkt.krotkiOpis}}</div>
          </div>
          <div class="panel-footer"><a href="#/produkt/{{::produkt.kod}}">Szczegóły</a></div>
        </div>
      </div>
  </row>
  <row>
    <div class="col-md-12 text-center">
      <uib-pagination force-ellipses="true" rotate="true"
                      max-size="katalog.maxSize" direction-links="true" boundary-link-numbers="true" items-per-page="katalog.itemsPerPage"
                      total-items="katalog.totalItems" ng-model="katalog.currentPage"
                      ng-change="katalog.zmienionoStrone()"
                      ></uib-pagination>
    </div>
  </row>
</div>