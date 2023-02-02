package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

import community.DeleteController;
import community.ListController;
import community.ReadController;
import community.UpdateController;
import community.UpdateViewController;
import community.WriteController;
import community.WriteViewController;


public class RequestControllerMapping {
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	//꿀팁 미리 null 넣고 그 다음에 Controller 만들기 
	public static void init() {
		//설계된 url,method 에 따라 처리할 controller 구현체를 Key,Value 로 HashMap에 저장합니다.
		mapping.put(new RequestKeyValue("/community/list", "GET"), new ListController() );
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController() );
		mapping.put(new RequestKeyValue("/community/write","POST"), new WriteController() );

		//게시판 글 상세보기 , 수정하기 , 삭제하기 
		//reat,update,update(저장) delete
		mapping.put(new RequestKeyValue("/community/read","GET"), new ReadController() );
		mapping.put(new RequestKeyValue("/community/update","GET"), new UpdateViewController() );
		mapping.put(new RequestKeyValue("/community/update","POST"), new UpdateController() );
		mapping.put(new RequestKeyValue("/community/delete","GET"), new DeleteController() );
		
	}		
		
	//url,method 필드를 저장하는 key 를 전달받아 HashMap에서 value(컨트롤러)를 리턴
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
}