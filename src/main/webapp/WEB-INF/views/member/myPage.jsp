<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
    	<jsp:include page="/WEB-INF/views/common/asideHead.jsp"></jsp:include>
        <title>마이 페이지</title>
    </head>

    <body>
        <div id="container">
            <header>
            	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
            </header>
            <main>
                <aside>
                    <h1>마이페이지</h1>
                    <ul class="myPage">
                        <li><a href="#" onclick="loadPage('modifyMemberInfo.jsp')">프로필</a></li>
                        <li><a href="#" onclick="loadPage('거래내역.html')">거래내역</a></li>
                        <li><a href="/member/update.do?member-id=${memberId}">회원정보수정</a></li>
                        <li><a href="/member/withdraw.do?member-id=${memberId}">회원탈퇴</a></li>
                    </ul>
                </aside>
                <section id="main-content" style="display: flex;">

                </section>
            </main>
            <footer>
				<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
            </footer>
        </div>


    </body>

</html>