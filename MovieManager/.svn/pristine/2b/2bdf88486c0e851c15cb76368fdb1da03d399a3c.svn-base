package dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Table_Customer;
import util.DBUtil;

public class CustomerDaoImpl implements dao.CustomerDao {

	@Override
	public int addCustomer(Table_Customer customer) {
		int num = 0;
		String sql = "insert into Table_Customer(cname,cphone,cmoney,cpwd,cbirthday,cpy,cgender,caddress,ccode,clid,cdesc,cphoto)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		num = DBUtil.executeupdate(sql, customer.getCname(), customer.getCphone(), customer.getCmoney(),
				customer.getCpwd(), customer.getCbirthday(), customer.getCpy(), customer.getCgender(),
				customer.getCaddress(), customer.getCcode(), customer.getClid(), customer.getCdesc(),
				customer.getCphoto());
		return num;
	}

	@Override
	public int deleteCustomer(int cid) {
		int num = 0;
		String sql = "delete from Table_Customer where cid=?";
		num = DBUtil.executeupdate(sql, cid);
		return num;
	}

	@Override
	public int updateCustomer(Table_Customer customer) {
		int num = 0;
		String sql = "update Table_Customer set cname=?,cphone=?,cmoney=?,cpwd=?,cbirthday=?,cpy=?,cgender=?,caddress=?,clid=?,cdesc=?,cphoto=? where cid=?";
		num = DBUtil.executeupdate(sql, customer.getCname(), customer.getCphone(), customer.getCmoney(),
				customer.getCpwd(), customer.getCbirthday(), customer.getCpy(), customer.getCgender(),
				customer.getCaddress(), customer.getClid(), customer.getCdesc(), customer.getCphoto(),
				customer.getCid());
		return num;
	}

	@Override
	public List<Table_Customer> findAll() {
		List<Table_Customer> list = new ArrayList<>();
		String sql = "select * from table_customer";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql);
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return list;
	}

	@Override
	public Table_Customer getCustomerById(int cid) {
		String sql = "select * from Table_Customer where cid=?";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql, cid);
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return customer;
	}

	@Override
	public List<Table_Customer> getCustomerLikeByColumn(String column, Object value) {
		List<Table_Customer> list = new ArrayList<>();
		String sql = "select * from Table_Customer where " + column + " like ?";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql, "%" + value + "%");
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
				list.add(customer);
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
	public int updateCustomer1(Table_Customer customer) {
		int num = 0;
		String sql = "update Table_Customer set cname=?,cphone=?,cmoney=?,cpwd=?,cbirthday=?,cpy=?,cgender=?,caddress=?,clid=? ,cdesc=?,cphoto=? where ccode=?";
		num = DBUtil.executeupdate(sql, customer.getCname(), customer.getCphone(), customer.getCmoney(),
				customer.getCpwd(), customer.getCbirthday(), customer.getCpy(), customer.getCgender(),
				customer.getCaddress(), customer.getClid(), customer.getCdesc(), customer.getCphoto(),
				customer.getCcode());
		return num;
	}

	@Override
	public Table_Customer getCustomerByMaxId() {
		String sql = "select * from Table_Customer where cid=(select max(cid) from table_customer)";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql);
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return customer;
	}

	@Override
	public Table_Customer getCustomerByCname(String cname) {
		String sql = "select * from Table_Customer where cname=?";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql, cname);
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return customer;
	}

	@Override
	public Table_Customer getCustomerByCcode(String ccode) {
		String sql = "select * from Table_Customer where ccode=?";
		Table_Customer customer = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql, ccode);
			while (rs.next()) {
				customer = new Table_Customer();
				customer.setCid(rs.getInt("cid"));
				customer.setCaddress(rs.getString("caddress"));
				customer.setCbirthday(rs.getString("cbirthday"));
				customer.setCcode(rs.getString("ccode"));
				customer.setCgender(rs.getString("cgender"));
				customer.setClid(rs.getInt("clid"));
				customer.setCmoney(rs.getDouble("cmoney"));
				customer.setCname(rs.getString("cname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setCpwd(rs.getString("cpwd"));
				customer.setCpy(rs.getString("cpy"));
				customer.setCdesc(rs.getString("cdesc"));
				customer.setCphoto(rs.getString("cphoto"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return customer;
	}

}
