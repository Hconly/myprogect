package org.lq.power.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.base.util.CastUtil;
import org.lq.power.entity.AnthortyInfo;
import org.lq.power.entity.RoleInfo;
import org.lq.power.service.AnthortyInfoService;
import org.lq.power.service.RoleInAnthortyService;
import org.lq.power.service.RoleService;
import org.lq.power.service.impl.AnthortyInfoServiceImpl;
import org.lq.power.service.impl.RoleInAnthortyServiceImpl;
import org.lq.power.service.impl.RoleServiceImpl;

/**
 * 处理权限变更Servlet
 */
@WebServlet("/AnthortyRoleServelt")
public class AnthortyRoleServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		/**
		 * roleFindAll : 查询所有角色,在权限变更页面展示 anthorty_changelist.html
		 * findanthortyRole : 单击当前角色的权限变更,获取角色编号 anthorty_change.html
		 * anthortyRoleSave : 当单击权限变更的时候,将页面的角色id和所有权限id传入
		 */
		switch (method) {
		case "roleFindAll":
			RoleFindAll(request, response);
			break;
		case "findanthortyRole":
			findanthortyRole(request, response);
			break;
		case "anthortyRoleSave": 
			anthortyRoleSave(request, response);
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

	/**
	 * 权限变更
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void anthortyRoleSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RoleInAnthortyService service = new RoleInAnthortyServiceImpl();
		//接收需要变更的角色编号
		String roleid= request.getParameter("roleid");
		//获取所有权限编号因为有多个复选框,使用数组接收
		String [] aids= request.getParameterValues("aid");
		
		boolean bool = service.save(roleid, aids);
		if(bool) {
			request.getRequestDispatcher("AnthortyRoleServelt?method=roleFindAll").forward(request, response);	
		}else {
			request.getRequestDispatcher("AnthortyRoleServelt?method=findanthortyRole&roleId="+roleid).forward(request, response);
		}
		
		
	}
	
	private void RoleFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		List<RoleInfo> list= roleService.findAll();
		
		request.setAttribute("roleList", list);
		request.getRequestDispatcher("view/system/anthotychange/anthorty_changelist.jsp").forward(request, response);
		
	}
	
	
	private void findanthortyRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		AnthortyInfoService anthortyInfoService = new AnthortyInfoServiceImpl();
		//获取当前修改角色的编号
		String roleId= request.getParameter("roleId");
		
		RoleInfo info= roleService.getRoleById(CastUtil.castInt(roleId));
		//显示当前系统中的所有权限对象
		List<AnthortyInfo> parents = anthortyInfoService.getParentInChild(roleId);
		//存储
		request.setAttribute("role", info);
		request.setAttribute("anthortys", parents);
		//跳转到修改权限页面
		request.getRequestDispatcher("view/system/anthotychange/anthorty_change.jsp").forward(request, response);
		
	}
	
	
}
