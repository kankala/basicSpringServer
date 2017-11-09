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
	
	
	<link rel="stylesheet" href="/resources/css/api/view.css"> 
	
	<script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.0/jquery-ui.min.js"></script>
	
	
	
	
	<!-- <script src="/resources/js/jquery-ui-1.10.1.js" type="text/javascript"></script> -->

	
	<script src="/resources/js/sugar.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.form.js" type="text/javascript"></script>
	 
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script src="/resources/js/api/view.js" type="text/javascript"></script>
</head>
<body data-ng-app="main" data-ng-controller="mainCtrl">
	<section><!-- 전체 사이즈 레이어 --> 
		<div class="container" data-ng-controller="ropsCtrl">

			<div class="form-group">
				<label>대분류</label>
				<div class="input-group">
		    		<input type="text" class="form-control" data-ng-model="g1_name" data-ng-keyup="$event.keyCode == 13 && addG1(1)">
				</div>
				<button data-ng-click="addG1(1)">
					추가
				</button>
			</div>
			
			<div class="form-group">
				<label>소분류</label>
				<div>
					<select data-ng-model="g1_idx" data-ng-init="g1_idx='1'" data-ng-change="getG2()">
						<option data-ng-repeat="obj in g1" value="{{obj.idx}}">
							{{obj.name}}
						</option>
					</select>
				</div>
				<div class="input-group">
		    		<input type="text" class="form-control" data-ng-model="g2_name" data-ng-keyup="$event.keyCode == 13 && addG2(1)">
				</div>
				<button data-ng-click="addG2(1)">
					추가
				</button>
			</div>
			
			<div class="form-group">
				<label>didList</label>
				<div>
					<select data-ng-model="g1_idx" data-ng-init="g1_idx='1'" data-ng-change="getG2()">
						<option data-ng-repeat="obj in g1" value="{{obj.idx}}">
							{{obj.name}}
						</option>
					</select>
				</div>
				
				<div>
					<select data-ng-model="g2_idx" data-ng-init="g2_idx='1'" data-ng-change="getList()">
						<option value="1">
							전체
						</option>
						<option data-ng-repeat="obj in g2" value="{{obj.idx}}">
							{{obj.name}}
						</option>
					</select>
				</div>
				<div class="input-group">
		    		<input type="text" class="form-control" data-ng-model="list_name" data-ng-keyup="$event.keyCode == 13 && addList(1)">
				</div>
				<button data-ng-click="addList(1)">
					추가
				</button>
			</div>
			
			
			<div>
				<select data-ng-model="g1_idx" data-ng-init="g1_idx='1'" data-ng-change="getG2()">
					<option data-ng-repeat="obj in g1" value="{{obj.idx}}">
						{{obj.name}}
					</option>
				</select>
			</div>
			
			<div>
				<select data-ng-model="g2_idx" data-ng-init="g2_idx='1'" data-ng-change="getDid()">
					<option value="1">
						전체
					</option>
					<option data-ng-repeat="obj in g2" value="{{obj.idx}}">
						{{obj.name}}
					</option>
				</select>
			</div>
			<div>
				<select data-ng-model="did_idx" data-ng-init="did_idx='1'" data-ng-change="getList()">
					<option value="1">
						전체
					</option>
					<option data-ng-repeat="obj in did" value="{{obj.idx}}">
						{{obj.name}}
					</option>
				</select>
			</div>
			
			<div class="totalCount">
				총{{listTotal}}개
			</div>

		  	<table class="table">
		  		<thead>
		  			<tr>
		  				<td>
		  					번호
		  				</td>
		  				<td>
		  					그룹1
		  				</td>
		  				<td>
		  					그룹2
		  				</td>
		  				<td>
		  					이름
		  				</td>
		  				<td>
		  					미디어명
		  				</td>
		  				<td>
		  					재생횟수
		  				</td>
		  			</tr>
		  		</thead>
		  		<tbody>
		  			<tr data-ng-repeat="obj in list">
						<td>
							{{obj.idx}}
						</td>
						<td>
							{{obj.g1_name}}
						</td>
						<td>
							{{obj.g2_name}}
						</td>
						<td>
							{{obj.name}}
						</td>
						<td>
							{{obj.media_name}}
						</td>
						<td>
							{{obj.counter}}
						</td>
					</tr>
		  		</tbody>
		  	</table>
			<div class="pagingTab">
				<span>
					<a data-ng-click="listPrev()" data-ng-show="prevFlag" href="#">
						prev
					</a>
				
				</span>
				<span data-ng-repeat="obj in pagingObj">
					<a href="#" data-ng-click="listGo(obj)">
					{{obj}}
					</a>
				</span>
				<span>
					<a data-ng-click="listNext()" data-ng-show="nextFlag" href="#">
						next
					</a>
				</span>
			</div>		  	
	  	</div>
	</section>
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>
					