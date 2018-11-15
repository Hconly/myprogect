package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovieTypeDao;
import entity.Table_MovieType;
import util.DBUtil;

public class MovieTypeDaoImpl implements MovieTypeDao {
	Table_MovieType mt = new Table_MovieType();

	@Override
	public int addMovieType(Table_MovieType m) {
		String sql = "insert into table_movietype (tname)values(?)";
		int num = DBUtil.executeupdate(sql, mt.getTname());
		DBUtil.closeAll();
		return num;
	}

	@Override
	public int deleteMovie(int id) {
		String sql = "delect from table_movietype where tid=?";
		int num = DBUtil.executeupdate(sql, id);
		DBUtil.closeAll();
		return num;
	}

	@Override
	public int updateMovieType(Table_MovieType m) {
		String sql = "update table_movietype set tname=? where tid=?";
		int num = DBUtil.executeupdate(sql, m.getTname(), m.getTid());
		DBUtil.closeAll();
		return num;
	}

	@Override
	public List<Table_MovieType> findAll() {
		List<Table_MovieType> list = new ArrayList<>();
		Table_MovieType mt = null;
		String sql = "select * from table_movietype";
		ResultSet rs = DBUtil.executequery(sql);
		try {
			while (rs.next()) {
				mt = new Table_MovieType();
				mt.setTid(rs.getInt("tid"));
				mt.setTname(rs.getString("tname"));
				list.add(mt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public Table_MovieType getById(int id) {
		String sql = "select * from table_movietype where tid=?";
		ResultSet rs = DBUtil.executequery(sql,id);
		try {
			while (rs.next()) {
				mt = new Table_MovieType();
				mt.setTid(rs.getInt("tid"));
				mt.setTname(rs.getString("tname"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return mt;
	}

//	public static void main(String[] args) {
//		MovieTypeDaoImpl m=new MovieTypeDaoImpl();
//		System.out.println(m.getById(1));
//	}

	@Override
	public List<Table_MovieType> likeByColumn(String columnName, Object value) {
		List<Table_MovieType> list = new ArrayList<>();
		Table_MovieType mt = null;
		String sql = "select * from table_movietype where "+columnName+" like ?";
		ResultSet rs = DBUtil.executequery(sql,value);
		try {
			while (rs.next()) {
				mt = new Table_MovieType();
				mt.setTid(rs.getInt("tid"));
				mt.setTname(rs.getString("tname"));
				list.add(mt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

}
