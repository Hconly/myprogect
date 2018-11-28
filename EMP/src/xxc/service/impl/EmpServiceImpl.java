package xxc.service.impl;

import java.util.List;

import xxc.dao.EmpDao;
import xxc.dao.impl.EmpDaoImpl;
import xxc.entity.Dept;
import xxc.entity.Emp;
import xxc.service.EmpService;
import xxc.util.Page;

public class EmpServiceImpl implements EmpService{
	EmpDao empDao = new EmpDaoImpl();
	
	//获取所有数据的时候为了处理数据的冗余要进行分页处理 
	//达到良好的展示效果
	@Override
	public List<Emp> findAll() {
		return empDao.findAll(1, empDao.getCount(""), "");
	}

	@Override
	public Page<Emp> findPage(int pageIndex, int pageSize, String... ename) {
		//需要查询的内容
		String name = ename.length == 0 ? "" : ename[0];
		
		List<Emp> list = empDao.findAll(pageIndex, pageSize, name);
		//封装分页对象
		Page<Emp> page = new Page<>();
		page.setData(list);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(empDao.getCount(name));
		
		return page;
	}
	
	//保存
	@Override
	public boolean saveEmp(Emp d) {
		return empDao.insert(d)>0;
	}

	//通过ID删除
	@Override
	public boolean deleteEmpByNo(int no) {
		return empDao.delete(no)>0;
	}

	//更新
	@Override
	public boolean updateEmp(Emp dept) {
		return empDao.update(dept)>0;
	}
	
	//通过id获取
	@Override
	public Emp getEmpByNo(int no) {
		return empDao.getEmp(no);
	}
}
