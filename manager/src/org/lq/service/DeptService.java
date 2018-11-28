package org.lq.service;

import java.util.List;

import org.lq.entity.Dept;
import org.lq.util.Page;

public interface DeptService {
	
	public List<Dept> findAll();
	/**
	 * 分页
	 * @param pageIndex 当前页数
	 * @param pageSize 每页显示的行数
	 * @param dname 查询条件(可选)
	 * @return page 分页对象
	 */
	public Page<Dept> findPage(int pageIndex,int pageSize,String...dname);
	
	public boolean saveDept(Dept d);
	
	public boolean deleteDeptByNo(int no);
	
	public boolean updateDept(Dept dept);
	
	public Dept getDeptByNo(int no);
	

}
