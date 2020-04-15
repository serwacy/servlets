<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
   <div class="row">
      <div class="col-sm-4">
         <form action="/login" method="post">
            <div class="form-group">
               <label for="login">Login:</label>
               <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                  <input id="login" type="text" class="form-control" name="login" placeholder="Enter login">
               </div>
               <c:if test="${not empty requestScope.noSuchLogin}">
                  <div class="alert alert-danger">
                     Login: ${requestScope.noSuchLogin} does not exist!
                  </div>
               </c:if>
            </div>
            <div class="form-group">
               <label for="password">Password:</label>
               <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input id="password" type="password" class="form-control" name="password"
                         placeholder="Enter password">
               </div>
               <c:if test="${not empty requestScope.wrongPassword}">
                  <div class="alert alert-danger">
                     Wrong password!
                  </div>
               </c:if>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
         </form>
      </div>
   </div>
</div>

</body>
</html>