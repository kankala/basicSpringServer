<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>경고페이지</title>
	
	<style>
        body {
            font-family:"Malgun Gothic";
            background:#Fff;
            margin:30px;
            width:100%;
            height:100%;
            position:relative;
        }
        .fullBox {
            position:relative;
            margin:0 auto;
            
            width:670px;
            height:200px;
            border:2px solid #f87777;
        }
        .innerBox {
            position:relative;
            margin:0 auto;
            margin-top:30px;
            width:600px;
        }
        .h1Text {
            display:inline-block;
            position:relative;
            font-size:20px;
            left:67px;
            top:-10px;
            color:#660000;
            min-width:500px;
            border-bottom:2px solid #660000;
        }
        .errorContents{
            position:relative;
            left:45px;
            font-size:14px;
            color:#666;
            margin-left:20px;
            line-height:26px;
        }
        .h1Text span {
            position:relative; 
            top:-15px;
            left:-60px;
        }
        
        img {
            position:relative;
            width:60px;
            top:6px;
            left:-62px;
            display:inline;
        }
    </style>
</head>
<body>
<div class="fullBox">
    <div class="innerBox">
        <div class="h1Text">
            <img src="/resources/image/XwarnningI.jpg" alt="">
            <span>불법클릭사용자로 의심됩니다. </span>
        </div>
        <p class="errorContents">
            광고클릭을 반복할 시, 불법클릭사용자로 의심되어 신고되실 수 있습니다.
            <br>
            불이익을 당하지 않도록 즐겨찾기 해주시기 바랍니다.
        </p>
    </div>
</div>


</body>

</html>
