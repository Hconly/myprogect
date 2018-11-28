package xxc.dao;

import java.util.List;

import xxc.entity.Emp;

public interface EmpDao {
	public List<Emp> findAllEmp();
	int delteEmp(int id);
}
