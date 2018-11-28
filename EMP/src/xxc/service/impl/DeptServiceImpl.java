package xxc.service.impl;

import java.util.List;

import xxc.dao.DeptDao;
import xxc.dao.impl.DeptDaoImpl;
import xxc.entity.Dept;
import xxc.service.DeptService;
import xxc.util.Page;

public class DeptServiceImpl implements DeptService{
	
	DeptDao deptDao = new DeptDaoImpl();
	
	//��ȡ�������ݵ�ʱ��Ϊ�˴������ݵ�����Ҫ���з�ҳ���� 
	//�ﵽ���õ�չʾЧ��
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll(1, deptDao.getCount(""), "");
	}

	@Override
	public Page<Dept> findPage(int pageIndex, int pageSize, String... dname) {
		//��Ҫ��ѯ������
		String name = dname.length == 0 ? "" : dname[0];
		
		List<Dept> list = deptDao.findAll(pageIndex, pageSize, name);
		//��װ��ҳ����
		Page<Dept> page = new Page<>();
		page.setData(list);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(deptDao.getCount(name));
		
		return page;
	}
	
	//����
	@Override
	public boolean saveDept(Dept d) {
		return deptDao.insert(d)>0;
	}

	//ͨ��IDɾ��
	@Override
	public boolean deleteDeptByNo(int no) {
		return deptDao.delete(no)>0;
	}

	//����
	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.update(dept)>0;
	}
	
	//ͨ��id��ȡ
	@Override
	public Dept getDeptByNo(int no) {
		return deptDao.getDept(no);
	}
}
