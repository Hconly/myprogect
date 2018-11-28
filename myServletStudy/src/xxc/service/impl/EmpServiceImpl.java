package xxc.service.impl;

import java.util.List;

import xxc.dao.EmpDao;
import xxc.dao.impl.EmpDaoImpl;
import xxc.entity.Emp;
import xxc.service.EmpService;

public class EmpServiceImpl implements EmpService{
	EmpDao empDao = new EmpDaoImpl();
	@Override
	public List<Emp> findAll() {
		return empDao.findAllEmp();
	}
	@Override
	public boolean deleteEmp(int id) {
		return empDao.delteEmp(id)>0;
	}

}
