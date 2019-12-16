package com.simple.www.services;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.simple.www.dao.*;

public class FileService {
	MemberDAO mDAO;
	FileDAO fDAO;
	public void setDAO(MemberDAO mDAO) {
		this.mDAO = mDAO;
	};
	public void setDAO(FileDAO fDAO) {
		this.fDAO = fDAO;
	};
	
	// 파일 업로드를 처리할 함수
	public String singleUpProc(HttpSession session, MultipartFile upfile) {
		// 이 함수는 파일을 업로드 하기 위해서 컨트롤러에서 업로드할 파일의 정보를 받아와야 한다.
		// 그 정보는 MultipartFile 이라는 타입으로 전송이 될 것이고
		// 거기서 꺼내서 사용해야 한다.
		
		// 저장이름을 기억할 변수
		String tmp = new String();
		
		String spath =  session.getServletContext().getRealPath("resources/upload");
		/*
		String path = this.getClass().getResource("/").getPath();
		int idx = path.indexOf("/WEB-INF");
		path = path.substring(0, idx) + "/resources/upload";
		System.out.println("srvc path : " + path);
		*/
		String rePath = spath.substring(0, spath.indexOf("\\.metadata"));
		System.out.println(rePath);
		rePath = rePath + "\\git\\Springclass\\FSpring\\src\\main\\webapp\\resources\\upload";
		// 먼저 클라이언트가 업로드한 원본이름을 알아낸다.
		String oriName = upfile.getOriginalFilename();
		
		if(oriName == null || oriName.length() == 0) {
			return "";
		}
		
		return "";
	}
}