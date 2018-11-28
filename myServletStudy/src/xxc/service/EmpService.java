package xxc.service;

import java.util.List;

import xxc.entity.Emp;

public interface EmpService {
	public List<Emp> findAll();
	boolean deleteEmp(int id);
}
