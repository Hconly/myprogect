package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LevelDao;
import entity.Table_Level;
import util.DBUtil;

public class LevelDaoImpl implements LevelDao {

	@Override
	public int addLevel(Table_Level level) {
		int num = 0;
		String sql = "insert into table_level (lname,ldiscount,ldesc) values(?,?,?)";
		num = DBUtil.executeupdate(sql, level.getLname(), level.getLdiscount(), level.getLdesc());
		return num;
	}

	@Override
	public int deleteLevel(int lid) {
		int num = 0;
		String sql = "delete from table_level where lid=?";
		num = DBUtil.executeupdate(sql, lid);
		return num;
	}

	@Override
	public int updateLevel(Table_Level level, int lid) {
		int num = 0;
		String sql = "update table_level set lname=?,ldiscount=?,ldesc=? where lid=?";
		num = DBUtil.executeupdate(sql, level.getLname(), level.getLdiscount(), level.getLdesc(), level.getLid());
		return num;
	}

	@Override
	public List<Table_Level> findAll() {
		List<Table_Level> list = new ArrayList<>();
		Table_Level level;
		ResultSet rs;
		String sql = "select * from table_level ";
		try {
			rs = DBUtil.executequery(sql);
			while (rs.next()) {
				level = new Table_Level();
				level.setLid(rs.getInt("lid"));
				level.setLname(rs.getString("lname"));
				level.setLdiscount(rs.getDouble("ldiscount"));
				level.setLdesc(rs.getString("ldesc"));
				list.add(level);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public Table_Level getLevelById(int lid) {
		Table_Level level = null;
		ResultSet rs;
		String sql = "select * from table_level where lid=?";
		try {
			rs = DBUtil.executequery(sql, lid);
			while (rs.next()) {
				level = new Table_Level();
				level.setLid(rs.getInt("lid"));
				level.setLname(rs.getString("lname"));
				level.setLdiscount(rs.getDouble("ldiscount"));
				level.setLdesc(rs.getString("ldesc"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return level;
	}

	@Override
	public List<Table_Level> getLevelLikeByColumn(String column, Object value) {
		List<Table_Level> list = new ArrayList<>();
		Table_Level level;
		ResultSet rs;
		String sql = "select * from table_level  where " + column + " like ?";
		try {
			rs = DBUtil.executequery(sql, "%" + value + "%");
			while (rs.next()) {
				level = new Table_Level();
				level.setLid(rs.getInt("lid"));
				level.setLname(rs.getString("lname"));
				level.setLdiscount(rs.getDouble("ldiscount"));
				level.setLdesc(rs.getString("ldesc"));
				list.add(level);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

}
