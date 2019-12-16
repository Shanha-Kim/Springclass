package com.simple.www.dao;

import java.awt.List;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.www.vo.MemberVO;

public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int loginProc(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.Login", vo);
		return cnt;
	}
	
	public int joinProc(MemberVO vo) {
		int cnt = sqlSession.insert("mSQL.Join", vo);
		return cnt;
	}
	public int idCheck(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.IdCount", vo);
		return cnt;
	}
	
	public String showName(MemberVO vo) {
		String name = sqlSession.selectOne("mSQL.ShowName", vo);
		return name;
	}
	public java.util.List<MemberVO> showId() {
		java.util.List<MemberVO> ids = sqlSession.selectList("mSQL.ShowId");
		return ids;
	}
	
	public MemberVO membInfo(String id) {
		MemberVO vo = sqlSession.selectOne("mSQL.MembInfo", id);
		return vo;
	}
	
	public int editInfo(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.MembInfo", vo);
		return cnt;
	}
	
	
}
