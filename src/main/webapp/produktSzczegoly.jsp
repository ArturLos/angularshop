<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div ng-controller="ProduktController as produktController">
  <div class="row">
    <div class="col-sm-12" >
      <h2 class="mt0">{{produktController.produkt.nazwa}}</h2>
      <hr/>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3" ng-repeat="obrazek in produktController.produkt.obrazek track by $index">
      <div class="thumbnail">
        <img ng-src="{{obrazek}}"/>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-12">
      <p ng-bind-html="produktController.produkt.opis"></p>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-12 form-group">
      <input type="submit" name="zamawiam" value="Zamawiam" class="btn btn-default"
             ng-click="produktController.zamow()"/>
    </div>
  </div>
</div>