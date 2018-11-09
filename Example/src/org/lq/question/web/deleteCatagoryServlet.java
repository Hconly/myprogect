package org.lq.question.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lq.question.service.OlstCatagoryService;
import org.lq.question.service.impl.OlstCatagoryServiceImpl;
import org.lq.question.util.CastUtil;

/**
 * 删除课程目录
 */
@WebServlet("/deleteCatagoryServlet")
public class deleteCatagoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("success_msg");
		session.removeAttribute("error_msg");
		String id = request.getParameter("id");
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		boolean bool= catagoryService.deleteCatagoryById(CastUtil.castInt(id));
		if(bool == true) {
			session.setAttribute("success_msg", "编号["+id+"]删除成功!");
		}else {
			session.setAttribute("error_msg", "编号["+id+"]删除失败!当前节点下面存在子节点不可删除...");
		}
		response.sendRedirect("GetCatagoryServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
