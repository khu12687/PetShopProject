<%@page import="java.util.List"%>
<%@page import="com.pet.model.product.Product"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%List<Product> productList = (List)request.getAttribute("productList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/admin.css">
<style >
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
		$($("button")[0]).click(function(){
			regist();
		});
		$($("button")[1]).click(function(){
			edit();
		});
		$($("button")[2]).click(function(){
			del();
		});
		$($("button")[3]).click(function(){
			getList();
		});
});

//jquery가 ajax도 지원한다!!
//기존의 순수 자바스크립트를 이용하는 것보다 코드량이 현저히 줄어든다
function regist(){
	$.ajax({
		"url":"/category/regist",
		"type":"post",
		"data":{
			category_name:$("input[name='category_name']").val()
		},
		success:function(data){
			alert("서버에서 온 응답 데이터는 "+data);
			
			//리스트 보여주기!!
			
		}
		
	});
}

//비동기로 데이터 가져오기!
function getList(){
	$.ajax({
		"url":"/category/list",
		"type":"get",
		success:function(result){
			console.log(result);
			
			var json = JSON.parse(result);
			alert(result);
			$("select").empty(); //비우기!
			
			for(var i=0; i<json.categoryList.length; i++){
				var obj = json.categoryList[i];
				$("select").append("<option value='"+obj.category_id+"'>"+obj.category_name+"</option>");
			}
		}
	
	});
}

//비동기로 삭제하기!!
function del(){
	if(confirm($("select").val()+"를 삭제하실래요?")){
	$.ajsax({
		"url":"/category/del?category_id="+$("select").val(),
		"type":"get",
		success:function(result){
			if(result==1){
				alert("삭제되었습니다");
				getList();
			}else{
				alert("삭제에 실패하였습니다.\n 관리자에 문의하세요")
			}
		}
	});
	}
}
</script>
</head>
<body>
<%@ include file="/admin/inc/main_navi.jsp" %>

<table>
  <tr>
    <th>No</th>
    <th>이미지</th>
    <th>카테고리</th>
    <th>상품명</th>
    <th>가격</th>
    <th>브랜드</th>
  </tr>
  <%for(int i=0;i<productList.size();i++){ %>
  <%Product product = productList.get(i); %>
  <tr>
    <td>1</td>
    <td><img src="/data/<%=product.getFilename()%>" width="35px"/></td>
    <td><% %></td>
    <td><%=product.getProduct_name() %></td>
    <td><%=product.getPrice() %></td>
    <td><%=product.getBrand() %></td>
  </tr>
  <%} %>
  <tr>
  	<td colspan="6" align="center">
  		<button onclick="location.href='/admin/product/registForm.jsp';">상품등록</button>
  	</td>
  </tr>
</table>

</body>
</html>