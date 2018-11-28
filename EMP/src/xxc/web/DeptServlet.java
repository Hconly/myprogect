package xxc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxc.entity.Dept;
import xxc.service.DeptService;
import xxc.service.impl.DeptServiceImpl;
import xxc.util.CastUtil;
import xxc.util.Page;


@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int pageIndex = 1;
		int pageSize = 5;
		DeptService deptService = new DeptServiceImpl();
		//接收一个请求参数
		String method = request.getParameter("method");
		
		String index = request.getParameter("index");
		if(index!=null && !"".equals(index)) {
			pageIndex = CastUtil.castInt(index);
		}
		
		//------------
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		String no = request.getParameter("no");
		
		Dept dept = Dept.builder().dname(dname).loc(loc).deptno(CastUtil.castInt(no)).build();
		boolean bool = false;
		switch (method) {
		case "findPage":
			Page<Dept> page= deptService.findPage(pageIndex, pageSize);
			request.setAttribute("page", page);
			request.getRequestDispatcher("depts.jsp").forward(request, response);
			break;
		case "delete":
			int id = CastUtil.castInt(no);
			deptService.deleteDeptByNo(id);
			response.sendRedirect("DeptServlet?method=findPage");
			break;
		case "add":
			bool = deptService.saveDept(dept);
			if(bool ==true) {
				response.sendRedirect("DeptServlet?method=findPage");
			}else {
				response.sendRedirect("addDept.html");
			}
			break;
		case "byid":
			Dept d =deptService.getDeptByNo(CastUtil.castInt(no));
			request.setAttribute("dept", d);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			break;
		case "update":
			bool = deptService.updateDept(dept);
			if(bool == true) {
				response.sendRedirect("DeptServlet?method=findPage");
			}else {
				request.setAttribute("dept", dept);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
			break;
		case "like":
			Page<Dept> pageLike= deptService.findPage(pageIndex, pageSize,dname);
			request.setAttribute("page", pageLike);
			request.setAttribute("where", dname);
			request.getRequestDispatcher("depts.jsp").forward(request, response);
		default:
			response.sendRedirect("DeptServlet?method=findPage");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
