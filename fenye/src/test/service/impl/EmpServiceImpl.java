package test.service.impl;

import java.util.List;

import test.dao.EmpDao;
import test.dao.impl.EmpDaoImpl;
import test.entity.Emp;
import test.service.EmpService;

public class EmpServiceImpl implements EmpService{

	EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Emp> pageList(int pageIndex, int pageSize) {
		return empDao.pageList(pageIndex, pageSize);
	}

	@Override
	public int getTotalCount() {
		return empDao.getCount();
	}

	@Override
	public int getTotalPage(int pageSize) {
		int count =getTotalCount();
		return count % pageSize == 0 ? count / pageSize : count/pageSize+1;
	}

}
