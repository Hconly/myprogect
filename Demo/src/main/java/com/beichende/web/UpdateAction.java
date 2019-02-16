package com.beichende.web;


import com.beichende.entity.Account;
import com.beichende.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * TODO
 * 
 * @author xxcxx
 * @version 1.0.0
 * @filename UpdateAction.java
 * @time 2019年1月9日 上午10:41:32 @copyright(C) 2019 深圳市北辰德科技股份有限公司
 */
public class UpdateAction extends ActionSupport implements ModelDriven<Account>{

	private static final long serialVersionUID = 1L;
	private Account account = new Account();
	@Override
	public Account getModel() {
		return account;
	}
	
    //自动注入
    AccountService accountService;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String updateAcco(){
        accountService.updateAcco(account);
        return NONE;
    }

}
