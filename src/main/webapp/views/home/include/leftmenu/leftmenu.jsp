<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 왼쪽메뉴 시작-->
<div id="leftmenu">
	<div id="topMenu">
		<div id="menu_slide" class="nav mini">
			<ul>
				<li class="l_menu"><span class="fui-arrow-left"></span></li>
				<li class="r_menu"><span class="menutext">메뉴 축소</span></li>
			</ul>
		</div>
		<c:choose>
			<c:when test="${user.level le 2}">
			<ul>
				<li>
					<a href="/admin/addDid/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-credit-card"></span></li>
								<li class="r_menu"><span class="menutext">지점등록</span></li>
							</ul>
						</div>
					</a>
				</li>
			</ul>

			<ul>
				<li>
				<a href="/admin/addContract/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-clip"></span></li>
								<li class="r_menu"><span class="menutext">계약등록</span></li>
							</ul>
						</div>
				</a>
				</li>
			</ul>

			<ul>
				<li><a href="/admin/emission/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-exit"></span></li>
								<li class="r_menu"><span class="menutext">송출등록</span></li>
							</ul>
						</div>
				</a></li>
			</ul>
			<ul>
				<li>
					<a href="/admin/monitorings/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-windows"></span></li>
								<li class="r_menu"><span class="menutext">송출&amp;모니터링</span></li>
							</ul>
						</div>
					</a>
				</li>
			</ul>

			<ul>
				<li><a href="/admin/countView/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-bookmark"></span></li>
								<li class="r_menu"><span class="menutext">리포팅</span></li>
							</ul>
						</div>
				</a></li>
			</ul>

			<ul>
				<li><a href="/admin/board/index.do">
						<div class="nav">
							<ul>
								<li class="l_menu"><span class="fui-list"></span></li>
								<li class="r_menu"><span class="menutext">공지사항</span></li>
							</ul>
						</div>
				</a></li>
			</ul>
			
			<ul>
			    <li><a href="/admin/user/index.do">
					<div class="nav">
					    <ul>
							<li class="l_menu"><span class="fui-user"></span></li>
							<li class="r_menu"><span class="menutext">유저관리</span></li>
					    </ul>
					</div>
			    </a></li>
			</ul>
			</c:when>
	      	<c:otherwise>
	      		<ul>
					<li><a href="/admin/board/index.do">
							<div class="nav">
								<ul>
									<li class="l_menu"><span class="fui-list"></span></li>
									<li class="r_menu"><span class="menutext">공지사항</span></li>
								</ul>
							</div>
					</a></li>
				</ul>
		 		<ul>
					<li><a href="/admin/emission/index.do">
							<div class="nav">
								<ul>
									<li class="l_menu"><span class="fui-exit"></span></li>
									<li class="r_menu"><span class="menutext">송출확인</span></li>
								</ul>
							</div>
					</a></li>
				</ul>
		 	</c:otherwise>
	   	</c:choose>
		
	</div>
</div>
<!-- 왼쪽메뉴 끝-->





