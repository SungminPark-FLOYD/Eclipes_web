package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.board.vo.ReplyVo;

public interface IBoardService {

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
	
	//계산 - 시작페이지, 끝 페이지, 시작 글번호, 끝 글번호
	public PageVo pageInfo(int pageNo, String stype, String sword);
	
	//댓글 쓰기
	public int insertReply(ReplyVo vo);
	
	//댓글 수정
	public int updateReply(ReplyVo vo);
	//댓글 삭제
	public int deleteReply(int rnum);
	//댓글 리스트
	public List<ReplyVo> replyList(int bonum);
}
