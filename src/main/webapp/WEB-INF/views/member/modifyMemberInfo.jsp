<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	   	<jsp:include page="/WEB-INF/views/common/asideHead.jsp"></jsp:include>
	   	 <link rel="stylesheet" href="../../resources/css/member/modifyMemberInfo.css">
	    <title>회원 정보 수정</title>
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
	                        <li><a href="/member/myInfo.do?member-id=${memberId}">회원정보수정</a></li>
	                         <li><a href="/member/withdraw.do?member-id=${memberId}">회원탈퇴</a></li>
	                    </ul>
	            </aside>
	            <section>
		            <div class="member-form">
		                <div class="top">
		                    <img src="../../resources/images/components/logoimage2.png" alt="">
		                    <h2>회원 정보 수정</h2>
		                </div>
		                <form action="/member/update.do" method="post" id="memberForm">
		                    <ul>
		                        <li>
		                            <label>아이디</label>
		                            <div>
		                                <input type="text" id="member-id" name="member-id" value="${member.memberId}" readonly>
		                            </div>
		                        </li>
		                        <li>
		                            <label>비밀번호</label>
		                            <input type="password" id="member-pw" name="member-pw" placeholder="새 비밀번호 입력">
		                        </li>
		                        <li>
		                            <label>비밀번호 확인</label><input type="password" id="pw-re" placeholder="새 비밀번호 확인">
		                        </li>
		                        <li>
		                            <label>이름</label><input type="text" id="member-name" name="member-name" value="${member.memberName}" readonly >
		                        </li>
		                        <li>
		                            <label>닉네임</label>
		                            <div>
		                                <input type="text" id="member-nickname" name="member-nickname">
		                                <button onclick="validityBtn();">중복확인</button>
		                            </div>
		                        </li>
		                        <li>
		                            <label>핸드폰번호</label>
		                            <div>
		                                <input type="text" id="member-phone" name="member-phone">
		                                <button class="certifiedBtn">인증받기</button>
		                            </div>                                 
		                            <div>
		                                <input type="text" id="tel-certified" placeholder="인증번호를 입력하세요">
		                            </div>
		                        </li>
		                        <li>
		                            <label>주소</label>
		                            <div>
		                                <input type="text" id="addr" name="member-address">
		                                <button onclick="addrSearch();">주소검색</button>
		                            </div>
		                        </li>
		                        <li>
		                            <label>우편번호</label>
		                            <div>
		                                <input type="text" size="5" id="post-1" name="post-1"> - <input type="text" size="5" id="post-2" name="post-2"> 
		                            </div>
		                        </li>
		                        <li>
		                            <label>이메일</label><input type="text" id="member-email" name="member-email">
		                        </li>
		                    </ul>
		                    <span id="message" class="message"></span>
		                    <div class="form-btn">
		                        <input type="submit" value="수정 완료" style="cursor:pointer">
		                    </div>
		                </form>
		            </div>
	             </section>
	        </main>
	        <footer>
	        	    		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	        </footer>
	    </div>
		<script>
// 	       function loadHTML(url, element) {
// 	           const xhttp = new XMLHttpRequest();
// 	           xhttp.onreadystatechange = function () {
// 	               if (this.readyState === 4 && this.status === 200) {
// 	                   const content = this.responseText;
// 	                   element.innerHTML = content;
	
// 	                   // 포함된 자바스크립트 코드 실행
// 	                   const scriptTags = element.getElementsByTagName("script");
// 	                   for (var i = 0; i < scriptTags.length; i++) {
// 	                       eval(scriptTags[i].innerText);
// 	                   }
// 	               }
// 	           };
// 	           xhttp.open("GET", url, true);
// 	           xhttp.send();
// 	       }
	
// 	       document.addEventListener("DOMContentLoaded", function () {
// 	           const headerElement = document.querySelector("header");
// 	           loadHTML("../components/header.jsp", headerElement);
	
