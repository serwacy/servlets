<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
    <c:if test="${not empty requestScope.loginExists}">
        Login: ${requestScope.loginExists} already exists in system
    </c:if>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" placeholder="Enter login" name="login">
            <c:if test="${not empty requestScope.noSuchLogin}">
                Login: ${requestScope.noSuchLogin} does not exist
            </c:if>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            <c:if test="${not empty requestScope.wrongPassword}">
                Wrong password
            </c:if>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>