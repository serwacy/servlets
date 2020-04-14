<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
    <c:if test="${requestScope.content=='error'}">
        Something went wrong. Please try again.
    </c:if>
    <form action="/create-ad" method="post">
        <div class="form-group">
            <label for="production-year">Year of production:</label>
            <input type="number" id="production-year" class="form-control" name="production-year"
                   min="1900" max="2020" step="1" value="2020" />
        </div>
        <div class="form-group">
            <label for="company">Company:</label>
            <input type="text" id="company" class="form-control" placeholder="Enter company" name="company">
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
            <input type="text" class="form-control" id="price" placeholder="Enter your price" name="price">
            <select id="currency" name="currency" size="1">
                <option value="PLN">PLN</option>
                <option value="EUR">EUR</option>
            </select>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
