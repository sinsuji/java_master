package com.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServ")
public class BookServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BookServ() {
        super();
    }
    
    // service => get과 post 둘다 처리함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] list = new String[] {"스프링", "html", "java", "boot"};
		request.setAttribute("list", list); // 데이터를 가져가겠다
		request.getRequestDispatcher("book.jsp").forward(request, response); // 페이지 이동
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		super.service(arg0, arg1);
//	}
	
	

}
