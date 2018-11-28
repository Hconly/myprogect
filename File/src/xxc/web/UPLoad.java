package xxc.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UPLoad")
public class UPLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//获取上传的文件
				Part part = request.getPart("myfile");
				//获取上传目录
				String realPath = request.getServletContext().getRealPath("upload");
				realPath= realPath+UUID.randomUUID().toString();
				part.write(realPath);
		doGet(request, response);
	}

}
