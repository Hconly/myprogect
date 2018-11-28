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
 * ����Ȩ�ޱ��Servlet
 */
@WebServlet("/AnthortyRoleServelt")
public class AnthortyRoleServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		/**
		 * roleFindAll : ��ѯ���н�ɫ,��Ȩ�ޱ��ҳ��չʾ anthorty_changelist.html
		 * findanthortyRole : ������ǰ��ɫ��Ȩ�ޱ��,��ȡ��ɫ��� anthorty_change.html
		 * anthortyRoleSave : ������Ȩ�ޱ����ʱ��,��ҳ��Ľ�ɫid������Ȩ��id����
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
	 * Ȩ�ޱ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void anthortyRoleSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RoleInAnthortyService service = new RoleInAnthortyServiceImpl();
		//������Ҫ����Ľ�ɫ���
		String roleid= request.getParameter("roleid");
		//��ȡ����Ȩ�ޱ����Ϊ�ж����ѡ��,ʹ���������
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
		//��ȡ��ǰ�޸Ľ�ɫ�ı��
		String roleId= request.getParameter("roleId");
		
		RoleInfo info= roleService.getRoleById(CastUtil.castInt(roleId));
		//��ʾ��ǰϵͳ�е�����Ȩ�޶���
		List<AnthortyInfo> parents = anthortyInfoService.getParentInChild(roleId);
		//�洢
		request.setAttribute("role", info);
		request.setAttribute("anthortys", parents);
		//��ת���޸�Ȩ��ҳ��
		request.getRequestDispatcher("view/system/anthotychange/anthorty_change.jsp").forward(request, response);
		
	}
	
	
}
