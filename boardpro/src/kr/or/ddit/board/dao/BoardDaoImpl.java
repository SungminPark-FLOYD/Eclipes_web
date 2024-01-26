package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.util.mybatisUtil;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.board.vo.PageVo;

public class BoardDaoImpl implements IBoardDao {
	private static BoardDaoImpl instance = null;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(instance == null) instance = new BoardDaoImpl();
		return instance;
	}

	@Override
	public List<BoardVo> selectByPage(Map<String, Object> map) {
		List<BoardVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			list = session.selectList("board.selectByPage", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		
		return list;
	}

	@Override
	public int insertBoard(BoardVo vo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.insert("board.insertBoard", vo);
			
			if(cnt > 0) session.commit();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.update("board.updateBoard", vo);
			
			if(cnt > 0) session.commit();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int num) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.delete("board.deleteBoard", num);
			
			if(cnt > 0) session.commit();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		return cnt;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.selectOne("board.getTotalCount", map);
						
		}  catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		return cnt;
	}

	@Override
	public int updateHit(int num) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.update("board.updateHit", num);
				
			if(cnt > 0) session.commit();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}finally { if(session != null) session.close();}
		
		return cnt;
	}

}
