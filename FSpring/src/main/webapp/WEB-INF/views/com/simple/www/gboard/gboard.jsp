<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Test 1st</title>
<c:if test="${empty SID}">
	<meta http-equiv="Refresh" content="2;url=/www/member/login.van" />
</c:if>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/www/css/w3.css" >
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
$(function(){
	$('#cancel').click(function(){
		$(location).attr('href', '/www/gboard/gboard.van');
	});
	
	function s1(){
		var db = $('#body').val();
		
		if(!db){
			alert('필수 입력 사항을 확인하세요!');
			return;
		}
		
		$('#frm').attr('method', 'post');
		$('#frm').attr('action', '/www/gboard/gboardWrite.van');
		$('#frm').submit();
	}
	
	$('#submit').click(s1);
});
</script>
<script type="text/javascript">
$(function(){
	var cnt = "<c:out value='${cnt}'/>";
	var total = "<c:out value='${total}'/>";
	console.log(cnt);
	console.log(total);
	if(cnt=="0"){
		alert("방명록은 한번만 작성 가능합니다!");
	}
})
</script>

</head>
<body>
<div class="w3-col w3-padding w3-margin-bottom">
	<form id="frm" class="w3-col w3-card" >
		<input type="hidden" id="id" name="gid" value="${SID}" >
		<div class="w3-row">
			<h4 class="w3-col m2 w3-right-align">방명록 : </h4>
			<div class="w3-col m10 w3-padding">
				<textarea class="w3-input w3-border" id="body" name="gbody" 
							placeholder="글 내용 입력" 
							cols="50" rows="10" style="resize: none"></textarea>
			</div>
		</div>
	</form>
	<div class="w3-col w3-margin-top">
		<div class="w3-button w3-small w3-red w3-hover-amber w3-left" id="cancel" >cancel</div>
		<div class="w3-button w3-small w3-green w3-hover-lime w3-right" id="submit">글등록</div>
	</div>
</div>
<br>
<ul>
	<c:forEach var="data" items="${LIST}">
		<li>${data.gid} : ${data.gbody} </li>
	</c:forEach>
</ul>
<!-- <div class="w3-center"> -->
<!-- 	<div class="w3-bar w3-border w3-margin-top w3-margin-bottom"> -->
<!-- 	  <div class="w3-bar-item w3-hover-blue pbutton" id="startbtn">&laquo;</div> -->
<%-- 	  <c:forEach var="page" begin="1" end="${total}/3" varStatus=""> --%>
<%-- 	  	<div class="w3-bar-item w3-hover-blue pbutton">"${page}"</div> --%>
<%-- 	  </c:forEach> --%>
<!-- 	  <div class="w3-bar-item w3-hover-blue pbutton" id="endbtn">&raquo;</div> -->
<!-- 	</div> -->
<!-- </div> -->
	
<c:if test="${empty SID}">
	<div class="w3-col m6 w3-center" id="d1">
		<h3>로그인해야 방명록작성이 가능합니다.</h3>
		<h6>메인 페이지로 이동합니다.</h6>
	</div>
</c:if>
</body>
</html>