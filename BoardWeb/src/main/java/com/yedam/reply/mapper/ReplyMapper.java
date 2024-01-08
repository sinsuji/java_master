package com.yedam.reply.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
	// 페이지 계산하기 위한 전체건수 반환
	int selectCount(int boardNo);
	// 차트 데이터(댓글자, 작성건수)
	List<HashMap<String, Object>> selectReplyCnt();
}
