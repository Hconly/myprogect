package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ScheduleDao;
import entity.Table_Schedule;
import util.DBUtil;

public class ScheduleDaoImpl implements ScheduleDao {

	@Override
	public int addSchedual(Table_Schedule shedule) {
		int num = 0;
		String sql = "insert into table_schedule (mid,hid,s_price,s_begindate,s_enddate,s_sname)values(?,?,?,?,?,?)";
		num = DBUtil.executeupdate(sql, shedule.getMid(), shedule.getHid(), shedule.getS_price(),
				shedule.getS_begindate(), shedule.getS_enddate(), shedule.getSname());
		return num;
	}

	@Override
	public int deleteSchedule(int sid) {
		int num = 0;
		String sql = "delete from  table_schedule where sid=?";
		num = DBUtil.executeupdate(sql, sid);
		return num;
	}

	@Override
	public int updateSchedule(Table_Schedule schedule) {
		int num = 0;
		String sql = "update table_schedule set mid=?,hid=?,s_price=?,s_begindate=?,s_enddate=?,s_sname=? where sid=?";
		num = DBUtil.executeupdate(sql, schedule.getMid(), schedule.getHid(), schedule.getS_price(),
				schedule.getS_begindate(), schedule.getS_enddate(), schedule.getSname(), schedule.getSid());
		return num;
	}

	@Override
	public List<Table_Schedule> findAll() {
		List<Table_Schedule> list = new ArrayList<>();
		Table_Schedule schedule = null;
		String sql = "select * from table_schedule";
		ResultSet rs = null;
		try {
			rs = DBUtil.executequery(sql);
			while (rs.next()) {
				schedule = new Table_Schedule();
				schedule.setMid(rs.getInt("mid"));
				schedule.setHid(rs.getInt("hid"));
				schedule.setS_begindate(rs.getString("s_begindate"));
				schedule.setS_price(rs.getDouble("s_price"));
				schedule.setSid(rs.getInt("sid"));
				schedule.setS_enddate(rs.getString("s_enddate"));
				schedule.setSname(rs.getString("s_sname"));
				list.add(schedule);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public Table_Schedule getScheduleById(int sid) {
		Table_Schedule schedule = null;
		String sql = "select * from table_schedule where sid=?";
		ResultSet rs = null;
		try {
			rs = DBUtil.executequery(sql, sid);
			while (rs.next()) {
				schedule = new Table_Schedule();
				schedule.setMid(rs.getInt("mid"));
				schedule.setHid(rs.getInt("hid"));
				schedule.setS_begindate(rs.getString("s_begindate"));
				schedule.setS_price(rs.getDouble("s_price"));
				schedule.setSid(rs.getInt("sid"));
				schedule.setS_enddate(rs.getString("s_enddate"));
				schedule.setSname(rs.getString("s_sname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return schedule;
	}

	@Override
	public List<Table_Schedule> getScheduleLikeByColumn(String column, Object value) {
		List<Table_Schedule> list = new ArrayList<>();
		Table_Schedule schedule = null;
		String sql = "select * from table_schedule where " + column + " = ?";
		ResultSet rs = null;
		try {
			rs = DBUtil.executequery(sql,  value );
			while (rs.next()) {
				schedule = new Table_Schedule();
				schedule.setMid(rs.getInt("mid"));
				schedule.setHid(rs.getInt("hid"));
				schedule.setS_begindate(rs.getString("s_begindate"));
				schedule.setS_price(rs.getDouble("s_price"));
				schedule.setSid(rs.getInt("sid"));
				schedule.setS_enddate(rs.getString("s_enddate"));
				schedule.setSname(rs.getString("s_sname"));
				list.add(schedule);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public Table_Schedule getByTid(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table_Schedule getByMid(int mid) {
		Table_Schedule schedule = null;
		String sql = "select * from table_schedule where mid=?";
		ResultSet rs = null;
		try {
			rs = DBUtil.executequery(sql, mid);
			while (rs.next()) {
				schedule = new Table_Schedule();
				schedule.setMid(rs.getInt("mid"));
				schedule.setHid(rs.getInt("hid"));
				schedule.setS_begindate(rs.getString("s_begindate"));
				schedule.setS_price(rs.getDouble("s_price"));
				schedule.setSid(rs.getInt("sid"));
				schedule.setS_enddate(rs.getString("s_enddate"));
				schedule.setSname(rs.getString("s_sname"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return schedule;
	}


	@Override
	public List<Table_Schedule> getListMid(int mid) {
		List<Table_Schedule> list=new ArrayList<>();
		Table_Schedule  schedule=null;
		String sql="select * from table_schedule where mid=?";
		ResultSet rs=null;
		try {
			rs=DBUtil.executequery(sql,mid);
			while(rs.next()) {
				schedule=new Table_Schedule();
				schedule.setMid(rs.getInt("mid"));
				schedule.setHid(rs.getInt("hid"));
				schedule.setS_begindate(rs.getString("s_begindate"));
				schedule.setS_price(rs.getDouble("s_price"));
				schedule.setSid(rs.getInt("sid"));
				schedule.setS_enddate(rs.getString("s_enddate"));
				schedule.setSname(rs.getString("s_sname"));
				list.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

	
	
	
	

}