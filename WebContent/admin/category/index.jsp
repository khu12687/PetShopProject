<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/admin.css">
<style >
select{
	width:200px;
	height:150px;
	
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
		}
		
	});
}
</script>
</head>
<body bgcolor="yellow">
<%@ include file="/admin/inc/main_navi.jsp" %>
<div>
	<input type "text" name="category_name" placeholder="카테고리 입력"/>
	<button>등록</button>
	<p>
		<select multiple="multiple"></select>
	</p>
	<button>수정</button>
	<button>삭제</button>
</div>
</body>
</html>