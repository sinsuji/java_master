package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardContro;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberAddJson;
import com.yedam.member.command.MemberDelJson;
import com.yedam.member.command.MemberListAjax;
import com.yedam.member.command.MemberListControl;
import com.yedam.member.command.MemberListJson;
import com.yedam.member.command.getMemberControl;
import com.yedam.reply.command.AddReplyJson;
import com.yedam.reply.command.ChartForm;
import com.yedam.reply.command.Covid19Form;
import com.yedam.reply.command.DelReplyJson;
import com.yedam.reply.command.MapForm;
import com.yedam.reply.command.PagingListJson;
import com.yedam.reply.command.ReplyCountJson;
import com.yedam.reply.command.ReplyListJson;
import com.yedam.student.command.StudInfoCont;
import com.yedam.student.command.StudentListCont;

// @WebServlet("*.do")

// 컨트롤러 : url 요청이 들어오면 서블릿 실행
public class FrontController extends HttpServlet {
	// 생명주기 : 생성자 호출 -> init() - > service() -> destroy()
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
//		map.put("/main.do", new MainControl());
//		map.put("/sub.do", new SubControl());
		
		// URL패턴 - 컨트롤 - jsp
		// boardList.do -> BoardListControl -> boardList.jsp
		// 게시판관련 - 데이터를 조회하고 처리한 결과들을 boardList로 넘겨줌
		map.put("/boardList.do", new BoardListControl());
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/getBoard.do", new GetBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardContro());
		map.put("/removeForm.do", new RemoveFormControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		
		// 회원관련
		map.put("/loginForm.do", new LoginFormControl()); // 화면 보여주는 것
		map.put("/login.do", new LoginControl()); // 실제 로그인 실행
		map.put("/logout.do", new LogoutControl()); // 로그아웃 실행
		
		// 관리자
		map.put("/memberList.do", new MemberListControl());
		map.put("/memberListAjax.do", new MemberListAjax());
		map.put("/getMember.do", new getMemberControl());
		
		// 회원관련데이터(json) 처리
		map.put("/memberListJson.do", new MemberListJson());
		map.put("/memberAddJson.do", new MemberAddJson());
		map.put("/memberDelJson.do", new MemberDelJson());
		
		// tiles 관련
		map.put("/studentList.do", new StudentListCont());
		map.put("/studInfo.do", new StudInfoCont());
		
		// 댓글관련, json포맷의 데이터를 생성해서 반환
		map.put("/replyListJson.do", new ReplyListJson());
		map.put("/delReplyJson.do", new DelReplyJson());
		map.put("/addReplyJson.do", new AddReplyJson());
		// 페이지 생성하기 위한 json
		map.put("/pagingListJson.do", new PagingListJson());
		
		// chart
		map.put("/chart.do", new ChartForm());
		map.put("/replyCountJson.do", new ReplyCountJson());
		
		// 코로나19 관련
		map.put("/covid19.do", new Covid19Form());
		
		// 지도api
		map.put("/map.do", new MapForm());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length());
		System.out.println(path);
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
}
