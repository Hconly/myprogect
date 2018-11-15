package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderSeatDao;
import entity.Table_OrderSeat;
import util.DBUtil;

public class OrderSeatDaoImpl implements OrderSeatDao{

	@Override
	public int addOrderSeat(Table_OrderSeat orderSeat) {
		int num=0;
		String sql="insert into table_orderseat(seat_id)values(?)";
		num=DBUtil.executeupdate(sql, orderSeat.getSeat_id());
		return num;
	}

	@Override
	public int deleteOrder(int oid) {
		int num=0;
		String sql="delete from  table_orderseat where oid=? ";
		num=DBUtil.executeupdate(sql, oid);
		return num;
	}

	@Override
	public int updateOrder(Table_OrderSeat orderSeat, int oid) {
		int num=0;
		String sql="update  table_orderseat set seat_id=? where oid=?";
		num=DBUtil.executeupdate(sql, orderSeat.getSeat_id(),orderSeat.getOid());
		return num;
	}

	@Override
	public List<Table_OrderSeat> findAll() {
		List<Table_OrderSeat> list=new ArrayList<>();
		String sql="select * from table_orderseat ";
		Table_OrderSeat orderSeat=null;
		ResultSet rs=null;
		try {
			rs=DBUtil.executequery(sql);
			while(rs.next()) {
				orderSeat=new Table_OrderSeat();
				orderSeat.setOid(rs.getInt("oid"));
				orderSeat.setSeat_id(rs.getInt("seat_id"));
				list.add(orderSeat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Table_OrderSeat> getOrderById(int oid) {
		List<Table_OrderSeat> list=new ArrayList<>();
		String sql="select * from table_orderseat where oid=?";
		Table_OrderSeat orderSeat=null;
		ResultSet rs=null;
		try {
			rs=DBUtil.executequery(sql,oid);
			while(rs.next()) {
				orderSeat=new Table_OrderSeat();
				orderSeat.setOid(rs.getInt("oid"));
				orderSeat.setSeat_id(rs.getInt("seat_id"));
				list.add(orderSeat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Table_OrderSeat> getOrderSeatLikeByColumn(String column, Object value) {
		List<Table_OrderSeat> list=new ArrayList<>();
		String sql="select * from table_orderseat where "+column+" like ?";
		Table_OrderSeat orderSeat=null;
		ResultSet rs=null;
		try {
			rs=DBUtil.executequery(sql,"%"+value+"%");
			while(rs.next()) {
				orderSeat=new Table_OrderSeat();
				orderSeat.setOid(rs.getInt("oid"));
				orderSeat.setSeat_id(rs.getInt("seat_id"));
				list.add(orderSeat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Table_OrderSeat> getOrderByCustomer(int cid) {
		List<Table_OrderSeat> list=new ArrayList<>();
		String sql="select * from table_orderseat where cid =?";
		Table_OrderSeat orderSeat=null;
		ResultSet rs=null;
		try {
			rs=DBUtil.executequery(sql,cid);
			while(rs.next()) {
				orderSeat=new Table_OrderSeat();
				orderSeat.setOid(rs.getInt("oid"));
				orderSeat.setSeat_id(rs.getInt("seat_id"));
				list.add(orderSeat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
