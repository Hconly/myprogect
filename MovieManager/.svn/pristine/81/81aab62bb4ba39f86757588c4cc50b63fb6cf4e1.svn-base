package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entity.Table_Order;
import util.DBUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public int addOrder(Table_Order order) {
		int num=0;
		String sql="insert into table_order(cid,sid,buydate,mid,seat_id,order_number,comment)values(?,?,?,?,?,?,?)";
		num=DBUtil.executeupdate(sql, order.getCid(),order.getSid(),order.getBuydate(),order.getMid(),order.getSeat_id(),order.getOrder_number(),order.getComment());
		return num;
	}

	@Override
	public int deleteOrder(int oid) {
		int num=0;
		String sql="delete from table_order where oid=?";
		num=DBUtil.executeupdate(sql, oid);
		return num;
	}

	@Override
	public int updateOrder(Table_Order order) {
		int num=0;
		String sql="update table_order set cid=?,sid=?,mid=?,seat_id=?,comment=? where oid=?";
		num=DBUtil.executeupdate(sql, order.getCid(),order.getSid(),order.getMid(),order.getSeat_id(),order.getComment(),order.getOid());
		return num;
	}

	@Override
	public List<Table_Order> findAll() {
		List<Table_Order> list=new ArrayList<>();
		Table_Order order=null;
		String sql="select * from table_order";
		ResultSet rs=null;
		
		try {
			rs=DBUtil.executequery(sql);
			while(rs.next()) {
				order=new Table_Order();
				order.setOid(rs.getInt("oid"));
				order.setCid(rs.getInt("cid"));
				order.setSid(rs.getInt("sid"));
				order.setBuydate(rs.getString("buydate"));
				order.setMid(rs.getInt("mid"));
				order.setSeat_id(rs.getInt("seat_id"));
				order.setOrder_number(rs.getString("order_number"));
				order.setComment(rs.getString("comment"));
				list.add(order);
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
	public Table_Order getOrderById(int oid) {
		Table_Order order=null;
		String sql="select * from table_order where oid=?";
		ResultSet rs=null;
		
		try {
			rs=DBUtil.executequery(sql,oid);
			while(rs.next()) {
				order=new Table_Order();
				order.setOid(rs.getInt("oid"));
				order.setCid(rs.getInt("cid"));
				order.setSid(rs.getInt("sid"));
				order.setBuydate(rs.getString("buydate"));
				order.setMid(rs.getInt("mid"));
				order.setSeat_id(rs.getInt("seat_id"));
				order.setOrder_number(rs.getString("order_number"));
				order.setComment(rs.getString("comment"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return order;
	}

	@Override
	public List<Table_Order> getOrderLikeByColumn(String column, Object value) {
		List<Table_Order> list=new ArrayList<>();
		Table_Order order=null;
		String sql="select * from table_order where "+ column+" like ? ";
		ResultSet rs=null;
		
		try {
			rs=DBUtil.executequery(sql,"%"+value+"%");
			while(rs.next()) {
				order=new Table_Order();
				order.setOid(rs.getInt("oid"));
				order.setCid(rs.getInt("cid"));
				order.setSid(rs.getInt("sid"));
				order.setBuydate(rs.getString("buydate"));
				order.setMid(rs.getInt("mid"));
				order.setSeat_id(rs.getInt("seat_id"));
				order.setOrder_number(rs.getString("order_number"));
				order.setComment(rs.getString("comment"));
				list.add(order);
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
	public List<Table_Order> getOrderByCustomer(int cid) {
		List<Table_Order> list=new ArrayList<>();
		Table_Order order=null;
		String sql="select * from table_order where cid=?";
		ResultSet rs=null;
		
		try {
			rs=DBUtil.executequery(sql,cid);
			while(rs.next()) {
				order=new Table_Order();
				order.setOid(rs.getInt("oid"));
				order.setCid(rs.getInt("cid"));
				order.setSid(rs.getInt("sid"));
				order.setBuydate(rs.getString("buydate"));
				order.setMid(rs.getInt("mid"));
				order.setSeat_id(rs.getInt("seat_id"));
				order.setOrder_number(rs.getString("order_number"));
				order.setComment(rs.getString("comment"));
				list.add(order);
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
