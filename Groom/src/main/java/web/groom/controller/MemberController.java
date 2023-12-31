package web.groom.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.groom.dto.MemberDTO;

import web.groom.service.MemberService;




@WebServlet("*.me") //.me 멤버 어노테이션 매핑 선언
public class MemberController extends HttpServlet {
	
	MemberService ser = null;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sPath = request.getServletPath();
		
		 //페이지이동
		
		 //로그인 페이지 이동
		 if (sPath.equals("/login.me")) {
			 webForward(request, response, "member", "login");
	     }
		 
		 //로그인 로직 수행
		 if (sPath.equals("/loginPro.me")) {
			
			//멤버서비스 객체생성
			ser = new MemberService();
			
			//메서드호출 및 값 넘겨주기
			MemberDTO memberdto = ser.userCheck(request);
			
			//memberdto 값 존재여부로 로그인 성공여부 확인
			if(memberdto != null) {
			
				//값이 존재하면 세션에 id저장
				HttpSession session = request.getSession();
				
				//세션에 id, salt, role, userNum 값 저장
				session.setAttribute("id", memberdto.getId());
				session.setAttribute("salt", memberdto.getSalt());
				session.setAttribute("role", memberdto.getRole());
				session.setAttribute("num", memberdto.getNum());
				
				//세션저장완료후 메인으로 이동
				response.sendRedirect("main.gr");
			} else {
				
				//자바스크립트 페이지에서 에러를 출력할지 아니면 여기서 프린트라이트를 사용할지?
				webForward(request, response, "member", "msg");
			}
	     }
		 
		 //회원가입 페이지 이동
		 if (sPath.equals("/singup.me")) {
			 webForward(request, response, "member", "singup");   
	     }
		 
		 // 회원가입 로직 수행
		 if (sPath.equals("/singupPro.me")) {
			
			//멤버서비스 객체생성
			ser = new MemberService();
				
			//메서드호출(리퀘스트 값 넘겨주기)
			ser.insertMember(request);
			
			//로그인 화면이동
			response.sendRedirect("login.me");
				
		 }//end_of_insertPro.me
		 
		 if (sPath.equals("/findid.me")) {
			 webForward(request, response, "member", "findid");   
	     }
		 
		 if (sPath.equals("/findpass.me")) {
			 webForward(request, response, "member", "findpass");   
	     }
		 
		 if (sPath.equals("/modifyinfo.me")) {
			 webForward(request, response, "member", "modifyinfo");   
	     }
		 
		 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	
	public void webForward(HttpServletRequest request, HttpServletResponse response, String folder, String pageName) throws ServletException, IOException {
		request.getRequestDispatcher("/"+folder+"/"+pageName+".jsp").forward(request, response);
	}

}
