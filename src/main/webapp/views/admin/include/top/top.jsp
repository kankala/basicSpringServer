<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- top 시작-->
<header>
	<div id="navline">
		
		<div>
			<span>${user.ip} &nbsp;<b>[&nbsp;${user.id}&nbsp;]</b>&nbsp; 님 안녕하세요.</span>
			<a href="/login/logout.do"><span>로그아웃</span></a>
		</div>
		<div>
			<a href="/admin/product/index.do"><span>상품</span></a>
		</div>
	</div>
</header>
<!-- top 끝-->
<input type="hidden" id="ulHidden" value="${user.level}">






