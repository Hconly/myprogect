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
	
	//��ȡ�������ݵ�ʱ��Ϊ�˴������ݵ�����Ҫ���з�ҳ���� 
	//�ﵽ���õ�չʾЧ��
	@Override
	public List<Emp> findAll() {
		return empDao.findAll(1, empDao.getCount(""), "");
	}

	@Override
	public Page<Emp> findPage(int pageIndex, int pageSize, String... ename) {
		//��Ҫ��ѯ������
		String name = ename.length == 0 ? "" : ename[0];
		
		List<Emp> list = empDao.findAll(pageIndex, pageSize, name);
		//��װ��ҳ����
		Page<Emp> page = new Page<>();
		page.setData(list);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(empDao.getCount(name));
		
		return page;
	}
	
	//����
	@Override
	public boolean saveEmp(Emp d) {
		return empDao.insert(d)>0;
	}

	//ͨ��IDɾ��
	@Override
	public boolean deleteEmpByNo(int no) {
		return empDao.delete(no)>0;
	}

	//����
	@Override
	public boolean updateEmp(Emp dept) {
		return empDao.update(dept)>0;
	}
	
	//ͨ��id��ȡ
	@Override
	public Emp getEmpByNo(int no) {
		return empDao.getEmp(no);
	}
}
