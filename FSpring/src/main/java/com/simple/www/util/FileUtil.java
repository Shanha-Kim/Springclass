package com.simple.www.util;

import java.io.File;

/**
 * 이 클래스는 파일 업로드에 필요하 기능을 처리하기 위해 만든 유틸리티적 클래스이다.
 * @author 김산하
 * @since 2019.12.16
 * @version v.1.0
 * @see
 * 		변경이력
 * 			2019.12.16 - 클래스제작 - 담당자 : 김산하
 *
 */
public class FileUtil {
	/*
	 	파이 이름이 중복되면 이전에 업로드한 파일에 덮ㅇ쓰기가 된다.
	 	따라서 같은이름의 파일을 대비해 리네임정책 필요
	 	
	 */
	public static String rename(String path, String oldName) {
		/*
			정책 설정 ]
				혹시 같은 이름의 파일이 존재하면 _1을 붙여서 이름을 바꾸는 방식을 사용하자.
				예]
					sample.jpg 라는 파일을 업로드 하려하는데
					이미 업로드된 파일의 이름이 존재한다면 
					sample_1.jpg
					라는 이름으로 변경시켜서 저장하자.
		 */
		
		int count = 0; // 동일한 파일의 경우 붙여질 번호를 기억할 변수
		/*
			sample_1.jpg 이 이을 경우는
			sample_2.jpg 라는 이름으로 파일이 만들어져야 될 것이다.
		 */
		String tmpName = oldName; // 현재 이름을 따로 기억해 놓는다.
		
		File file = new File(path, oldName);
		
		while(file.exists()) {
			count++;
			int len = tmpName.lastIndexOf(".");
			String tmp1 = tmpName.substring(0, len);
			oldName = tmp1+"_"+count+tmpName.substring(len);
			
			file = new File(path, oldName);
		}
		//이 줄이 실행되는 경우는 oldName으로 입력한 파일이 없는 경우 또는 
		
		return oldName;
	}
}