package test.service;

import java.util.List;

import test.entity.Emp;

public interface EmpService {
	/**
	 * 分页查询
	 * @param pageIndex 当前显示的页数
	 * @param pageSize 每页显示的行数
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize);
	/**
	 * 总行数
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage(int pageSize);
}
