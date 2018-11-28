package xxc.dao;

import java.util.List;

import xxc.entity.Dept;

public interface DeptDao {
		//添加纪录
		int insert(Dept d);
		//更新员工
		int update(Dept dept);
		//删除员工
		int delete(int id);
		
		Dept getDept(int id);
		/**
		 * 分页查询
		 * @param pageIndex 当前页数
	     * @param pageSize 每页显示的行数
	     * @param dname 查询部门名称
	     * @return
		 */
		List<Dept> findAll(int pageIndex,int pageSize,String dname);
		
		 /**
	     * 	根据部门名称查询数量
	     * 	获取总行数
	     * @param dname
	     * @return
	     */
	    int getCount(String dname);
}
