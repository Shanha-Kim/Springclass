package com.simple.www.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.*;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/gboard/")
public class GBoard {
	@Autowired
	GBoardDAO gDAO;
	
	@RequestMapping("gboard.van")
	public ModelAndView gboard(ModelAndView mv) {
		java.util.List<GBoardVO> lst = gDAO.showgBoard();
		ArrayList<GBoardVO> list = (ArrayList)lst;
		mv.addObject("LIST", list);
		mv.addObject("total", list.size());
		mv.setViewName("gboard/gboard");
		return mv;
	}
	
	@RequestMapping("gboardWrite.van")
	public ModelAndView gboardWrite(ModelAndView mv, RedirectView rv, GBoardVO vo, HttpSession session) {
		int cnt = gDAO.gBaordWrite(vo);
		if(cnt>0) {
			rv.setUrl("/www/gboard/gboard.van");
			mv.setView(rv);
		}else {
			rv.setUrl("/www/gboard/gboard.van");
			mv.addObject("cnt", cnt);
			mv.setView(rv);
		}
		return mv;
	}
}