// 	           const footerElement = document.querySelector("footer");
// 	           loadHTML("../components/footer.jsp", footerElement);
// 	       });
	       
           document.addEventListener("DOMContentLoaded", () => {          
               const headerElement = document.querySelector("header");
               loadHTML("/html/components/header.jsp", headerElement);
   
               const footerElement = document.querySelector("footer");
               loadHTML("/html/components/footer.html", footerElement);

               document.querySelector("form").addEventListener("submit", (e)=>{
                   // 화면출력
                   const msgTag = document.querySelector("#message");
                   msgTag.style.color= "red";
                   msgTag.style.fontWeight = "bolder";

                   const userId = document.querySelector("#member-id").value;
                   const userPw = document.querySelector("#member-pw").value;
                   const pwCheck = document.querySelector("#pw-re").value;
                   const userName = document.querySelector("#member-name").value;
                   const userNickName = document.querySelector("#member-nickname").value;
                   const address = document.querySelector("#member-address").value;
                   const post1 = document.querySelector("#post-1").value;
                   const post2 = document.querySelector("#post-2").value;
                   const email = document.querySelector("#member-email").value;
                   const telPhone = document.querySelector("#member-phone").value;
                   
                   const idRegExp = /^[a-z]\w{3,11}$/g;
                   const pwRegExp = /^[a-zA-Z0-9]{6,14}$/g;
                   const nameRegExp = /^[가-힣]+$/g;   
                   const nickNamRegExp = /^[a-zA-Z가-힣]{1,12}$/g;   
                   const addrRegExp = /[^a-zA-Z/s]+$/gm;
                   const postNumRegExp = /^[0-9]+$/g;
                   const emailRegExp = /^[a-zA-Z0-9]{4,12}@[a-z]+\.[a-z]{3}/g;
                   const telRegExp = /^[0-9]+$/g;

                   if(!idRegExp.test(userId)){
                       e.preventDefault();
                       msgTag.innerText = "아이디는 영어소문자,숫자만 입력 가능합니다.";   
                   } else if(!pwRegExp.test(userPw)){
                       e.preventDefault();
                       msgTag.innerText = "비밀번호는 영어소문자,대문자,숫자만 입력가능합니다.";
                   } else if(userPw !== pwCheck){
                       e.preventDefault();
                       msgTag.innerText = "비밀번호가 일치하지 않습니다.";
                   } else if(!nameRegExp.test(userName)){
                       e.preventDefault();
                       msgTag.innerText = "이름은 무조건 한글만 입력 가능합니다.";
                   } else if(!nickNamRegExp.test(userNickName)){
                       e.preventDefault();
                       msgTag.innerText = "닉네임은 한글,영어만 입력 가능합니다.";
                   } else if(!telRegExp.test(telPhone)){
                       e.preventDefault();
                       msgTag.innerText = "전화번호는 숫자만 입력 가능합니다. ";  
                   }  else if(!addrRegExp.test(address)){
                       e.preventDefault();
                       msgTag.innerText = "주소에는 영어 사용 불가(공백 불가)";  
                   } else if(!postNumRegExp.test(post1) && !postNumRegExp.test(post2)){
                       e.preventDefault();
                       msgTag.innerText ="우편번호는 무조건 숫자만 입력가능합니다."; 
                   } else if(!emailRegExp.test(email)){
                       e.preventDefault();
                       msgTag.innerText = "이메일은 @가 포함 되어야 합니다. ";
                   } 
               })

               document.querySelector(".certifiedBtn").addEventListener("click", ()=>{
                   alert("인증번호를 발송했습니다.");
               })
           })

           function validityBtn() {
               if(document.querySelector("#user-id").value!==""){
                   alert("사용가능합니다.");
               }
           }

           function addrSearch() {
               const addrVal = prompt("주소를 입력하세요.");
               const inputAddr = document.querySelector("#addr");
               inputAddr.value = addrVal;
           }

	   </script>
	</body>
</html>
