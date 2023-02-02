package community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;

public class DeleteController implements Controller{

	//삭제 작성
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
		request.setAttribute("list", dao.delete(idx));
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp"); 
		//dispatcher.forward(request, response);
		response.sendRedirect("list");
}
}
