package org.lq.question.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.question.entity.OlstCatagory;
import org.lq.question.service.OlstCatagoryService;
import org.lq.question.service.impl.OlstCatagoryServiceImpl;

/**
 * ��ѯ���нڵ�
 * ��ѯ���ڵ�
 */
@WebServlet("/GetParentCatagory")
public class GetParentCatagory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���մ������
 		String method= request.getParameter("method");
		
		OlstCatagoryService catagoryService = new OlstCatagoryServiceImpl();
		List<OlstCatagory> list = catagoryService.getParentCatagory();
		request.setAttribute("parentList", list);
		request.setAttribute("catagoryList", catagoryService.findAll());
		if("questions".equals(method)) {
			request.getRequestDispatcher("addQuestions.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("addCatagory.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
