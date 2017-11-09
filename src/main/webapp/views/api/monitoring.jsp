<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!doctype html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.4/themes/smoothness/jquery-ui.css" type="text/css" media="all">
	<link rel="stylesheet" href="/resources/css/api/monitoring.css"> 
	
	<script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.0/jquery-ui.min.js"></script>
	
	
	
	
	<!-- <script src="/resources/js/jquery-ui-1.10.1.js" type="text/javascript"></script> -->

	
	<script src="/resources/js/sugar.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.form.js" type="text/javascript"></script>
	 
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script src="/resources/js/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="/resources/js/admin.js"></script>
	<script src="/resources/js/api/monitoring.js" type="text/javascript"></script>
</head>
<body data-ng-app="main" data-ng-controller="mainCtrl">
	
	<section><!-- 전체 사이즈 레이어 --> 
		<div id="monitoringBox" class="container row" data-ng-controller="monitoringCtrl">
			<div class="topMargin">
				모니터링
			</div>
			<div class="centerTopBox">
				<ul>
					<li>
					<label>기간설정 : </label>
					</li>
					<li>
						<input class="date" type="text" name="date" data-ng-model="dateString" data-ng-change="getDeviceNoresponse()"/> 
						~
						<input class="date" type="text" name="date2" data-ng-model="dateString2" data-ng-change="getDeviceNoresponse()"/> 
					</li>
					<li>
						<button class="btn btn-success btn-sm" data-ng-click="excelDown()">엑셀다운</button>
					</li>
				</ul>
			</div>
			<div class="leftBox">
				<div class=regionBox>
					<label>지역</label>
					<select multiple class="form-control" data-ng-init="region_idx='0'">
						<option class="btn_li" data-ng-click="regionClick(0)">
							지역전체
						</option>
						<option data-ng-repeat="obj in region" class="btn_li" data-ng-click="regionClick(obj.idx)">
							{{obj.name}}
						</option>
					</select>
				</div>
				<div class=branchBox>
					<label>지점</label>
					<select multiple class="form-control" data-ng-init="branch_idx='0'">
						<option data-ng-repeat="obj in branch" class="btn_li" data-ng-click="branchClick(obj.idx)">
							{{obj.name}}
						</option>
					</select>
				</div>
				<div class=didListBox>
					<label>단말목록</label>
					<select multiple class="form-control " data-ng-init="didList_idx='0'">
						<option data-ng-repeat="obj in didList" class="btn_li  table-striped" data-ng-click="didListClick(obj.idx)">
							{{obj.name}}
						</option>
					</select>
				</div>
			</div>
			
			<div class="centerBox">
				<label>단말</label>
				<ul data-ng-init="device_idx='0'">
					<li data-ng-repeat="obj in device" class="btn_li" data-ng-click="deviceClick(obj.idx)">
						{{obj.branch_name}}/{{obj.didList_name}}/{{obj.name}}/{{obj.dateString}}차이 <span data-ng-bind-html="obj.errorMode | errorMode"></span>
					</li>
				</ul>
			</div>
			<div class="rightBox">
				<label>무응답리스트</label>
				<table class="table list">
			  		<thead>
			  			<tr>
			  				<th>
			  					번호
			  				</th>
			  				<th>
			  					지점명
			  				</th>
			  				<th>
			  					단말그룹명
			  				</th>
			  				<th>
			  					단말기명
			  				</th>
			  				<th>
			  					시간차
			  				</th>
			  				<th>
			  					상태
			  				</th>
			  				<th>
			  					발생 ~ 정상화
			  				</th>
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<tr data-ng-repeat="obj in deviceNoresponse">
							<td>
								{{((pageNum-1)*pageTotal)+($index+1)}}
							</td>
							<td>
								{{obj.branch_name}}
							</td>
							<td>
								{{obj.didList_name}}
							</td>
							<td>
								{{obj.device_name}}
							</td>
							<td>
								{{obj.gapString}}전
							</td>
							<td>
								<span data-ng-bind-html="obj.errorMode | errorMode"></span>
							</td>
							<td>
							{{obj.date | localdate}} ~ {{obj.date2 | localdate}}
							</td>
						</tr>
			  		</tbody>
			  	</table>
					
					<!-- <li data-ng-repeat="obj in deviceNoresponse" class="btn_li" data-ng-click="">
						{{obj.branch_name}}/{{obj.didList_name}}/{{obj.name}}/{{obj.gapString}} 전 <span data-ng-bind-html="obj.errorMode | errorMode"></span>
						<br/>
						{{obj.date | localdate}}/{{obj.date2 | localdate}}
					</li> -->
			
					
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
					<div class="totalCount">
						총{{deviceNoresponseTotal}}개
					</div>
				</div>
				
			</div>
			
			<!-- <div class="title">
				모니터링
			</div>
			<div class="row seach">
				<ul>
					<li>
						<select data-ng-model="region_idx" data-ng-init="region_idx='0'" data-ng-change="getBranch()">
							<option value="0">
								지역
							</option>
							<option data-ng-repeat="obj in region" value="{{obj.idx}}">
								{{obj.name}}
							</option>
						</select>
					</li>
					
					<li>
						<select data-ng-model="branch_idx" data-ng-init="branch_idx='0'" data-ng-change="getDidList()">
							<option value="0">
								지점
							</option>
							<option data-ng-repeat="obj in branch" value="{{obj.idx}}">
								{{obj.name}}
							</option>
						</select>
					</li>
					<li>
						<select data-ng-model="didList_idx" data-ng-init="didList_idx='0'">
							<option value="0">
								단말그룹목록
							</option>
							<option data-ng-repeat="obj in didList" value="{{obj.idx}}">
								{{obj.name}}
							</option>
						</select>
					</li>
					
					<li >
						<input class="date" type="text" name="date" data-ng-model="dateString"/> ~
					</li>
					<li>
						<input class="date" type="text" name="date2" data-ng-model="dateString2"/>
					</li>
					<li>
						<button class="btn btn-success btn-sm" data-ng-click="getList()">검색</button>
					</li>
					<li>
						<button class="btn btn-success btn-sm" data-ng-click="excelDown()">엑셀다운</button>
					</li>
				</ul>
				
				<div class="totalCount">
					총{{listTotal}}개
				</div>
			</div>
			<div class="row list">
			  	<table class="table">
			  		<thead>
			  			<tr>
			  				<th>
			  					번호
			  				</th>
			  				<th>
			  					지점명<button class="btn btn-primary btn-xs" data-ng-show="g1_sort" data-ng-click="g1_sort = !g1_sort;">▲</button>
			  						<button class="btn btn-primary btn-xs" data-ng-hide="g1_sort" data-ng-click="g1_sort = !g1_sort;">▼</button>
			  				</th>
			  				<th>
			  					단말그룹명<button class="btn btn-primary btn-xs" data-ng-show="g2_sort" data-ng-click="g2_sort = !g2_sort;">▲</button>
			  						   <button class="btn btn-primary btn-xs" data-ng-hide="g2_sort" data-ng-click="g2_sort = !g2_sort;">▼</button>
			  				</th>
			  				<th>
			  					단말기명
			  				</th>
			  				<th>
			  					미디어명
			  				</th>
			  				<th>
			  					재생횟수
			  				</th>
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<tr data-ng-repeat="obj in list">
							<td>
								{{((pageNum-1)*pageTotal)+($index+1)}}
							</td>
							<td>
								{{obj.branch_name}}
							</td>
							<td>
								{{obj.didList_name}}
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
			</div> -->		  	
	  	</div>
	</section>
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>
					