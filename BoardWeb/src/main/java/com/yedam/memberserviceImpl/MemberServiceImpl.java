package com.yedam.memberserviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	public List<MemberVO> memberList() {
		return mapper.selectList();
	}

	@Override
	public MemberVO getMember(String id) {
		return mapper.selectOne(id);
	}

	@Override
	public boolean addMember(MemberVO vo) {
		return mapper.insertMember(vo) == 1;
	}

	@Override
	public boolean removeMember(String id) {
		return mapper.deleteMember(id) == 1;
	}

	
}
