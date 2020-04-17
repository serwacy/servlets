<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<c:if test="${requestScope.filters=='active'}">
   <form action="/all-ads" method="post">
      <div class="row">
         <div class="col-sm-2">
            <label for="make">Make:</label><br />
            <select id="make" name="make" size="1">
               <option value="any">Choose make:</option>
               <option value="Mercedes">Mercedes</option>
               <option value="Ford">Ford</option>
               <option value="Suzuki">Suzuki</option>
               <option value="Mazda">Mazda</option>
               <option value="BMW">BMW</option>
               <option value="Nissan">Nissan</option>
            </select>
         </div>
         <div class="form-group col-sm-2 col-md-3">
               <label for="price-min">Price:</label>
               <div class="d-flex flex-row">
                  <input type="text" class="w-50" id="price-min" placeholder="From" name="price-min">
                  <input type="text" class="w-50" id="price-max" placeholder="To" name="price-max">
               </div>
         </div>
         <div class="form-group col-sm-2 col-md-3">
               <label for="mileage-min">Mileage:</label>
               <div class="d-flex flex-row">
                  <input type="text" class="w-50" id="mileage-min" placeholder="From" name="mileage-min">
                  <input type="text" class="w-50" id="mileage-max" placeholder="To" name="mileage-max">
               </div>
         </div>
         <div class="form-group col-sm-2 col-md-3">
               <label for="production-year-min">Year of production:</label>
            <div class="d-flex flex-row">
               <input type="number" id="production-year-min" class="w-50" name="production-year-min"
                      min="1900" max="2020" step="1" value="1900"/>
               <input type="number" id="production-year-max" class="w-50" name="production-year-max"
                      min="1900" max="2020" step="1" value="2020"/>
            </div>
         </div>
      </div>
      <div class="row">
         <div class="col-sm-2">
            <button type="submit" class="btn btn-primary">Filter</button>
         </div>
      </div>
   </form>
</c:if>
<div class="container">
   <c:if test="${requestScope.isEmpty=='empty'}">
      <div class="alert alert-warning">
         No results!
      </div>
   </c:if>
   <div class="row">
      <c:forEach items="${requestScope.adverts}" var="advert">
         <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
               <h3>${advert.car.make} ${advert.car.model}</h3>
               <p>
                  Mileage: ${advert.car.mileage}
               </p>
               <p>
                  Year of production: ${advert.car.productionYear}
               </p>
               <p>
                  <a href="#" class="btn btn-primary">${advert.price} ${advert.currency}</a><br/>
                  <br/><span>Posted by: ${advert.user.name} ${advert.user.surname}</span>
                  <br/><span>Created at: ${advert.createdAt}</span>
               </p>
            </div>
         </div>
      </c:forEach>
   </div>
</div>

</body>
</html>