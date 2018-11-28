package xxc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxc.entity.Dept;
import xxc.entity.Emp;
import xxc.service.DeptService;
import xxc.service.EmpService;
import xxc.service.impl.DeptServiceImpl;
import xxc.service.impl.EmpServiceImpl;
import xxc.util.CastUtil;
import xxc.util.Page;


@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//接收请求传入的参数mehtod(主要是判断当前请求进来需要执行什么操作)
		String method = request.getParameter("method");
		String index =request.getParameter("index");
		int pageIndex = 1; //当前页数
		int pageSize = 5;//没有显示的行数
		EmpService empService = new EmpServiceImpl();
		DeptService deptService = new DeptServiceImpl();
		
		method = method == null ? "" : method;
		if(index!=null && !"".equals(index)) {
			pageIndex = CastUtil.castInt(index);
		}
		//-----------------------------------
		String empno = request.getParameter("empno");
		String ename =request.getParameter("ename");
		String job =request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		String hiredate=request.getParameter("hiredate");
		Emp emp = null;
		//只有添加和修改的时候才创建对象
		if("add".equals(method)||"update".equals(method)) {
			emp = Emp.builder()
					.comm(CastUtil.castDouble(comm))
					.deptno(CastUtil.castInt(deptno))
					.ename(ename)
					.hiredate(CastUtil.castSqlDatetoString(hiredate))
					.job(job)
					.mgr(CastUtil.castInt(mgr))
					.sal(CastUtil.castDouble(sal))
					.empno(CastUtil.castInt(empno))
					.build();
		}
		switch (method) {
		case "findAll":
			//查询数据库
			Page<Emp> page= empService.findPage(pageIndex, pageSize, "");
			request.setAttribute("page", page);
			//跳转页面
			request.getRequestDispatcher("Emp.jsp").forward(request, response);
			break;
		case "editemp":
			//添加之前的处理任务
			//查询所有员工
			List<Emp> emps= empService.findAll();
			//查询所有部门
			List<Dept> depts= deptService.findAll();
			//存储内容
			request.setAttribute("emps", emps);
			request.setAttribute("depts", depts);
			//跳转页面
			request.getRequestDispatcher("editEmp.jsp").forward(request, response);
			break;
		case "add":
			System.out.println(emp);
			boolean bool = empService.saveEmp(emp);
			if(bool == true) {
				response.sendRedirect("EmpServlet?method=findAll");
			}else {
				response.sendRedirect("EmpServlet?method=editemp");
			}
			break;
		case "byid":
			//修改执行做的工作
			//根据编号查询员工
			Emp updateEmp= empService.getEmpByNo(CastUtil.castInt(empno));
			//查询所有员工
			List<Emp> UpdateEmps= empService.findAll();
			//查询所有部门
			List<Dept> UpdateDepts= deptService.findAll();
			//存储内容
			request.setAttribute("updatEmp", updateEmp);
			request.setAttribute("emps", UpdateEmps);
			request.setAttribute("depts", UpdateDepts);
			//跳转页面
			request.getRequestDispatcher("editEmp.jsp").forward(request, response);
			break;
		case "update":
			
			bool = empService.updateEmp(emp);
			if(bool == true) {
				response.sendRedirect("EmpServlet?method=findAll");
			}else {
				response.sendRedirect("EmpServlet?method=byid&empno="+emp.getEmpno());
			}
			break;
		case "delete":
			 empService.deleteEmpByNo(Integer.valueOf(empno));
			 response.sendRedirect("EmpServlet?method=findAll");
			break;
		default:
			response.sendRedirect("error.html");
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	




}
