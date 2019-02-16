package com.beichende.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.beichende.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO
 * 
 * @author xxcxx
 * @version 1.0.0
 * @filename DelAction.java
 * @time 2019年1月9日 上午10:41:22 @copyright(C) 2019 深圳市北辰德科技股份有限公司
 */
public class DelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	AccountService accountService;
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public String delBatch() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		accountService.delBatch(ids);
		return NONE;
	}
}
