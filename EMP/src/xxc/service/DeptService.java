package xxc.service;

import java.util.List;

import xxc.entity.Dept;
import xxc.util.Page;

public interface DeptService {
	public List<Dept> findAll();
	/**
	 * ��ҳ
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @param dname ��ѯ��(��ѡ)
	 * @return page ��ҳ����
	 */
	public Page<Dept> findPage(int pageIndex,int pageSize,String...dname);
	
	public boolean saveDept(Dept d);
	
	public boolean deleteDeptByNo(int no);
	
	public boolean updateDept(Dept dept);
	
	public Dept getDeptByNo(int no);
}
