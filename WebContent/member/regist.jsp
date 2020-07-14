<%@page import="com.pet.model.product.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Product> productList=(List)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<title>Pet Shop</title>
<meta charset="utf-8">
<link href="/css/style.css" rel="stylesheet" type="text/css">
<!--[if IE 6]><link href="css/ie6.css" rel="stylesheet" type="text/css"><![endif]-->
<!--[if IE 7]><link href="css/ie7.css" rel="stylesheet" type="text/css"><![endif]-->
<style>
.pic{
	width:50%;
	height:250px;
	background:yellow;
	float:left;
	margin-top:50px;
}
.spec{
	width:50%;
	height:250px;
	background:green;
	float:left;
	margin-top:50px;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  margin-top:50px;
}
th, td {
  text-align: left;
  padding: 16px;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
#buyer{
	width:48%;
	border:2px solid red;
	display:inline-block;
}
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<div id="header"> 
	<%@ include file="/include/main_navi.jsp" %>
</div>
<div id="body">
  <div class="banner">&nbsp;</div>
  <div id="content">
    <div class="content">
    <div id="buyer">
	    <input type="text" id="fname" name="firstname" placeholder="주문자 명">
	    <input type="text" id="lname" name="lastname" placeholder="주문자 연락처">
	    <input type="text" id="lname" name="lastname" placeholder="이메일">
	    <select id="country" name="country">
	      <option value="0">결제방법</option>
	      <option value="card">신용카드</option>
	      <option value="online">온라인 입금</option>
	      <option value="phone">핸드폰 결제</option>
	    </select>
    </div>
      <ul>
      
      </ul>
    </div>
    <div id="sidebar">
      <div class="search">
        <input type="text" name="s" value="Find">
        <button>&nbsp;</button>
        <label for="articles">
          <input type="radio" id="articles">
          Articles</label>
        <label for="products">
          <input type="radio" id="products" checked>
          PetMart Products</label>
      </div>
      <div class="section">
        <ul class="navigation">
          <li class="active"><a href="#">Shopping Guides</a></li>
          <li><a href="#">Discounted Items</a></li>
        </ul>
        <div class="aside">
          <div>
            <div>
              <ul>
                <li><a href="#">Pet Accesories </a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Bath Essentials</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Food</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Vitamins</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Needs</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Toy and Treats</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Supplies</a> <a class="more" href="#">see all</a></li>
                <li><a href="#">Pet Emergency Kit</a> <a class="more" href="#">see all</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="featured">
    <ul>
      <li><a href="#"><img src="images/organic-and-chemical-free.jpg" width="300" height="90" alt=""></a></li>
      <li><a href="#"><img src="images/good-food.jpg" width="300" height="90" alt=""></a></li>
      <li class="last"><a href="#"><img src="images/pet-grooming.jpg" width="300" height="90" alt=""></a></li>
    </ul>
  </div>
</div>
<div id="footer">
  <%@ include file="/include/footer.jsp" %>
</div>
</body>
</html>