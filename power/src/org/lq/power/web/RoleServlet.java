package org.lq.power.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.base.util.BeanNewInstance;
import org.lq.base.util.CastUtil;
import org.lq.power.entity.RoleInfo;
import org.lq.power.service.RoleService;
import org.lq.power.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		switch (method) {
		case "save":
			save(request,response);
			break;
		case "findAll":
			findAll(request,response);
			break;
		case "like":
			likeAll(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "byid":
			byid(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default:
			break;
		}
		
	}



	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//----------------------------------------------
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]> items= request.getParameterMap();
		
		RoleInfo info= BeanNewInstance.getInstance(RoleInfo.class, items);
		
		RoleService roleService = new RoleServiceImpl();
		boolean bool= roleService.saveRole(info);
		if(bool) {
			request.getRequestDispatcher("RoleServlet?method=findAll").forward(request, response);
		}else {
			request.getRequestDispatcher("view/roleinfo/roleinfo_add.jsp").forward(request, response);
		}
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		List<RoleInfo> list= roleService.findAll();
		
		request.setAttribute("roleList", list);
		request.getRequestDispatcher("view/system/roleinfo/roleinfo_list.jsp").forward(request, response);
		
	}
	private void likeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		String name = request.getParameter("roleName");
		
		List<RoleInfo> list= roleService.likeRoleByName(name);
		
		request.setAttribute("roleList", list);
		request.getRequestDispatcher("view/system/roleinfo/roleinfo_list.jsp").forward(request, response);
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map<String,String[]> items= request.getParameterMap();
		
		RoleInfo info= BeanNewInstance.getInstance(RoleInfo.class, items);
		
		RoleService roleService = new RoleServiceImpl();
		boolean bool= roleService.update(info);
		if(bool) {
			request.getRequestDispatcher("RoleServlet?method=findAll").forward(request, response);
		}else {
			request.getRequestDispatcher("view/system/roleinfo/roleinfo_update.jsp").forward(request, response);
		}
	}
	
	private void byid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		
		String id = request.getParameter("id");
		RoleInfo info= roleService.getRoleById(CastUtil.castInt(id));
		request.setAttribute("role", info);
		request.getRequestDispatcher("view/system/roleinfo/roleinfo_update.jsp").forward(request, response);
				
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RoleService roleService = new RoleServiceImpl();
		
		String id = request.getParameter("id");
		roleService.deleteRoleById(CastUtil.castInt(id));
		response.sendRedirect("RoleServlet?method=findAll");
	}
	
	
	
	
}
