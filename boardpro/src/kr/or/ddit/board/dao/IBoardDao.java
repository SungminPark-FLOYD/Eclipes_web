package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.board.vo.ReplyVo;

public interface IBoardDao {

	//페이지별 리스트 - 검색, 페이지 처리
	public List<BoardVo> selectByPage(Map<String, Object> map);
	//글쓰기
	public int insertBoard(BoardVo vo);
	//글수정
	public int updateBoard(BoardVo vo);
	//글삭제
	public int deleteBoard(int num);
	
	//조회수 증가
	public int updateHit(int num);
	//전체 글 갯수 얻기
	public int getTotalCount(Map<String, Object> map);
	
	
	//댓글 쓰기
	public int insertReply(ReplyVo vo);
	//댓글 수정
	
	//댓글 삭제
	
	//댓글리스트
	public List<ReplyVo> replyList(int bonum);
}
