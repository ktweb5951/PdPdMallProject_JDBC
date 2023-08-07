<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../../resources/css/member/register.css">
        <link rel="stylesheet" href="../../resources/css/reset.css">
        <title>회원가입 페이지</title>
    </head>
    <body>
        <script>
            document.addEventListener("DOMContentLoaded", () => {          


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
                });

                document.querySelector(".certifiedBtn").addEventListener("click", ()=>{
                    alert("인증번호를 발송했습니다.");
                });
            });

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
        <div id="container">
            <header>
    			<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
            </header>
            <main>
                <div class="member-form">
                    <div class="top">
                        <img src="/resources/images/components/logoimage2.png" alt="">
                        <h2>회원가입</h2>
                    </div>
                    <form action="/member/register.do" method="post" id="memberForm">
                            <ul>
                                <li>
                                    <label>아이디</label>
                                    <div>
                                    <input type="text" id="member-id" name="member-id">
                                        <button onclick="validityBtn();">중복확인</button>
                                    </div>
                                </li>
                                <li>
                                    <label>비밀번호</label>
                                    <input type="password" id="member-pw" name="member-pw">
                                </li>
                                <li>
                                    <label>비밀번호 확인</label><input type="password" id="pw-re" name="pw-re">
                                </li>
                                <li>
                                    <label>이름</label><input type="text" id="member-name" name="member-name">
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
                                        <input type="text" id="member-phone"  name="member-phone" placeholder="'-'없이 입력">
                                        <button class="certifiedBtn">인증받기</button>
                                    </div>                                 
                                    <div>
                                        <input type="text" id="tel-certified" placeholder="인증번호를 입력하세요">
                                    </div>
                                </li>
                                <li>
                                    <label>주소</label>
                                    <div>
                                        <input type="text" id="member-address" name="member-address">
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
                                    <label>이메일</label><input type="text" id="member-email" name="member-email"><br>
                                </li>
                            </ul>
                            <span id="message" class="message"></span>
                            <div class="form-btn">
                                <input type="submit" value="회원가입" style="cursor:pointer">
    
                            </div>
                    </form>
                </div>
            </main>
            <footer>
            	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
            </footer>
        </div>
    </body>
</html>