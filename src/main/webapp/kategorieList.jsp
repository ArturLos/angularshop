<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div>
  <h4>Kategorie</h4>
</div>
<nav class="navbar navbar-default" ng-controller="KategoriaController as kategoriaController">
  <ul class="nav nav-pills nav-stacked">
    <li ng-repeat="kategoria in ::kategoriaController.kategorie" ng-class="{active : kategoriaController.isActive(kategoria.kod)}">
      <a href="#/kategoria/{{::kategoria.kod}}">{{::kategoria.nazwa}}</a>
    </li>
  </ul>
</nav>