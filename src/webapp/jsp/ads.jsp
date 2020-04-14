<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
    <c:forEach items="${requestScope.adverts}" var="advert">
        <div>
            <h3>${advert.car.company} ${advert.car.model}</h3>
            <p>
                Mileage:  ${advert.car.mileage}
            </p>
            <p>
                Year of production:  ${advert.car.productionYear}
            </p>
            <p>
                <a href="#" class="btn btn-primary">${advert.price} ${advert.currency}</a><br />
                <br /><span>Posted by: ${advert.user.name} ${advert.user.surname}</span>
                <br /><span>Created at: ${advert.createdAt}</span>
            </p>
        </div>
    </c:forEach>
</div>

</body>
</html>