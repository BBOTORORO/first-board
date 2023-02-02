package community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateViewController implements Controller {

//업데이트 뷰 작성 	
@Override
public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
	long idx=0;
	try {
		idx = Long.parseLong(temp);
	}catch (NumberFormatException e) {
		response.sendRedirect("list");
	}
	
	CommunityDao dao = CommunityDao.getInstance();
	Community vo = dao.selectByIdx(idx);
	request.setAttribute("vo", vo);
	
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
	dispatcher.forward(request, response);
}
}

