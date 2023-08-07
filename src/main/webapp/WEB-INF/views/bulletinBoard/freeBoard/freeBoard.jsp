<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" >
	<link
		href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap"
		rel="stylesheet">
	<link rel="stylesheet" href="../../resources/css/reset.css">
	<link rel="stylesheet"
		href="../../resources/css/bulletinBoard/freeBoard.css">
	<title>자유 게시판</title>
	</head>
	<body>
		<div id="container">
			<header>
				<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
			</header>
			<main>
				<section id="top">
					<img src="../../resources/images/components/logoimage2.png" alt="">
					<h1>자유 게시판</h1>
				</section>
				<section id="mid">
					<table>
						<thead>
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>추천수</th>
								<th>작성날짜 및 시간</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="freeBoard" items="${requestScope.fList}">
								<tr>
									<td>${freeBoard.freeBoardNo }</td>
									<td>${freeBoard.freeBoardTitle }</td>
									<td>${freeBoard.freeBoardWriter }</td>
									<td>${freeBoard.viewCount }</td>
									<td>${freeBoard.rcmndCount }</td>
									<td>${freeBoard.freeBoardDate }</td>
								</tr>
							</c:forEach>
						</tbody>
						<!--             <tr> -->
						<!--               <td>5</td> -->
						<!--               <td><a href="./post5.html">아이폰 14 리얼 후기</a></td> -->
						<!--               <td>재드래곤</td> -->
						<!--               <td>6,800</td> -->
						<!--               <td>50</td> -->
						<!--               <td>2023-06-07 10:00:00</td> -->
						<!--             </tr> -->
						<!--             <tr> -->
						<!--               <td>4</td> -->
						<!--               <td><a href="./post4.html">난 갤럭시 폴드만 쓴다</a></td> -->
						<!--               <td>빌게이츠</td> -->
						<!--               <td>7,000</td> -->
						<!--               <td>45</td> -->
						<!--               <td>2023-06-06 12:00:00</td> -->
						<!--             </tr> -->
						<!--             <tr> -->
						<!--               <td>3</td> -->
						<!--               <td><a href="./post3.html">요즘 사기 좋은 폰 뭐있나요?</a></td> -->
						<!--               <td>고든램지</td> -->
						<!--               <td>1,750</td> -->
						<!--               <td>35</td> -->
						<!--               <td>2023-06-06 11:30:00</td> -->
						<!--             </tr> -->
						<!--             <tr> -->
						<!--               <td>2</td> -->
						<!--               <td><a href="./post2.html">현재 폰 GOAT</a></td> -->
						<!--               <td>메시</td> -->
						<!--               <td>2,075</td> -->
						<!--               <td>25</td> -->
						<!--               <td>2023-06-06 10:30:00</td> -->
						<!--             </tr> -->
						<!--             <tr> -->
						<!--               <td>1</td> -->
						<!--               <td><a href="./post1.html">제꺼 폰 상태 어때요???</a></td> -->
						<!--               <td>감스트</td> -->
						<!--               <td>3,675</td> -->
						<!--               <td>40</td> -->
						<!--               <td>2023-06-06 10:30:00</td> -->
						<!--             </tr> -->
					</table>
					<div class=pageNavi>${pageNavi }</div>
	
				</section>
				<section id="btnArea">
					<div>
						<a class="write-btn"  href="/bulletinBoard/freeBoard/insert.do">글작성</a>
					</div>
				</section>
			</main>
			<footer>
				<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
			</footer>
		</div>
	
		<script>
			
		</script>
	</body>
</html>