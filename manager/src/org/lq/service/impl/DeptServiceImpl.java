package org.lq.service.impl;

import java.util.List;

import org.lq.dao.DeptDao;
import org.lq.dao.impl.DeptDaoImpl;
import org.lq.entity.Dept;
import org.lq.service.DeptService;
import org.lq.util.Page;

public class DeptServiceImpl implements DeptService {
	DeptDao deptDao = new DeptDaoImpl();

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll(1, deptDao.getCount(""), "");
	}

	@Override
	public Page<Dept> findPage(int pageIndex, int pageSize, String... dname) {
		//需要查询的内容
		String name = dname == null ? "" : dname[0];
		
		List<Dept> list = deptDao.findAll(pageIndex, pageSize, name);
		//封装分页对象
		Page<Dept> page = new Page<>();
		page.setData(list);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(deptDao.getCount(name));
		
		return page;
	}

	@Override
	public boolean saveDept(Dept d) {
		return deptDao.insert(d)>0;
	}

	@Override
	public boolean deleteDeptByNo(int no) {
		return deptDao.delete(no)>0;
	}

	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.update(dept)>0;
	}

	@Override
	public Dept getDeptByNo(int no) {
		return deptDao.getDept(no);
	}

}
