<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Test 1st</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/www/css/w3.css" >
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
$(function(){
	$('#btn').click(function(){
		var mno = $('#mno').val();
		
		$.ajax({
			url : "/www/member/showNameProc.van",
			type : "post",
			dataType : "json",
			data : {
				"mno" : mno	
			},
			success : function(data){
				var name = data;
				$('#name').text(name);
			},
			error : function(request, status, error){
				alert("@@@@@@code : "+request.status+"@@@@@@@\n"+" ######## message:"+request.responseText+"#########\n"+"$$$$$$error:"+error);
			}
		});
	});
	
});
</script>

</head>
<body>
<div class="w3-col">
	<div class="w3-col m6 w3-center w3-margin-top" >
		<div class="w3-col w3-card w3-padding">
			<div class="w3-col">
				<label for="id" class="w3-col m2 w3-right-align w3-center h1">
					<span class="w3-span w3-center"> 회원번호 : </span>
				</label>
				<div class="w3-col m10 w3-padding">
					<input class="w3-input w3-border" type="text" id="mno" name="mno">
				</div>
			</div>
		</div>
		<div><p id="name"></p></div>
		<div class="w3-col w3-margin-top">
		<input class="w3-button m2 w3-blue w3-right" type="submit" id="btn" value="이름확인">
		</div>
	</div>
	<div class="w3-col m6" ><p></p></div>
</div>
	<ul>
		<c:forEach var="data" items="${LIST}">
			<li>${data.id}   ${data.joinDate} </li>
		</c:forEach>
	</ul>
	
	
</body>
</html>