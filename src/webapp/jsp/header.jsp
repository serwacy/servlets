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
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">Otomoto</a>
        </div>
        <c:if test="${sessionScope.user!=null}">
            <ul class="nav navbar-nav">
                    <%--                <li class="active"><a href="/home">Home</a></li>--%>
                <li><a href="/create-ad">Create AD</a></li>
                <li><a href="/your-ads">Your Ads</a></li>
                <li><a href="/all-ads">All Ads</a></li>
            </ul>
            <div class="navbar-header" style="float: right">
                <div class="navbar-header">
                    Witaj, ${user.name}!
                </div>
                <div class="navbar-header">
                    <a class="navbar-brand" href="/logout">Logout</a>
                </div>
            </div>
        </c:if>

        <c:if test="${sessionScope.user==null}">
            <ul class="nav navbar-nav" style="float: right">
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Register</a></li>
            </ul>
        </c:if>

    </div>
</nav>
