package org.lq.service;

import java.util.List;

import org.lq.entity.Dept;
import org.lq.entity.Emp;
import org.lq.util.Page;

public interface EmpService {

	
	public List<Emp> findAll();
	/**
	 * ��ҳ
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @param dname ��ѯ����(��ѡ)
	 * @return page ��ҳ����
	 */
	public Page<Emp> findPage(int pageIndex,int pageSize,String...ename);
	
	public boolean saveEmp(Emp d);
	
	public boolean deleteEmpByNo(int no);
	
	public boolean updateEmp(Emp emp);
	
	public Emp getEmpByNo(int no);
	
}
