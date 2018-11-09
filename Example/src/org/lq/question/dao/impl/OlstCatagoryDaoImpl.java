package org.lq.question.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lq.question.dao.OlstCatagoryDao;
import org.lq.question.entity.OlstCatagory;
import org.lq.question.util.DBUtil;

public class OlstCatagoryDaoImpl implements OlstCatagoryDao {
	
	QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	
	@Override
	public int save(OlstCatagory t) {
		int num = 0;
		String sql ="insert into olts_catagory\n" +
						"  (id, content, pid)\n" + 
						"values\n" + 
						"  (olts_catagory_seq.nextval, ?, ?)";

		try {
			num = qr.update(sql,t.getContent(),t.getPid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(OlstCatagory t) {
		int num = 0;
		String sql ="update olts_catagory\n" +
						"   set\n" + 
						"       content = ?,\n" + 
						"       pid = ?\n" + 
						" where id = ?";
		try {
			num = qr.update(sql,t.getContent(),t.getPid(),t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int delete(int no) {
		String sql = "delete from olts_catagory where id = ?";
		int num = 0;
		try {
			num = qr.update(sql,no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public OlstCatagory findById(int no) {
		OlstCatagory catagory = null;
		try {
			catagory = qr.query(
					"select * from olts_catagory where id = ?", 
					new BeanHandler<>(OlstCatagory.class),
					no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catagory;
	}

	@Override
	public List<OlstCatagory> findAll() {
		List<OlstCatagory> list = null;
		try {
			list = qr.query("select * from olts_catagory", new BeanListHandler<>(OlstCatagory.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OlstCatagory> likeAll(String txt) {
		List<OlstCatagory> list = null;
		try {
			list = qr.query("select * from olts_catagory where content like ?",
					new BeanListHandler<>(OlstCatagory.class),
					"%"+txt+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getChildCount(int id) {
		String sql = "select count(1) from olts_catagory where pid =?";
		int count = 0;
		try {
			BigDecimal decimal= qr.query(sql, new ScalarHandler<>(),id);
			count = decimal.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
