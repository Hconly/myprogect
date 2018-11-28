package test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.entity.Emp;
import test.service.EmpService;
import test.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 分页
		 *  当前页数
		 *  每页显示的行数
		 */
		
		int pageIndex = 1;//当前页数
		int pageSize = 6; // 每页显示的行数
		
		String index= request.getParameter("index");
		//接收前台传入的页数,如果不等于null代表有值,将当前页数赋值
		if(index!=null) {
			pageIndex = Integer.parseInt(index);
		}
		
		EmpService empService = new EmpServiceImpl();
		List<Emp> list= empService.pageList(pageIndex, pageSize);
		
		request.setAttribute("emps", list);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("totalCount", empService.getTotalCount());
		request.setAttribute("totalPage", empService.getTotalPage(pageSize));
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
