<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
   <table class="table table-striped">
      <thead>
      <tr>
         <th>Name</th>
         <th>Surname</th>
         <th>Login</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${requestScope.users}" var="user">
         <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.login}</td>
            <td><a href="/panel/edit?login=${user.login}" data-toggle="tooltip" data-placement="top" title="Edit user">
               <span class="glyphicon glyphicon-pencil"></span></a></td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
</div>

<script>
   $(document).ready(function(){
      $('[data-toggle="tooltip"]').tooltip();
   });
</script>

</body>
</html>
