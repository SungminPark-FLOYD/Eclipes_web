package kr.or.ddit.member.dao;


import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.util.mybatisUtil;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements IMemberDao{
    private  static MemberDaoImpl instance = null;

    private MemberDaoImpl() {}
    public static MemberDaoImpl getInstance(){
        if(instance == null) instance = new MemberDaoImpl();
        return instance;
    } 

    @Override
    public String selectById(String memId) {
        String mem_id = null;
        SqlSession session = null;

        try {
            session = mybatisUtil.getSqlSession();
            mem_id = session.selectOne("member.selectById", memId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return mem_id;
    }

    @Override
    public List<ZipVo> selectByDong(String dong) {
        List<ZipVo> zipList = null;
        SqlSession session = null;

        try {
            session = mybatisUtil.getSqlSession();
            zipList = new ArrayList<ZipVo>();
            zipList = session.selectList("member.selectByDong", dong);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return zipList;
    }

    @Override
    public int insertMemeber(MemberVo memVo) {
        int cnt = 0;
        SqlSession session = null;

        try {
            session = mybatisUtil.getSqlSession();
            cnt = session.insert("member.insertMember", memVo);
            if(cnt > 0) session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }
	@Override
	public MemberVo logSelect(MemberVo vo) {
		MemberVo memVo = null;
        SqlSession session = null;

        try {
            session = mybatisUtil.getSqlSession();
            memVo = new MemberVo();
            memVo = session.selectOne("member.logSelect", vo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return memVo;
	}
}
