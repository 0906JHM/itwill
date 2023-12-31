<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<!-- 헤드호출 -->
	<jsp:include page="../inc/head.jsp"></jsp:include>
	</head>
	
	<!-- Theme style  -->
	<link rel="stylesheet" href="./css/member_gr.css">
	
	<!-- 로그인 스타일  -->
	<link rel="stylesheet" href="./css/login_gr.css">
	
	<body>
	  <form>
	  
<!-- 로고 자리 -->		
		<h1 style="margin-top: -55px; margin-bottom: 55px;"> Groom(로고) </h1>
		
<!-- 테두리선 시작 -->
			<div class="membership" style="border: 1px solid #ccc; border-radius: 10px; padding: 30px;">
			 
<!-- 아이디 -->
			  <div>
				<label class="imp2" style="font-size: 16px;">ID</label>
				<div>
				  <input type="text" id="id" placeholder="아이디를 입력하세요" required name="id" style="width: 390px; ">
				</div>
			  </div>
		
<!-- 비밀번호 -->
			  <div>
				<br><label class="imp2" style="font-size: 16px;">Password</label>
				<div>
				  <input type="password" placeholder="비밀번호를 입력해주세요." required style="width: 390px;">
			    </div>
			  </div>
		
			 
<!-- 가로줄 추가 -->
		<hr style="margin: 20px 0; border: 2 solid #ccc;">
		

<!-- 로그인 버튼 -->
		<div id="button">
			<button type="submit" style="width: 390px; font-size: 16px; margin-left: 0; ">로그인</button>
		   </div>
	    </div>   
<!-- 테두리선 끝 -->

		   	       
<!-- 회원가입 | 아이디비밀번호 찾기 -->       
	 <div class="centered-text">
         <p>
            <b class="custom-text">회원가입</b>
            <span class="vertical-line"></span>
            <b class="custom-text">아이디/비밀번호 찾기</b>
        </p>
      </div>
      
    </form> 	  

	</body>
</html>
