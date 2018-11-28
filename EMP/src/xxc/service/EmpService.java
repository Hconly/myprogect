package xxc.service;

import java.util.List;
import xxc.entity.Emp;
import xxc.util.Page;

public interface EmpService {
	public List<Emp> findAll();
	/**
	 * 分页
	 * @param pageIndex 当前页数
	 * @param pageSize 每页显示的行数
	 * @param dname 查询条(可选)
	 * @return page 分页对象
	 */
	public Page<Emp> findPage(int pageIndex,int pageSize,String...ename);
	
	public boolean saveEmp(Emp emp);
	
	public boolean deleteEmpByNo(int no);
	
	public boolean updateEmp(Emp emp);
	
	public Emp getEmpByNo(int no);
}
