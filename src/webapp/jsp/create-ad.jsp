<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
   <div class="row">
      <div class="col-sm-6">
         <c:if test="${requestScope.content=='error'}">
            <div class="alert alert-warning">
               Something went wrong. Please try again.
            </div>
         </c:if>
         <form action="/create-ad" method="post">
            <div class="form-group">
               <label for="production-year">Year of production:</label>
               <input type="number" id="production-year" class="form-control" name="production-year"
                      min="1900" max="2020" step="1" value="2020"/>
            </div>
            <div class="form-group">
               <label for="make">Make:</label>
               <input type="text" id="make" class="form-control" placeholder="Enter make" name="make">
            </div>
            <div class="form-group">
               <label for="model">Model:</label>
               <input type="text" class="form-control" id="model" placeholder="Enter model" name="model">
            </div>
            <div class="form-group">
               <label for="mileage">Mileage:</label>
               <input type="text" class="form-control" id="mileage" placeholder="Enter mileage" name="mileage">
            </div>
            <div class="form-group">
               <label for="price">Price:</label>
               <div class="input-group">
                  <input type="text" class="form-control" id="price" placeholder="Enter your price" name="price">
                  <span class="input-group-addon">
                     <select id="currency" name="currency" size="1">
                        <option value="PLN">PLN</option>
                        <option value="EUR">EUR</option>
                     </select>
                  </span>
               </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
         </form>
      </div>
   </div>
</div>

</body>
</html>
