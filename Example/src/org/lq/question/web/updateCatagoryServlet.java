package org.lq.question.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.question.entity.OlstCatagory;
import org.lq.question.service.OlstCatagoryService;
import org.lq.question.service.impl.OlstCatagoryServiceImpl;
import org.lq.question.util.CastUtil;

/**
 * 修改课程信息
 */
@WebServlet("/updateCatagoryServlet")
public class updateCatagoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String pid = request.getParameter("pid");
		OlstCatagory catagory = OlstCatagory.builder()
				.content(content)
				.id(CastUtil.castInt(id))
				.pid(CastUtil.castInt(pid))
				.build();
				
		
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		boolean bool= catagoryService.updateCatagory(catagory);
		if(bool == true) {
			response.sendRedirect("GetCatagoryServlet");
		}else {
			response.sendRedirect("GetCatagoryByIdServlet?cid="+id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
