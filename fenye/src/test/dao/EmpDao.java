package test.dao;

import java.util.List;

import test.entity.Emp;

public interface EmpDao{
	/**
	 * 分页查询
	 * @param pageIndex 当前显示的页数
	 * @param pageSize 每页显示的行数
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize);
	
	/**
	 * 条件查询分页
	 * @param pageIndex 当前显示的页数
	 * @param pageSize 每页显示的行数
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize,String name);
	
	public int getCount();
}
