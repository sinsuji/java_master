package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;
import com.yedam.memberserviceImpl.MemberServiceImpl;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.PageDTO;

public class MainExe {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chartData();
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));
		
//		MemberService svc = new MemberServiceImpl();
//		MemberVO vo = svc.login("user1", "1111");
//		
//		if(vo != null) {
//			System.out.println(vo);
//			System.out.println("환영!!" + vo.getName() + "님. 권한은 " + vo.getResponsibility());
//		}else {
//			System.out.println("id, pw 확인");
//		}
		
		
//		SqlSessionFactory factory = DataSource.getInstance();
//		SqlSession session = factory.openSession(true);

		/* 조회수 */
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
//		
//		if(mapper.updateCnt(3) == 1 ) {
//			System.out.println("조회수 증가 성공");
//		}else {
//			System.out.println("조회수 증가 실패");
//		}
		
		/* 단건조회 */
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
//		vo.setBoardNo(2);
//		vo = mapper.selectOne(2);
//		
//		System.out.println(vo);
		
		/* 삭제 */
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
//		vo.setBoardNo(4);
//		
//		mapper.deleteBoard(4);
		
		/* 수정 */
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
//		vo.setContent("히히히히히히히히");
//		vo.setBoardNo(4);
//		
//		mapper.updateBoard(vo);
//		
//		if(mapper.updateBoard(vo) == 1) {
//			System.out.println("수정되었습니다");
//		}else {
//			System.out.println("수정실패");
//		}
		
		/* 추가 */	
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
//		vo.setTitle("홍홍홍");
//		vo.setContent("ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
//		vo.setWriter("fdfd");
//		
//		mapper.insertBoard(vo);
		
		/* 목록 */
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO vo : list) {
//			System.out.println(vo.toString());
//		}
		
		
	}
}
