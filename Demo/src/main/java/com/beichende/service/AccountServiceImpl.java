package com.beichende.service;

import com.beichende.dao.AccountDao;
import com.beichende.entity.Account;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {

    /*注入dao*/
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public List<Account> findByColumn(String cc, String cont) {
		return accountDao.findByColumn(cc, cont);
	}

	@Override
	public void delBatch(String ids) {
		accountDao.delBatch(ids);
	}

	@Override
	public void updateAcco(Account account) {
		accountDao.updateAcco(account);
	}
    
    

}
