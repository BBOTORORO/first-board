package community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

public class ReadController implements Controller {

	
	//읽기 뷰 코딩 작성
	@Override
		
		public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//지정된 idx 메인글 읽기
			String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
			int idx=0;
			try {
				idx = Integer.parseInt(temp);
			}catch (NumberFormatException e) { 
				response.sendRedirect("list");
			}
			
			CommunityDao dao = CommunityDao.getInstance();
			//조회수 증가 : 실행 위치는? 
			dao.setReadCount(idx); //조회수 증가 메소드
			Community vo = dao.selectByIdx(idx);	
			request.setAttribute("vo", vo);
			
			//idx 메인글의 댓글리스트를 애트리뷰트에 저장하기
			List<CommunityComments> cmtlist = dao.comments(idx);
			request.setAttribute("cmtlist", cmtlist);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
			dispatcher.forward(request, response);
		}
	}
	

