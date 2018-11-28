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
		//����������Ĳ���mehtod(��Ҫ���жϵ�ǰ���������Ҫִ��ʲô����)
		String method = request.getParameter("method");
		String index =request.getParameter("index");
		int pageIndex = 1; //��ǰҳ��
		int pageSize = 5;//û����ʾ������
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
		//ֻ����Ӻ��޸ĵ�ʱ��Ŵ�������
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
			//��ѯ���ݿ�
			Page<Emp> page= empService.findPage(pageIndex, pageSize, "");
			request.setAttribute("page", page);
			//��תҳ��
			request.getRequestDispatcher("Emp.jsp").forward(request, response);
			break;
		case "editemp":
			//���֮ǰ�Ĵ�������
			//��ѯ����Ա��
			List<Emp> emps= empService.findAll();
			//��ѯ���в���
			List<Dept> depts= deptService.findAll();
			//�洢����
			request.setAttribute("emps", emps);
			request.setAttribute("depts", depts);
			//��תҳ��
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
			//�޸�ִ�����Ĺ���
			//���ݱ�Ų�ѯԱ��
			Emp updateEmp= empService.getEmpByNo(CastUtil.castInt(empno));
			//��ѯ����Ա��
			List<Emp> UpdateEmps= empService.findAll();
			//��ѯ���в���
			List<Dept> UpdateDepts= deptService.findAll();
			//�洢����
			request.setAttribute("updatEmp", updateEmp);
			request.setAttribute("emps", UpdateEmps);
			request.setAttribute("depts", UpdateDepts);
			//��תҳ��
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
