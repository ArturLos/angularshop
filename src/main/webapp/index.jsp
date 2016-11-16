<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html ng-app="AngularSHOP" lang="pl">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="bootstrap-lib/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="bootstrap-lib/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
  <link href="css/default.css" rel="stylesheet" type="text/css"/>
  <!-- bower:js -->
  <script src="bower_components/angular/angular.js"></script>
  <script src="bower_components/angular-route/angular-route.js"></script>
  <script src="bower_components/angular-sanitize/angular-sanitize.js"></script>
  <script src="bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
  <script src="bower_components/angular-animate/angular-animate.js"></script>
  <!-- endbower -->
  <script src="${pageContext.request.contextPath}/js/angularshop.js"></script>
  <script src="${pageContext.request.contextPath}/js/katalog/Katalog.js"></script>
  <script src="${pageContext.request.contextPath}/js/kategoria/Kategoria.js"></script>
  <script src="${pageContext.request.contextPath}/js/produkt/Produkt.js"></script>
  <script src="${pageContext.request.contextPath}/js/zamowienie/Zamowienie.js"></script>
  <title>Angular SHOP</title>
</head>
<body>

<div id="head" class="jumbotron" style="margin-bottom: 0px;">
  <div class="container">
    <h1><a href="#/" style="text-decoration: none;">Angular SHOP</a></h1>
    <p>Wszystko żeby dobrze się bawić ...</p>
  </div>
</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#/zamowienie"><span class="glyphicon glyphicon-shopping-cart"></span> Twoje Zamowienie</a></li>
    </ul>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-2">
      <ng-include src="'kategorieList.jsp'"/>
    </div>
    <div id="body" class="col-md-10" ng-view></div>
  </div>
</div>
<div id="footer" class="container-fluid clearfix"><p>Copyright: Arti</p></div>
</body>
</html>
