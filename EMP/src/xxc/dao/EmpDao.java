package xxc.dao;

import java.util.List;
import xxc.entity.Emp;

public interface EmpDao {
	//添加纪录
			int insert(Emp d);
			//更新员工
			int update(Emp d);
			//删除员工
			int delete(int id);
			
			Emp getEmp(int id);
			/**
			 * 分页查询
			 * @param pageIndex 当前页数
		     * @param pageSize 每页显示的行数
		     * @param dname 查询部门名称
		     * @return
			 */
			List<Emp> findAll(int pageIndex,int pageSize,String ename);
			
			 /**
		     * 	根据部门名称查询数量
		     * 	获取总行数
		     * @param dname
		     * @return
		     */
		    int getCount(String ename);
}
