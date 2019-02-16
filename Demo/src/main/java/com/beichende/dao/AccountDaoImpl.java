package com.beichende.dao;

import com.beichende.entity.Account;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class AccountDaoImpl extends HibernateDaoSupport implements  AccountDao {

	//添加
	@Override
    public void save(Account account) {
        this.getHibernateTemplate().save(account);
    }

	//查询所有
	@Override
	public List<Account> findAll() {
		SessionFactory sf = this.getSessionFactory();
		Session session = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery("from Account").list();
		return list;
	}

	//条件查询
	@Override
	public List<Account> findByColumn(String cc, String cont) {
		SessionFactory sf = this.getSessionFactory();
		Session session = sf.getCurrentSession();
		String hql = "from Account acco where acco."+cc+" like '%"+cont+"%'";
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery(hql).list();
		return list;
	}

	//批量删除
	@Override
	public void delBatch(String ids) {
		SessionFactory sf = this.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery sqlQuery = session.createSQLQuery("delete from account where id in ("+ids+")");
		sqlQuery.executeUpdate();
		transaction.commit();
	}

	//更新操作
	@Override
	public void updateAcco(Account account) {
		this.getHibernateTemplate().update(account);
	}



}
