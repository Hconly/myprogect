package org.lq.question.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lq.question.dao.RadOptionsDao;
import org.lq.question.entity.RadOptions;
import org.lq.question.util.DBUtil;
/**
 * 选项
 * @author Administrator
 *
 */
public class RadOptionsDaoImpl implements RadOptionsDao {
	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());

	@Override
	public int save(RadOptions t) {
		String sql =
				"insert into rad_options\n" +
						"  (id, option_a, option_b, option_c, option_d, option_e, rad_id)\n" + 
						"values\n" + 
						"  (rad_options_seq.nextval, ?, ?, ?, ?, ?, ?)";
		int num = 0;
		try {
			num = qr.update(sql,t.getOption_A(),t.getOption_B(),t.getOption_C(),t.getOption_D(),t.getOption_E(),t.getRad_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(RadOptions t) {
		String sql = 
				"update rad_options\n" +
						"   set\n" + 
						"       option_a = ?,\n" + 
						"       option_b = ?,\n" + 
						"       option_c = ?,\n" + 
						"       option_d = ?,\n" + 
						"       option_e = ?,\n" + 
						"       rad_id = ?\n" + 
						" where id = ?";

		int num = 0;
		try {
			num = qr.update(sql,t.getOption_A(),t.getOption_B(),t.getOption_C(),t.getOption_D(),t.getOption_E(),t.getRad_id(),t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delete(int no) {
		String sql ="delete rad_options where id = ?";
		int num = 0;
		try {
			num = qr.update(sql,no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public RadOptions findById(int no) {
		String sql = "select id, option_a, option_b, option_c, option_d, option_e, rad_id from rad_options where id = ?";
		RadOptions options = null;
		try {
			options = qr.query(sql, new BeanHandler<>(RadOptions.class),no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return options;
	}

	@Override
	public List<RadOptions> findAll() {
		String sql = "select id, option_a, option_b, option_c, option_d, option_e, rad_id from rad_options";
		List<RadOptions> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(RadOptions.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<RadOptions> likeAll(String txt) {
		//TODO 选项为实现模糊查询
		return null;
	}

	@Override
	public RadOptions getQuestionsId(int id) {
		String sql = "select id, option_a, option_b, option_c, option_d, option_e, rad_id from rad_options where rad_id = ?";
		RadOptions options = null;
		try {
			options = qr.query(sql, new BeanHandler<>(RadOptions.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return options;
	}

}
