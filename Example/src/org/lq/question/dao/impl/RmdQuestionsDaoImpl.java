package org.lq.question.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lq.question.dao.RmdQuestionsDao;
import org.lq.question.entity.RmdQuestions;
import org.lq.question.util.DBUtil;
/**
 * Ã‚∏…
 * @author Administrator
 *
 */
public class RmdQuestionsDaoImpl implements RmdQuestionsDao {
	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());

	@Override
	public int save(RmdQuestions t) {
		String sql =
				"insert into rmd_questions\n" +
						"  (id, question, correct, quest_type, quest_ctgr, descrpt)\n" + 
						"values\n" + 
						"  (rmd_questions_seq.nextval, ?, ?, ?, ?, ?)";
		int num = 0;
		try {
			num = qr.update(sql,t.getQuestion(),t.getCorrect(),t.getQuest_type(),t.getQuest_ctgr(),t.getDescrpt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(RmdQuestions t) {
		String sql = 
				"update rmd_questions\n" +
						"   set\n" + 
						"       question = ?,\n" + 
						"       correct = ?,\n" + 
						"       quest_type = ?,\n" + 
						"       quest_ctgr = ?,\n" + 
						"       descrpt = ?\n" + 
						" where id = ?";

		int num = 0;
		try {
			num = qr.update(sql,t.getQuestion(),t.getCorrect(),t.getQuest_type(),t.getQuest_ctgr(),t.getDescrpt(),t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delete(int no) {
		String sql = "delete rmd_questions where id = ?";
		int num = 0;
		try {
			num = qr.update(sql,no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public RmdQuestions findById(int no) {
		String sql = "select id, question, correct, quest_type, quest_ctgr, descrpt from rmd_questions where id= ?";
		RmdQuestions questions = null;
		try {
			questions = qr.query(sql, new BeanHandler<>(RmdQuestions.class),no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public List<RmdQuestions> findAll() {
		String sql = "select id, question, correct, quest_type, quest_ctgr, descrpt from rmd_questions";
		List<RmdQuestions> list =  null;
		
		try {
			list = qr.query(sql, new BeanListHandler<>(RmdQuestions.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<RmdQuestions> likeAll(String txt) {
		String sql = "select id, question, correct, quest_type, quest_ctgr, descrpt from rmd_questions where question like ?";
		List<RmdQuestions> list =  null;
		
		try {
			list = qr.query(sql, new BeanListHandler<>(RmdQuestions.class),"%"+txt+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getCuurVal() {
		String sql = "select rmd_questions_seq.currval from dual";
		int num = 0;
		try {
			BigDecimal decimal = qr.query(sql, new ScalarHandler<>());
			num = decimal.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return num;
	}

}
