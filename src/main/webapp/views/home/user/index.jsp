<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<tiles:insertAttribute name="head" />
	
	<title>
	<tiles:insertAttribute name="title" ignore="true" />
	</title>
</head>
<body data-ng-app="main" data-ng-controller="mainCtrl">
	<div class="wrap">
		<tiles:insertAttribute name="top" />
		<div class="wrap_main">
			<tiles:insertAttribute name="leftmenu" />
			<section><!-- 전체 사이즈 레이어 --> 
				<div id="userBox" data-ng-controller="userCtrl">
					<form:form modelAttribute="user" id="userForm" method="post" onsubmit="return false;">
					<div>
						<h1>■ 유저관리</h1>
					</div>
					<div class="s_user">
						<ul>
							<li class="levbox">
								<label>레벨:</label>
								<select name="level" data-ng-model="level" data-ng-init="level='0'">
									<option value='0'>
										선택
									</option>
									<option value='2'>
										관리자
									</option>
									<option value='3'>
										유저
									</option>
								</select>
							</li>
							<li class="levbox">
								<label>아이디:</label>
								<input type="text" name="id" data-ng-model="id" maxlength="30" data-ng-init="id = ''"/>
							</li>
							<li class="levbox">
								<label>이름 :</label>
								<input type="text" name="name" data-ng-model="name" maxlength="30" data-ng-init="name = ''"/>
							</li>
							<li class="levbox" style="border-right: none;">
								<label>비밀번호 :</label>
								<input type="password" name="password" data-ng-model="password" maxlength="30" data-ng-init="password = ''"/>
							</li>
						</ul>
						<ul class="u_btn">
							<li data-ng-hide="!id"><button type="button"  class="btn btn-default" data-ng-click="changeUser(1)" >등록</button></li>
							<li data-ng-hide="!idx"><button type="button"  class="btn btn-default" data-ng-click="changeUser(2)" >수정</button></li>
							<li data-ng-hide="!idx"><button type="button"  class="btn btn-danger" data-ng-click="changeUser(3)" >삭제</button></li>
						</ul>
						<div id="toggle_form" class="ico_scroll">
							<img src="/resources/image/ico_scroll.jpg">
						</div>
					</div>
					<!-- <div class="seach">
						
						<div class="totalCount">
							총{{userTotal}}개
						</div>
					</div> -->
					<div class="list">
						<div class="contents">
							<table id="tbl_location4" class="t_notice">
								<thead>
									<tr>
										<th class="hdtxt">
											등급
										</th>
										<th class="hdtxt2">
											아이디
										</th>
										<th class="hdtxt3">
											이름
										</th>
										<th class="hdtxt2">
											날짜
										</th>
									</tr>
								</thead>
								<tbody>
									<tr data-ng-repeat="obj in userList" data-ng-click="userSelect(obj)">
										<td>
											{{obj.level | userLevel}}
										</td>
										<td>
											{{obj.id}}
										</td>
										<td >
											{{obj.name}}
										</td>
										<td>
											{{obj.date | localdate}}
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					</form:form>
				</div>
			</section>
		</div>
	</div>

<tiles:insertAttribute name="footer"/>
</body>

</html>
