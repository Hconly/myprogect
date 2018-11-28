package xxc.service.impl;

import java.util.List;

import xxc.dao.DeptDao;
import xxc.dao.impl.DeptDaoImpl;
import xxc.entity.Dept;
import xxc.service.DeptService;
import xxc.util.Page;

public class DeptServiceImpl implements DeptService{
	
	DeptDao deptDao = new DeptDaoImpl();
	
	//获取所有数据的时候为了处理数据的冗余要进行分页处理 
	//达到良好的展示效果
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll(1, deptDao.getCount(""), "");
	}

	@Override
	public Page<Dept> findPage(int pageIndex, int pageSize, String... dname) {
		//需要查询的内容
		String name = dname.length == 0 ? "" : dname[0];
		
		List<Dept> list = deptDao.findAll(pageIndex, pageSize, name);
		//封装分页对象
		Page<Dept> page = new Page<>();
		page.setData(list);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(deptDao.getCount(name));
		
		return page;
	}
	
	//保存
	@Override
	public boolean saveDept(Dept d) {
		return deptDao.insert(d)>0;
	}

	//通过ID删除
	@Override
	public boolean deleteDeptByNo(int no) {
		return deptDao.delete(no)>0;
	}

	//更新
	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.update(dept)>0;
	}
	
	//通过id获取
	@Override
	public Dept getDeptByNo(int no) {
		return deptDao.getDept(no);
	}
}
