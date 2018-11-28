package org.lq.service;

import java.util.List;

import org.lq.entity.Dept;
import org.lq.entity.Emp;
import org.lq.util.Page;

public interface EmpService {

	
	public List<Emp> findAll();
	/**
	 * 分页
	 * @param pageIndex 当前页数
	 * @param pageSize 每页显示的行数
	 * @param dname 查询条件(可选)
	 * @return page 分页对象
	 */
	public Page<Emp> findPage(int pageIndex,int pageSize,String...ename);
	
	public boolean saveEmp(Emp d);
	
	public boolean deleteEmpByNo(int no);
	
	public boolean updateEmp(Emp emp);
	
	public Emp getEmpByNo(int no);
	
}
