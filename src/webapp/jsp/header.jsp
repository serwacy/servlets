<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
   <title>Otomoto page</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
   <div class="container-fluid">
      <div class="navbar-header">
         <a class="navbar-brand" href="/home">MyOtomoto</a>
      </div>
      <c:if test="${sessionScope.user!=null}">
         <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
            <li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="#">Adverts
                  <span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="/panel/my-ads">My Ads</a></li>
                  <li><a href="/panel/all-ads">All Ads</a></li>
               </ul>
            </li>
            <li><a href="/panel/create-ad">Create AD</a></li>
            <li><a href="/panel/users">Users</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Witaj, ${user.name}!</p></li>
            <li><a href="/panel/logout">Logout</a></li>
         </ul>
      </c:if>

      <c:if test="${sessionScope.user==null}">
         <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
         </ul>
      </c:if>
   </div>
</nav>
