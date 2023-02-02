package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class WriteController implements Controller {

	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//기능을 처리하기 위한 코딩 작성 	//POST 입력 방식으로 애트리뷰트에 저장  글 쓰는 action 서블릿 
	
		request.setCharacterEncoding("UTF-8");
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Community vo = Community.builder()
				.title(title)
				.writer(writer)
				.content(content)
				.ip(ip)
				.build();
		
		CommunityDao dao = CommunityDao.getInstance();
		long result = dao.insert(vo);
		if(result!=0) {
			response.sendRedirect("list");
		}else {
			//메인화면으로 이동
			response.sendRedirect(request.getContextPath());
		}
			
	}

}