<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <c:if test="${requestScope.content=='register_successful'}">
      <div class="alert alert-success">
         Register successful.
      </div>
   </c:if>
   <c:if test="${requestScope.content=='advert_added'}">
      <div class="alert alert-info">
         Advert added.
      </div>
   </c:if>
   <c:if test="${(requestScope.content=='home' || sessionScope.user!=null) && requestScope.content!='advert_added'}">
      <div class="row">
         <div class="col-sm-4">
            <img src="https://bi.im-g.pl/im/60/c8/17/z24937568Q,Opel-Corsa-2020.jpg" class="img-thumbnail" alt="Home">
         </div>
         <div class="col-sm-8">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Phasellus rhoncus, erat ac rhoncus blandit, metus elit pellentesque lacus, eu varius tortor nibh vel massa.
            Morbi a interdum ipsum, sit amet euismod lorem. Integer vel diam viverra, semper nisl ut, mollis est.
            Donec non aliquet risus. Ut fermentum dui feugiat aliquet accumsan.
            Suspendisse potenti. Proin eget lorem quis nulla dignissim sagittis.
            Suspendisse mi ex, eleifend eget auctor eget, accumsan vitae nunc.
            Quisque fringilla, sapien vitae semper congue, sapien est scelerisque erat, et malesuada ipsum nisl a nisi.
            Nulla finibus sodales neque vitae ornare. Mauris venenatis ligula ante, sit amet porta libero consequat a.
            Suspendisse vehicula, ex ac auctor porta, quam dolor tincidunt augue, nec facilisis leo felis quis leo.
            Mauris in efficitur orci.
         </div>
      </div>
   </c:if>
</div>

</body>
</html>