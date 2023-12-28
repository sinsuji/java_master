package com.yedam.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;
import com.yedam.memberserviceImpl.MemberServiceImpl;

public class getMemberControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.getMember(id);
		
		req.setAttribute("vo", vo);
		
		
		// 페이지 이동(forward) 
		// RequestDispatcher -> 요청을 재지정 해주는 기능
		RequestDispatcher rd = req.getRequestDispatcher("admin/getMember.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}


		
	}

}
