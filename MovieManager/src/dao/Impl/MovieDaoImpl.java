package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import entity.Table_Movie;
import util.DBUtil;

public class MovieDaoImpl implements MovieDao {
	ResultSet rs = null;
	Table_Movie m = null;


	@Override
	public int addMovie(Table_Movie movie) {

		String sql = "insert into table_movie(m_name,m_mainactor,m_director,"
				+ "m_duration,m_desc,tid,m_image,m_score,m_price,hot)values(?,?,?,?,?,?,?,?,?,?)";

		return DBUtil.executeupdate(sql, movie.getM_name(), movie.getM_mainactor(), movie.getM_director(),
				movie.getM_duration(), movie.getM_desc(), movie.getTid(), movie.getM_image(), movie.getM_score(),
				movie.getM_price(),movie.getHot());

	}

	@Override
	public int deleteMovie(int id) {
		String sql = "delete from table_movie where mid=?";

		return DBUtil.executeupdate(sql, id);
	}

	@Override
	public int updateMovie(Table_Movie movie) {
		String sql = "update table_movie set m_name=?,m_mainactor=?,m_director=?,m_duration=?,m_desc=?,tid=?,m_image=?,m_score=?,m_price=?,hot=? where mid=?";
		return DBUtil.executeupdate(sql, movie.getM_name(), movie.getM_mainactor(), movie.getM_director(),
				movie.getM_duration(), movie.getM_desc(), movie.getTid(), movie.getM_image(), movie.getM_score(),
				movie.getM_price(),movie.getHot(), movie.getMid());

	}

	@Override
	public List<Table_Movie> findAll() {
		List<Table_Movie> list = new ArrayList<>();

		String sql = "select * from table_movie";
		rs = DBUtil.executequery(sql);
		try {
			while (rs.next()) {
				m = new Table_Movie();
				m.setM_desc(rs.getString("m_desc"));
				m.setM_director(rs.getString("m_director"));
				m.setM_duration(rs.getString("m_duration"));
				m.setM_image(rs.getString("m_image"));
				m.setM_mainactor(rs.getString("m_mainactor"));
				m.setM_name(rs.getString("m_name"));
				m.setM_price(rs.getShort("m_price"));
				m.setM_score(rs.getDouble("m_score"));
				m.setMid(rs.getInt("mid"));
				m.setTid(rs.getInt("tid"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public List<Table_Movie> getById(int tid) {
		String sql = "select * from table_movie where tid=?";
		rs = DBUtil.executequery(sql, tid);
		List<Table_Movie> list = new ArrayList<>();
		try {
			while (rs.next()) {
				m = new Table_Movie();
				m.setM_desc(rs.getString("m_desc"));
				m.setM_director(rs.getString("m_director"));
				m.setM_duration(rs.getString("m_duration"));
				m.setM_image(rs.getString("m_image"));
				m.setM_mainactor(rs.getString("m_mainactor"));
				m.setM_name(rs.getString("m_name"));
				m.setM_price(rs.getShort("m_price"));
				m.setM_score(rs.getDouble("m_score"));
				m.setMid(rs.getInt("mid"));
				m.setTid(rs.getInt("tid"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public List<Table_Movie> likeByColumn(String columnName, Object value) {
		List<Table_Movie> list = new ArrayList<>();

		String sql = "select * from table_movie where " + columnName + " like ?";
		rs = DBUtil.executequery(sql, "%"+value+"%");
		try {
			while (rs.next()) {
				m = new Table_Movie();
				m.setM_desc(rs.getString("m_desc"));
				m.setM_director(rs.getString("m_director"));
				m.setM_duration(rs.getString("m_duration"));
				m.setM_image(rs.getString("m_image"));
				m.setM_mainactor(rs.getString("m_mainactor"));
				m.setM_name(rs.getString("m_name"));
				m.setM_price(rs.getShort("m_price"));
				m.setM_score(rs.getDouble("m_score"));
				m.setMid(rs.getInt("mid"));
				m.setTid(rs.getInt("tid"));
			
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}
	public List<Table_Movie> findAAll() {
		List<Table_Movie> list=new ArrayList();
		Table_Movie tm=null;
		String sql="select * from table_movie";
		rs=DBUtil.executequery(sql);
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}
	public List<Table_Movie> findMovieByName(String name) {
		List<Table_Movie> list=new ArrayList();
		Table_Movie tm=null;
		String sql="select * from table_movie where m_name like ?";
		rs=DBUtil.executequery(sql,"%"+name+"%");
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}


	@Override
	public List<Table_Movie> findMovieByType(int tid) {
		List<Table_Movie> list=new ArrayList();
		Table_Movie tm=null;
		String sql="select * from table_movie where tid=?";
		rs=DBUtil.executequery(sql,tid);
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

	public Table_Movie getbyId(int mid) {
		Table_Movie tm=null;
		String sql="select * from table_movie where mid=?";
		rs=DBUtil.executequery(sql, mid);
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				tm.setHot(rs.getInt("hot"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return tm;
	}
	public Table_Movie getbyName(String name) {
		Table_Movie tm=null;
		String sql="select * from table_movie where m_name=?";
		rs=DBUtil.executequery(sql, name);
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				tm.setHot(rs.getInt("hot"));
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return tm;
	}


	@Override
	public List<Table_Movie> findMovieByHot(int hot) {
		List<Table_Movie> list=new ArrayList();
		Table_Movie tm=null;
		String sql="select * from table_movie where hot=?";
		rs=DBUtil.executequery(sql,hot);
		try {
			while(rs.next()) {
				tm=new Table_Movie();
				tm.setM_name(rs.getString("m_name"));
				tm.setM_mainactor(rs.getString("m_mainactor"));
				tm.setM_duration(rs.getString("m_duration"));
				tm.setM_score(rs.getDouble("m_score"));
				tm.setM_director(rs.getString("m_director"));
				tm.setM_image(rs.getString("m_image"));
				tm.setM_desc(rs.getString("m_desc"));
				tm.setMid(rs.getInt("mid"));
				tm.setTid(rs.getInt("tid"));
				tm.setM_price(rs.getDouble("m_price"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
