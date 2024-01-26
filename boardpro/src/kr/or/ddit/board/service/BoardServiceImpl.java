package kr.or.ddit.board.service;

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
		
		return null;
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

}
