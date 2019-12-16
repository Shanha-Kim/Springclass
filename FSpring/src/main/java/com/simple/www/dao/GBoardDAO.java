package com.simple.www.dao;

import java.awt.List;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.www.vo.*;

public class GBoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public java.util.List<GBoardVO> showgBoard() {
		java.util.List<GBoardVO> gbs = sqlSession.selectList("gSQL.GBoardList");
		return gbs;
	}
	
	public int gBaordWrite(GBoardVO vo) {
		int cnt = sqlSession.insert("gSQL.GBoardWrite", vo);
		return cnt;
	}
	
	
	
}
