package dao.Impl;

import java.sql.ResultSet;

import dao.MangerDao;
import entity.Table_Manger;
import util.DBUtil;

public class MangerDaoImpl implements MangerDao {

	@Override
	public Table_Manger getMangerByMuser(String muser) {
		String sql = "select * from Table_Manger where muser=?";
		Table_Manger manger = null;
		ResultSet rs;
		try {
			rs = DBUtil.executequery(sql, muser);
			while (rs.next()) {
				manger = new Table_Manger();
				manger.setMadesc(rs.getString("madesc"));
				manger.setManger_id(rs.getInt("manger_id"));
				manger.setMpwd(rs.getString("mpwd"));
				manger.setMuser(rs.getString("muser"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll();
		}
		return manger;
	}

}
