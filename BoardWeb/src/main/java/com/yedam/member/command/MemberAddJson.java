package com.yedam.member.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;
import com.yedam.memberserviceImpl.MemberServiceImpl;

public class MemberAddJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/json;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		// 파일업로드 포함
		String saveLoc = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		
		// 1.request 요청 2.saveLoc 저장위치 3.maxSize 파일크기 4.utf-8 파일 인코딩 방식 5.리네임정책 
		try {
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy()); // MultipartRequest -> post 방식
			String id = mr.getParameter("id");
			String pass = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String image = mr.getFilesystemName("image");			
			String responsibility = "User";
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pass);
			vo.setName(name);
			vo.setResponsibility(responsibility);
			vo.setImage(image);
			
			MemberService svc = new MemberServiceImpl();
			
			Map<String, Object> map = new HashMap<>();
			if(svc.addMember(vo)) {
				map.put("retCode", "OK");
				map.put("vo", vo);
			} else {
				map.put("retCode", "NG");
			}
			
			Gson gson = new GsonBuilder().create();
			
			resp.getWriter().print(gson.toJson(map));
							
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
