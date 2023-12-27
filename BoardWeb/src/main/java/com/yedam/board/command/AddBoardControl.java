package com.yedam.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// param(3개), db insert, 목록페이지
		// get방식 요청일 때 / post 요청일 때(파일 업로드)
		
		BoardVO vo = new BoardVO();
		
		if(req.getMethod().equals("GET")) {		
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
		}else if(req.getMethod().equals("POST")) {
			// 파일업로드 포함
			String saveLoc = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			MultipartRequest mr = null;
			
			// 1.request 요청 2.saveLoc 저장위치 3.maxSize 파일크기 4.utf-8 파일 인코딩 방식 5.리네임정책 
			try {
				mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				String image = mr.getFilesystemName("image");
				
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				vo.setImage(image);
								
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} // end of if
		
		// svc : addBoard()
		BoardService svc = new BoardServiceMybatis();
		try {
			if(svc.addBoard(vo)) {
				resp.sendRedirect("boardList.do");
			}else{
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of execute

} // end of class
