package com.beichende.web;
import com.beichende.entity.Account;
import com.beichende.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveAction extends ActionSupport implements ModelDriven<Account> {
    
	private static final long serialVersionUID = 1L;
	/**
     * 模型驱动
     */
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

    public String save(){
        accountService.save(account);
        return NONE;
    }
}
