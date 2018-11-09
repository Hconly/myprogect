package org.lq.question.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lq.question.entity.OlstCatagory;
import org.lq.question.service.OlstCatagoryService;
import org.lq.question.service.impl.OlstCatagoryServiceImpl;
import org.lq.question.util.CastUtil;

/**
 * 添加课程目录
 */
@WebServlet("/AddCatagoryServlet")
public class AddCatagoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		
		String pid= request.getParameter("pid");
		String content = request.getParameter("content");
		
		OlstCatagory catagory = OlstCatagory
				.builder()
				.pid(CastUtil.castInt(pid))
				.content(content)
				.build();
		
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		boolean bool = catagoryService.saveCatagory(catagory);
		if(bool == true) {
			session.setAttribute("success_msg", "课程添加成功!");
			response.sendRedirect("GetParentCatagory");
		}else {
			request.setAttribute("error_msg", "课程添加失败!");
			request.getRequestDispatcher("GetParentCatagory").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
