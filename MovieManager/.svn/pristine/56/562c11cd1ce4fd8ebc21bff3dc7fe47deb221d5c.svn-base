package service;

import dao.MangerDao;
import dao.Impl.MangerDaoImpl;
import entity.Table_Manger;

public class MangerServiceImpl implements MangerService {
	MangerDao mangerDao = new MangerDaoImpl();

	@Override
	public Table_Manger getMangerByMuser(String muser) {
		return  mangerDao.getMangerByMuser(muser);
	}

}
