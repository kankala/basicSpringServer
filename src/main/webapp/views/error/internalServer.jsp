<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>오류페이지</title>
	<style>
        body {
            font-family:"Malgun Gothic";
            background:#F9F9FB;
            margin:30px;
        }
        .h1Text {
            display:inline-block;
            position:relative;
            font-size:20px;
            left:52px;
            top:-10px;
            color:#133B68;
            min-width:1000px;
            max-width:100%;
            border-bottom:2px solid #133B68;
        }
        .h1Text span {
            position:relative;
            top:-15px;
            left:-60px;
        }
        .errorContents{
            position:relative;
            left:30px;
            font-size:14px;
            color:#666;
            margin-left:20px;
            line-height:26px;
        }
        img {
            position:relative;
            left:-62px;
            width:52px;
            height:52px;
            display:inline;
        }
    </style>
</head>
<body>

<div class="h1Text">
    <img src="/resources/image/errorI.jpg" alt="">
	<span>웹 페이지를 표시할 수 없습니다. </span>
</div>
<p class="errorContents">
    오류가 발생하였습니다.(internalServer)
    <br>
    관리자에게 연락바랍니다.
    <br>
    Tel) 011 - 843 - 3329
</p>
<a href="/admin/index.do"><button type="button">돌아가기</button></a>
</body>

</html>
