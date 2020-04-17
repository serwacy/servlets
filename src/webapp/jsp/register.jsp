<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
   <div class="row">
      <div class="col-sm-6">
         <form action="/register" method="post">
            <div class="form-group">
               <label for="name">Name:</label>
               <input type="text" id="name" class="form-control" placeholder="Enter name" name="name">
            </div>
            <div class="form-group">
               <label for="surname">Surname:</label>
               <input type="text" id="surname" class="form-control" placeholder="Enter surname" name="surname">
            </div>
            <div class="form-group">
               <label for="login">Login:</label>
               <input type="text" class="form-control" id="login" placeholder="Enter login" name="login">
               <c:if test="${not empty requestScope.loginExists}">
                  <div class="alert alert-danger">
                     Login: ${requestScope.loginExists} already exists in system!
                  </div>
               </c:if>
            </div>
            <div class="form-group">
               <label for="password">Password:</label>
               <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
         </form>
      </div>
   </div>
</div>

</body>
</html>

