<%@page import="com.pet.model.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Product product=(Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<title>Pet Shop</title>
<meta charset="utf-8">
<link href="/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
.pic {
   width: 50%;
   height: 250px;
   background: #ffc;
   float: left;
   margin-top: 50px;   
}
.spec {
   width: 50%;
   height: 250px;
   background: yellow;   
   float: left;
   margin-top: 50px;
}
</style>
</head>
<body>
   <div id="header">
      <a href="#" id="logo"><img src="/images/logo.gif" width="310"
         height="114" alt=""></a>
      <%@include file="/include/main_navi.jsp"%>
   </div>
   <div id="body">
      <div id="content">
         <!-- 장바구니 -->
       
      </div>
      <div class="featured">
         <ul>
            <li><a href="#"><img
                  src="images/organic-and-chemical-free.jpg" width="300" height="90"
                  alt=""></a></li>
            <li><a href="#"><img src="images/good-food.jpg" width="300"
                  height="90" alt=""></a></li>
            <li class="last"><a href="#"><img
                  src="images/pet-grooming.jpg" width="300" height="90" alt=""></a></li>
         </ul>
      </div>
   </div>
   <div id="footer">
      <%@include file="/include/footer.jsp"%>
   </div>
</body>
</html>