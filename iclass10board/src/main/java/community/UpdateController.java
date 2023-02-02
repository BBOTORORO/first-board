package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateController implements Controller{

	
	//업데이트 저장 작성
@Override
public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
	long idx=0;
	try {
		idx = Long.parseLong(temp);
	}catch (NumberFormatException e) {
		response.sendRedirect("list");
	}
	
	// idx 받아서 수정 ?
	String title = request.getParameter("title");
	String ip = request.getRemoteAddr();
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	Community vo = Community.builder()
			.idx(idx)
			.ip(ip)
			.title(title)
			.content(content)
			.build();

	response.setCharacterEncoding("UTF-8"); 
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	CommunityDao dao = CommunityDao.getInstance();
	request.setAttribute("list", dao.update(vo));
	
	long result = dao.update(vo);
	if (result!=0) {
		out.print("<script>");
		out.print("alert('글 수정 완료됐습니다');");
		out.print("location.href='list'");
		out.print("</script>");
		
	}else {
		out.print("<script>");
		out.print("alert('글 수정에 문제가 있습니다');");
		out.print("location.href='update'");
		out.print("</script>");
		
	}
}
}

