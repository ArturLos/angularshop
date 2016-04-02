<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div ng-controller="ZamowienieController as zamowienieController" ng-init="zamowienieController.getZamownienie()">
  <h2 class="mt0">Zamówienie/Podsumowanie zamówienia</h2>
  <hr/>
  <form name="zamowienieController.zamowienieFormularz" role="form" class="form-horizontal">
    <div id="listaZamowionychProduktow" class="panel panel-default">
      <div class="panel-heading"><span class="panel-title">Zamówione produkty</span></div>
      <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
          <tr>
            <th>lp</th>
            <th>nazwa</th>
            <th>opis</th>
            <th>cena</th>
            <th>akcje</th>
          </tr>
          </thead>
          <tbody>
          <tr ng-repeat="produkt in zamowienieController.zamowienie.produkty">
            <td>{{$index + 1}}</td>
            <td>{{produkt.nazwa}}</td>
            <td>{{produkt.krotkiOpis}}</td>
            <td></td>
            <td></td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div id="adresat" class="panel panel-default">
      <div class="panel-heading"><span class="panel-title">Adres dostawy</span></div>
      <div class="panel-body">
        <div class="form-group">
          <label for="imie" class="control-label col-md-2">Imie</label>
          <div class="col-md-6"><input id="imie" name="imie" class="form-control"
                                       ng-model="zamowienieController.zamowienie.daneDostawy.imie" placeholder="Jan"/>
          </div>
        </div>
        <div class="form-group">
          <label for="nazwisko" class="control-label col-md-2">Nazwisko</label>
          <div class="col-md-6"><input id="nazwisko" name="nazwisko" class="form-control"
                                       ng-model="zamowienieController.zamowienie.daneDostawy.nazwisko"
                                       placeholder="Kowalski"/></div>
        </div>
        <div class="form-group">
          <label for="adres" class="control-label col-md-2">Adres</label>
          <div class="col-md-6"><input id="adres" name="adres" class="form-control"
                                       ng-model="zamowienieController.zamowienie.daneDostawy.adres"
                                       placeholder="Zabrze 00-250, ul. Zawojska 75"/></div>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-offset-4 col-md-4">
        <div class="center-block">
          <button type="submit" class="btn btn-success btn-block" ng-click="zamowienieController.wyslij()">
            Wyślij
          </button>
        </div>
      </div>
    </div>
  </form>
</div>