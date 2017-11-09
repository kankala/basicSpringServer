<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>

<html>
<head>
	<title>홈페이지에 오신걸 환영합니다.</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv='cache-control' content='no-cache'>
	<meta http-equiv='expires' content='0'>
	<meta http-equiv='pragma' content='no-cache'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>
	<tiles:insertAttribute name="title" ignore="true" />
	</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="/resources/css/nomalize.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
<script src="/resources/js/jquery-ui-1.10.1.js" type="text/javascript"></script>
 

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="/resources/js/placeHolders.js" type="text/javascript"></script>
<link href="/resources/css/login-css.css" type="text/css" rel="stylesheet">


</head>
<body>
<div class="fullBgBox">
<div id="wrapper"> 
	
		<div id="contents">
       		<!---플러스 배너 시작------->
			<div class="banner">
				
			</div>
			<!---플러스 배너 시작------->
			
			<!-----로그인 시작------>
			<form:form id="loginForm" modelAttribute="login" action="/login/go.do"  method="POST">
			<form:errors path="*" cssClass="alert alert-danger errorblock" element="div" />
			<c:if test="${loginFail eq 'fail'}">
			<div class="alert alert-danger errorblock">
			아이디나 비밀번호가 틀렸습니다.
			</div>	
			</c:if>
	  		<div class="inputBox">
	    		<div class="login">
					
					<div class="id"><span>ID</span>
						<div class="inputDiv"><form:input path="id" type="text" class="form-control rowMargin row1Input" placeholder="아이디" style="width:140px; height:30px; line-height:20px;" autofocus="autofocus"></form:input></div>	
			  		</div>
			  		<div class="pw"><span>PW</span>
						<div class="inputDiv"><form:input path="password" type="password" class="form-control rowMargin row2Input" placeholder="비밀번호" style="width:140px; height:30px; line-height:20px;"></form:input></div>			
					</div>
			  		<div class="btnLogin">
			  			<button id="loginSubmit" class="btn1 buttonImg"  type="submit">Login
			  			</button>
			  		</div>
			 	</div>
			</div>
			</form:form>
			
    		<!-----로그인 시작------>

			<!---플러스 배너 시작------->
        	<div class="banner1">
        		
        		
				
			</div>
			<!---플러스 배너 시작------->
		
		</div>


	<!-----카피라이터------------->
	<div id="footer">
		<div class="footerInner">
	    	<address>
				<span class="addr"></span><br/>
	      		<span class="addr"></span>
	      	</address>
	    </div>
	</div>
	<!-----카피라이터------------->
	
	
	
</div>
</div>



<script src="/resources/js/bootstrap.js"></script>



</body>
</html>
