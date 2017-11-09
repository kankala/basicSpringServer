<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<tiles:insertAttribute name="head"/>

<title>
<tiles:insertAttribute name="title" ignore="true" />
</title>
</head>
<body>
	<div class="wrap">
		<form:form action="/admin/index.do" modelAttribute="admin" method="post">
		<tiles:insertAttribute name="top" />
		<div class="wrap_main">
			<%-- <tiles:insertAttribute name="leftmenu" /> --%>
			
			
			
			
		</div>
		<tiles:insertAttribute name="footer" />
		</form:form>
	</div>
</body>

</html>
