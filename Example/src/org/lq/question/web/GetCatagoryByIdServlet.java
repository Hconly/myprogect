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
import org.lq.question.util.CastUtil;

/**
 * 根据id查询课程信息(修改使用)
 */
@WebServlet("/GetCatagoryByIdServlet")
public class GetCatagoryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接收用户传入的id
		String cid= request.getParameter("cid");
		//2. 调用通过id查询对象方法
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		OlstCatagory catagory= catagoryService.getCatagoryById(CastUtil.castInt(cid));
		List<OlstCatagory> parents= catagoryService.getParentCatagory();
		
		request.setAttribute("catagory", catagory);
		request.setAttribute("parents", parents);
		
		request.getRequestDispatcher("catagoryedit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
