package com.simple.www.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.www.vo.MemberVO;

public class BoardDAO {
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
	
	
}
