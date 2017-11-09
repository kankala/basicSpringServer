<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!doctype html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.4/themes/smoothness/jquery-ui.css" type="text/css" media="all">
	<link rel="shortcut icon" href="/resources/image/plusPaviP.ico">
	
	<link rel="stylesheet" href="/resources/css/possibleArea.css">
	<link rel="stylesheet" href="/resources/css/api/manual.css"> 
	
	<script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.0/jquery-ui.min.js"></script>
	
	
	
	
	<!-- <script src="/resources/js/jquery-ui-1.10.1.js" type="text/javascript"></script> -->
	<script src="/resources/js/placeHolders.js" type="text/javascript"></script>
	<script src = "/resources/js/jQueryRotate.min.js"></script>
	<script src="/resources/js/jquery.form.js" type="text/javascript"></script>
	
	<script src="/resources/js/sugar.min.js" type="text/javascript"></script>
	
	 
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script src="/resources/js/api/manual.js" type="text/javascript"></script>
</head>
<body>
	<section><!-- 전체 사이즈 레이어 --> 
		<div class="container">
			<div class="row">
				<div class="col-xs-12 bg-primary"><h1>CGV log counter API</h1></div>
			</div>
			<div class="row">
			  	<div class="col-xs-12 bg-success"><h2>Base Address</h2></div>
			  	<blockquote class="col-xs-12"><h4>http://117.52.97.211</h4></blockquote>
			</div>
			<div class="row">
			  	<div class="col-xs-12 bg-success"><h2>viewPage</h2></div>
			  	<blockquote class="col-xs-12"><h4>/admin/count/listview.do</h4></blockquote>
			</div>
			<div class="row">
			  	<div class="col-xs-12 bg-success"><h2>HEADER</h2></div>
			  	<blockquote>
				  	<div class="col-xs-12"><h4>Content-Type : application/json</h4></div>
				  	<div class="col-xs-12"><h4>charset : utf-8</h4></div>
				  	<div class="col-xs-12"><h4>Accept : application/json</h4></div>
			  	</blockquote>
			</div>
			<div class="row">
			  	<div class="col-xs-12 bg-success"><h2>RequestMethod</h2></div>
			  	<blockquote>
				  	<div class="col-xs-12"><h3>GET(수정중)</h3></div>
				  	<blockquote>
				  		<div class="col-xs-12"><h4>전체 리스트 가져오기</h4></div>
				  		<blockquote>
				  			<div class="col-xs-12"><h5>/api/v1/counter.do</h5></div>
				  		</blockquote>
				  		<div class="col-xs-12"><h4>개별 리스트 가져오기</h4></div>
				  		<blockquote>
				  			<div class="col-xs-12"><h5>/api/v1/counter.do/{name}</h5></div>
				  			<div class="col-xs-12"><h5>{name}매칭값을 가져온다</h5></div>
				  		</blockquote>
				  		<div class="col-xs-12"><h4>response data</h4></div>
				  		<blockquote>
				  			<div class="col-xs-12">
						  		<h6>
						  		{
								    "data": [
								        {
								            ?
								        }
								    ]
								}
								</h6>
							</div>
				  		</blockquote>
				  	</blockquote>
				  	<div class="col-xs-12"><h3>PUT</h3></div>
				  	<blockquote>
				  		<div class="col-xs-12"><h4>삽입&수정</h4></div>
				  		<blockquote>
				  			<div class="col-xs-12"><h5>/api/v1/counter.do</h5></div>
				  		</blockquote>
				  		<div class="col-xs-12"><h4>JsonType body 예제</h4></div>
				  		<blockquote>
				  			<div class="col-xs-12">
						  		<h6>
						  		{"device_name":"레스트" , "media_name":"test.jpg"}
								</h6>
							</div>
							<div class="col-xs-12">
						  		<h5>
						  		device_name 중복체크 , 존재시 업데이트 없을시 전체카테고리에 포함하여 인서트
						  		<br>
						  		media_name 중복체크 존재시 업데이트 없을시 인서트
								</h5>
							</div>
				  		</blockquote>
				  	</blockquote>
				  	
			  	</blockquote>
			</div>
		</div>
	
	
	
	</section>
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>
