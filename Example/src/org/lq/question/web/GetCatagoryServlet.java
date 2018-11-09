package org.lq.question.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.question.entity.OlstCatagory;
import org.lq.question.service.OlstCatagoryService;
import org.lq.question.service.impl.OlstCatagoryServiceImpl;

/**
 * 查询所有元素,包含父节点对象信息
 */
@WebServlet("/GetCatagoryServlet")
public class GetCatagoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		List<OlstCatagory> list = catagoryService.getCatagoryInParent();
		request.setAttribute("list", list);
		request.getRequestDispatcher("showCatagory.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
