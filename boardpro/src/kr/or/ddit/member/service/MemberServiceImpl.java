package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public class MemberServiceImpl implements IMemberService{
    private static MemberServiceImpl instance = null;
    IMemberDao dao = null;
    private MemberServiceImpl(){
        dao = MemberDaoImpl.getInstance();
    }
    public static MemberServiceImpl getInstance(){
        if(instance == null) instance = new MemberServiceImpl();
        return instance;
    }


    @Override
    public String selectById(String memId) {
        return dao.selectById(memId);
    }

    @Override
    public List<ZipVo> selectByDong(String dong) {
        return dao.selectByDong(dong);
    }

    @Override
    public int insertMemeber(MemberVo memVo) {
        return dao.insertMemeber(memVo);
    }
	@Override
	public MemberVo logSelect(MemberVo vo) {
		// TODO Auto-generated method stub
		return dao.logSelect(vo);
	}
}
