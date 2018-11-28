package org.lq.power.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lq.power.dao.AnthortyInfoDao;
import org.lq.power.entity.AnthortyInfo;

import lombok.extern.log4j.Log4j;
@Log4j
public class AnthortyInfoDaoImpl implements AnthortyInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		return getQueryRunner().update("delete from anthorty_info where anthorty_id=?",id);
	}

	@Override
	public int insert(AnthortyInfo t) throws Exception {
		String sql = 
				"insert into anthorty_info\n" +
						"  ( anthorty_pid, anthorty_name, anthorty_desc, anthorty_url)\n" + 
						"values\n" + 
						"  ( ?, ?, ?, ?)";
		log.debug("È¨ÏÞÌí¼Ó:"+sql);
		return getQueryRunner().update(sql,t.getAnthorty_pid(),t.getAnthorty_name(),t.getAnthorty_desc(),t.getAnthorty_url());
	}

	@Override
	public AnthortyInfo selectByPrimaryKey(Integer id) throws Exception {
		return getQueryRunner().query("select * from anthorty_info where anthorty_id=?",
				new BeanHandler<>(AnthortyInfo.class),id);
	}

	@Override
	public int updateByPrimaryKey(AnthortyInfo t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AnthortyInfo> findAll() throws Exception {
		String sql = "select * from anthorty_info";
		return getQueryRunner().query(sql, new BeanListHandler<>(AnthortyInfo.class));
	}

	@Override
	public List<AnthortyInfo> findPage(int pageIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() throws Exception {
		return 0;
	}

	@Override
	public List<AnthortyInfo> getParent() throws Exception {
		String sql ="select * from anthorty_info where anthorty_pid = 0";
		return getQueryRunner().query(sql, new BeanListHandler<>(AnthortyInfo.class));
	}
	

	

}
