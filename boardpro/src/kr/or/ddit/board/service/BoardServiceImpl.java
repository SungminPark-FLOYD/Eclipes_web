package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.util.mybatisUtil;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;

public class BoardServiceImpl implements IBoardService{
	private static BoardServiceImpl instance = null;
	private IBoardDao dao;
	private BoardServiceImpl() { dao = BoardDaoImpl.getInstance();}
	public static BoardServiceImpl getInstance() {
		if(instance == null) instance = new BoardServiceImpl();
		return instance;
	}
	
	@Override
	public List<BoardVo> selectByPage(Map<String, Object> map) {
		
		return dao.selectByPage(map);
	}

	@Override
	public int insertBoard(BoardVo vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVo vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		return dao.getTotalCount(map);
	}

	@Override
	public PageVo pageInfo(int pageNo, String stype, String sword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype",stype);
		map.put("sword",sword);
		//전체 글 갯수
		int count = this.getTotalCount(map);
		
		//전체 페이지 수 구하기
		int perList = PageVo.getPerList();
		int totalPage = (int)Math.ceil((double)count / perList);
		
		//시작글번호 끝 글번호
		//1 -> 1~3, 2-> 4~6, 3-> 7~9
		int start = (pageNo-1) * perList  + 1;
		int end = start + perList - 1;
		if(end > count) end = count;
		
		//시작페이지 끝페이지
		//[1] -> 1~2, [2] -> 1~2, [3] -> 3~4, [4] -> 3~4
		int perPage = PageVo.getPerPage();
		int startPage = ((pageNo-1) / perPage * perPage)+1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageVo vo = new PageVo();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		return vo;
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

}
