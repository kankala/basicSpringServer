<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- top 시작-->
<header>
	<div id="img"><img src="/resources/image/common/logo.png">
		<ul class="icons">
			<li><span id="logout"><a href="/login/logout.do"><span class="fui-power"></span></a></span></li>
			<li><a href="#"><span class="fui-home"></span></a></li>
		</ul>
	</div>
	<div id="navline">
		<div id="topInfo">
			<span>${user.ip} &nbsp;<b>[&nbsp;${user.id}&nbsp;]</b>&nbsp; 님 안녕하세요.</span>
		</div>
	</div>
</header>
<!-- top 끝-->
<input type="hidden" id="ulHidden" value="${user.level}">






