<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<div class="container">
    <c:forEach items="${requestScope.adverts}" var="advert">
        <div>
            ${advert.user.name}
        </div>
    </c:forEach>
</div>

</body>
</html>