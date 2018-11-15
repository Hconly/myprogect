package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.HallDao;
import entity.Table_Hall;
import util.DBUtil;

public class HallDaoImpl implements HallDao{

	@Override
	public int addHall(Table_Hall hall) {
		int num=0;
		String sql="insert into Table_Hall (hseat,hdesc,haddress)values(?,?,?)";
		num=DBUtil.executeupdate(sql, hall.getHseat(),hall.getHdesc(),hall.getHaddress());
		return num;
	}

	@Override
	public int deleteHall(int hid) {
		int num=0;
		String sql="detele from table_hall where hid=?";
		num=DBUtil.executeupdate(sql, hid);
		return num;
	}

	@Override
	public int updateHall(Table_Hall hall, int hid) {
		int num=0;
		String sql="update table_hall set hseat=?,hdesc=?,haddress=? where hid=?";
		num=DBUtil.executeupdate(sql, hall.getHseat(),hall.getHdesc(),hall.getHaddress(),hall.getHid());
		return num;
	}

	@Override
	public List<Table_Hall> findAll() {
		List<Table_Hall> list=new ArrayList<>();
		Table_Hall hall=null;
		ResultSet rs=null;
		String sql="select * from table_hall";
		try {
			rs=DBUtil.executequery(sql);
			while(rs.next()) {
				hall=new Table_Hall();
				hall.setHid(rs.getInt("hid"));
				hall.setHseat(rs.getInt("hseat"));
				hall.setHdesc(rs.getString("hdesc"));
				hall.setHaddress(rs.getString("haddress"));
				list.add(hall);
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
	public Table_Hall getHallById(int hid) {
		Table_Hall hall=null;
		ResultSet rs=null;
		String sql="select * from table_hall where hid=?";
		try {
			rs=DBUtil.executequery(sql,hid);
			while(rs.next()) {
				hall=new Table_Hall();
				hall.setHid(rs.getInt("hid"));
				hall.setHseat(rs.getInt("hseat"));
				hall.setHdesc(rs.getString("hdesc"));
				hall.setHaddress(rs.getString("haddress"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return hall;
	}

	@Override
	public List<Table_Hall> getHallLikeByColumn(String column, Object value) {
		List<Table_Hall> list=new ArrayList<>();
		Table_Hall hall=null;
		ResultSet rs=null;
		String sql="select * from table_hall "+column+" like ?";
		try {
			rs=DBUtil.executequery(sql,"%"+value+"%");
			while(rs.next()) {
				hall=new Table_Hall();
				hall.setHid(rs.getInt("hid"));
				hall.setHseat(rs.getInt("hseat"));
				hall.setHdesc(rs.getString("hdesc"));
				hall.setHaddress(rs.getString("haddress"));
				list.add(hall);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

}
