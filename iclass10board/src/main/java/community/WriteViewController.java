package community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;

public class WriteViewController implements Controller {
	
	
	
	
@Override
public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	RequestDispatcher dispatcher = request.getRequestDispatcher("write.jsp"); //요청 자체에 커뮤니티 폴더가 붙어있슴다
	dispatcher.forward(request, response);
	
	
	
	
	//POST 입력 방식으로 애트리뷰트에 저장 
}
}
