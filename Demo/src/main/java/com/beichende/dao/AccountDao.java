package com.beichende.dao;
import java.util.List;
import com.beichende.entity.Account;

public interface AccountDao {
    public void save(Account account);
    public List<Account> findAll();
    public List<Account> findByColumn(String cc,String cont);
    public void delBatch(String ids);
    public void updateAcco(Account account);
}
