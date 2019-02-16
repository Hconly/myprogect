package com.beichende.web;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.beichende.entity.Account;
import com.beichende.service.AccountService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO
 * @author xxcxx
 * @version 1.0.0
 * @filename FindAllAction.java
 * @time 2019年1月8日 下午2:09:30
 * @copyright(C) 2019 深圳市北辰德科技股份有限公司
 */
public class FindAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

    AccountService accountService;
    public void setAccountService(AccountService accountService){
        this.accountService = accountService;
    }
    
    public void service() throws IOException{
    	HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		//String cont = new String(request.getParameter("cont").getBytes("ISO8859-1"), "UTF-8");
		String cont = request.getParameter("cont");
		String cc = request.getParameter("cc");
		if(cont == null || cont == ""){
			findAll(response);
		}else{
			findByCol(response,cc, cont);
		}
    }
    
	public String findAll(HttpServletResponse response) throws IOException{
		List<Account> findAll = accountService.findAll();
		Gson gson = new Gson();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", findAll.size());
		map.put("rows", findAll);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));
		return NONE;
	}
	
	public String findByCol(HttpServletResponse response,String cc,String cont) throws IOException{
		List<Account> findByColumn = accountService.findByColumn(cc, cont);
		Gson gson = new Gson();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", findByColumn.size());
		map.put("rows", findByColumn);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));
		return NONE;    
	}
	
}
