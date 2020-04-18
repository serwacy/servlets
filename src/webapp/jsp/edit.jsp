<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
   <form action="/panel/edit" method="post">
      <table class="table table-striped">
         <thead>
         <tr>
            <th>Name</th>
            <th>Surname</th>
         </tr>
         </thead>
         <tbody>
         <tr>
            <td>${sessionScope.user.name}</td>
            <td>${sessionScope.user.surname}</td>
         </tr>
         <tr>
            <td>
               <label for="name">New name:</label>
               <input type="text" id="name" class="form-control" placeholder="Enter new name" name="name">
            </td>
            <td>
               <label for="surname">New surname:</label>
               <input type="text" id="surname" class="form-control" placeholder="Enter new surname" name="surname">
            </td>
         </tr>
         </tbody>
      </table>
      <div class="btn-group">
         <button type="submit" class="btn btn-primary">Submit</button>
         <a href="/panel/users" class="btn btn-danger" role="button">Cancel</a>
      </div>
   </form>
</div>

</body>
</html>