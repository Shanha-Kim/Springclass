package com.simple.www.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.MemberDAO;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/member/")
public class Member {
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {
		
		mv.setViewName("member/login");
		return mv;
	}
	
	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(ModelAndView mv, MemberVO vo, 
			HttpSession session, RedirectView rv) {
		int cnt = mDAO.loginProc(vo);
		if(cnt==1) {
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www/main.van");
			mv.setView(rv);
		}else {
			rv.setUrl("/www/member/login.van");
		}
		return mv;
	}
	
	@RequestMapping("join.van")
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/join");
		return mv;
	}
	
	@RequestMapping("joinProc.van")
	public ModelAndView joinProc(ModelAndView mv, MemberVO vo, 
			HttpSession session, RedirectView rv) {
		System.out.println(vo.getId());
		System.out.println(vo.getMail());
		int cnt = mDAO.joinProc(vo);
		if(cnt>0) {
			rv.setUrl("/www/member/login.van");
			mv.setView(rv);
		}else {
			rv.setUrl("/www/member/join.van");
			mv.setView(rv);
		}
		return mv;
	}
	
	@RequestMapping("logout.van")
	public ModelAndView logOutForm(ModelAndView mv, HttpSession session, RedirectView rv) {
		session.setAttribute("SID", null);
		rv.setUrl("/www/main.van");
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("idCheck.van")
	@ResponseBody
	public int idCheck(MemberVO vo) {
		int cnt = mDAO.idCheck(vo);
		return cnt;
	}
	
	@RequestMapping("showName.van")
	public ModelAndView showName(ModelAndView mv) {
		java.util.List<MemberVO> list = mDAO.showId();
		mv.addObject("LIST", list);
		mv.setViewName("member/showname");
		return mv;
	}
	
	@RequestMapping(value="showNameProc.van", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String showNameProc(MemberVO vo) {
		String name = mDAO.showName(vo);
		
		return name;
	}
	
}
