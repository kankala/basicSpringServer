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
			<%-- <tiles:insertAttribute name="leftmenu" /> --%>
		
			<section><!-- 전체 사이즈 레이어 --> 
				<div id="sub1Box" data-ng-controller="sub1Ctrl">
					<form:form modelAttribute="sub1" id="sub1Formk" method="post" onsubmit="return false;">
			        
			        <div class="schbox">
			            <ul>
			                <li class="w_title"><label>제목</label><input type="text" name="schTitle" data-ng-model="schTitle" maxlength="50"></li>
			                <li><button type="button" class="schbtn" data-ng-disabled="!schTitle"><span class="fui-search"></span></button></li>
			                <%-- <c:choose>
								<c:when test="${user.level le 2}">
								<li class="r_btn"><button type="button" class="btn2" data-ng-click="addButton()" >글쓰기</button></li>
								</c:when>
							      	<c:otherwise>
							 	</c:otherwise>
						   	</c:choose> --%>
			            </ul>
			        </div>
			        <div class="list">
			            <div class="contents form-group" >
							<ul class="list-inline" data-ng-repeat="obj in contentList" style="border: 1px solid grey;max-width: 60%;"  >
								<li>
									{{obj.idx}}
								</li>
								<li >
									<img class="img-thumbnail" style="max-width: 20%; height: auto;" src="{{obj.imgUrl}}" onerror="this.src='/resources/image/errorI.jpg'"/>
								</li>
								<li>
									{{obj.registerDate_l | localdate}}
								</li>
							</ul>
			            </div>
			        </div>
			        <!-- <div class="pagingTab">
			            <ul>
			              	<li data-ng-show="prevFlag"><a data-ng-click="listPrev()" href="#fakelink" class="fui-arrow-left"></a></li>
			              	<li data-ng-repeat="obj in pagingObj"><a data-ng-click="listGo(obj)" href="">{{obj}}</a></li>
			              	<li data-ng-show="nextFlag"><a  data-ng-click="listNext()" href="#fakelink" class="fui-arrow-right"></a></li>
			            </ul>
			            <div class="seach">
							<div class="totalCount ng-binding">
								총{{userTotal}}개
							</div>
						</div>
			        </div> -->
			        
			        
			        
			        <%-- <div class="layers_of_list draggable" data-ng-show="boardView">
						<div class="close" data-ng-click="boardView = false"></div>
					    <img src="/resources/image/board/layer_head.png">
						<div class="miniList">
							<div class="popup_title">
					            <ul>
					                <li class="poptitle"><label>제목</label></li>
					                <li class="poptxt"><input type="text" data-ng-model="title"/></li>
					            </ul>
							</div>
							<div class="popup_centents">
					            <ul>
					                <li class="poptitle"><label>내용</label></li>
					                <li class="poptxt"><textarea data-ng-model="content"></textarea></li>
					            </ul>
							</div>
					        <div class="popup_title">
					            <ul data-ng-repeat="obj in fileList">
					                <li class="poptitle"><label>첨부파일</label></li>
					                <li class="poptxt">
					                    <div >
					                        <label>{{obj.originalName}}</label>
					                        <button data-ng-click="fileDownload(obj)" class='btn btn-info btn-xs' type='button'>다운로드</button>
					                        <c:choose>
					                            <c:when test="${user.level le 2}">
					                            <button data-ng-click="deleteFile(obj)" class='btn btn-danger btn-xs' type='button'>삭제</button>
					                            </c:when>
					                                <c:otherwise>
					                            </c:otherwise>
					                        </c:choose>
					
					                    </div>
					                </li>
					            </ul>
					            <ul data-ng-show="mfile1">
					                <li class="poptitle"><label>첨부파일</label></li>
					                <li class="poptxt">
										<input type="file" name="file" data-file-model="ifile1" id="ifile1">
					                </li>
					            </ul>
					            <ul data-ng-show="mfile2">
					                <li class="poptitle"><label>첨부파일</label></li>
					                <li class="poptxt">
										<input type="file" name="file" data-file-model="ifile2" id="ifile2">
					                </li>
					            </ul>
					            <ul data-ng-show="mfile3">
					                <li class="poptitle"><label>첨부파일</label></li>
					                <li class="poptxt">
										<input type="file" name="file" data-file-model="ifile3" id="ifile3">
					                </li>
					            </ul>
							</div>
							<c:choose>
								<c:when test="${user.level le 2}">
								<div class="btntxt">
									<button type="button" class="btn btn-default" data-ng-show="!idx" data-ng-click="changeBoard(1)">등록</button>
									<button type="button" class="btn btn-default" data-ng-show="idx" data-ng-click="changeBoard(2)">수정</button>
									<button type="button" class="btn btn-default" data-ng-show="idx" data-ng-click="changeBoard(3)">삭제</button>
								</div>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div> --%>
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
					<%-- <div  class="layers_of_list draggable" data-ng-show="boardView">
						<div class="close" data-ng-click="boardView = false">X</div>
						
						<div class="miniList">
							<div>
								<label>제목</label>
								<input type="text" data-ng-model="title"/>
							</div>
							<div>
								<label>내용</label>
								<textarea data-ng-model="content">
								</textarea>
							</div>
							<ul>
								<li>
									<div data-ng-repeat="obj in fileList">
										<label>{{obj.originalName}}</label>
										<button data-ng-click="fileDownload(obj)" class='btn btn-info btn-xs' type='button'>다운로드</button>
										<c:choose>
											<c:when test="${user.level le 2}">
											<button data-ng-click="deleteFile(obj)" class='btn btn-danger btn-xs' type='button'>삭제</button>
											</c:when>
										      	<c:otherwise>
										 	</c:otherwise>
									   	</c:choose>
										
									</div>
			        				<div data-ng-show="mfile1">
				        				<label for="ifile1">File input</label>
				        				<input type="file" name="file" data-file-model="ifile1" id="ifile1" />
			        				</div>
			        				<div data-ng-show="mfile2">
										<label for="ifile2">File input</label>
										<input type="file" name="file" data-file-model="ifile2" id="ifile2"/>
									</div>
									<div data-ng-show="mfile3">
										<label for="ifile3">File input</label>
										<input type="file" name="file" data-file-model="ifile3" id="ifile3"/>
									</div>
									
									
									
			        			</li>
							</ul>
							<c:choose>
								<c:when test="${user.level le 2}">
								<div>
									<button type="button" data-ng-show="!idx" data-ng-click="changeBoard(1)">등록</button>
									<button type="button" data-ng-show="idx" data-ng-click="changeBoard(2)">수정</button>
									<button type="button" data-ng-show="idx" data-ng-click="changeBoard(3)">삭제</button>
								</div>
								</c:when>
							      	<c:otherwise>
							 	</c:otherwise>
						   	</c:choose>
							
						</div>
					</div> --%>
					</form:form>
				</div>
				
				
				<form:form modelAttribute="upload" id="uploadForm" method="post" onsubmit="return false;">
					<input type="file" name="file" data-file-model="ifile1" id="ifile1" />
				</form:form>
			</section>
		</div>
		<%-- <form:form action="/admin/board/fileDown.do" id="fileDownForm" modelAttribute="fileDown" method="post">
			<input type="hidden" id="downIdx" name="idx" value="1"></input>
			<input type="hidden" id="downType" name="type" value="1"></input>
			<input type="hidden" id="downPath" name="filePath"></input>
			<input type="hidden" id="downOriginalName" name="originalName"></input>
		</form:form> --%>
	</div>
<tiles:insertAttribute name="footer"/>
</body>

</html>
