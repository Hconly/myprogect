package xxc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxc.entity.Emp;
import xxc.service.EmpService;
import xxc.service.impl.EmpServiceImpl;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmpService empService = new EmpServiceImpl();
		List<Emp> userList = empService.findAll();
		for (Emp emp : userList) {
			System.out.println(emp);
		}
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("Emp.jsp").forward(request, response);
		
		
		String id = request.getParameter("id");
		System.out.println(id);
		boolean bool = empService.deleteEmp(Integer.parseInt(id));
		if(bool == true) {
			System.out.println("É¾³ý³É¹¦");
			request.getRequestDispatcher("Emp.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Emp.jsp").forward(request, response);
			System.out.println("É¾³ýÊ§°Ü");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
