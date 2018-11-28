package org.lq.power.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.base.util.BeanNewInstance;
import org.lq.base.util.CastUtil;
import org.lq.power.entity.AnthortyInfo;
import org.lq.power.service.AnthortyInfoService;
import org.lq.power.service.impl.AnthortyInfoServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class AnthortyInfoServelt
 */
@WebServlet("/AnthortyInfoServelt")
public class AnthortyInfoServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String method = request.getParameter("method");
		switch (method) {
		case "save":
			save(request, response);
			break;
		case "findAll":
			findAll(request, response);
			break;
		case "findParent":
			findParent(request, response);
			break;
		case "show":
			showByid(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			break;
		}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



	/**
	 * 显示详细信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		AnthortyInfoService infoService = new AnthortyInfoServiceImpl();
		AnthortyInfo info= infoService.getAnthortyInfoById(CastUtil.castInt(id));
		request.setAttribute("anthorty", info);
		request.getRequestDispatcher("view/system/anthorty/anthorty_show.jsp").forward(request, response);
	}

	/**
	 * 添加权限
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//获取当前表单提交的所有数据
		//key  = 表单元素的 name值
		//value = 表单元素的value值
		Map<String,String[]> items= request.getParameterMap();
		
//		AnthortyInfo info = new AnthortyInfo();
//		try {
//			BeanUtils.populate(info, items);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
		
		AnthortyInfo info = BeanNewInstance.getInstance(AnthortyInfo.class, items);
		
		AnthortyInfoService infoService = new AnthortyInfoServiceImpl();
		boolean bool = infoService.addAnthortyInfo(info);
		//response.sendRedirect("view/system/anthorty/anthorty_list.html");
		//response.sendRedirect("AnthortyInfoServelt?method=findParent");
		response.getWriter().write("<script>parent.location.reload();</script>");
	}
	/**
	 * 查询所有
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AnthortyInfoService infoService = new AnthortyInfoServiceImpl();
		//request.setAttribute("anthortys", infoService.findAll());
		
		Gson gson= new Gson();
		
		response.getWriter().write(gson.toJson(infoService.findAll()));;
	}
	/**
	 * 获取父权限
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findParent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		AnthortyInfoService infoService = new AnthortyInfoServiceImpl();
		request.setAttribute("anthortyParent", infoService.findParemt());
		request.getRequestDispatcher("view/system/anthorty/anthorty_add.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {

	}
	/**
	 * 删除权限
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AnthortyInfoService infoService = new AnthortyInfoServiceImpl();
		String id= request.getParameter("id");
		boolean bool=infoService.deleteAnthortyById(CastUtil.castInt(id));
		String msg = "删除成功!";
		if(bool == false) {
			msg = "删除失败!";
		}
		response.getWriter().write("<script>alert('"+msg+"');parent.location.reload();</script>");
	}
	private void findPage(HttpServletRequest request, HttpServletResponse response) {

	}










}
