package test.service;

import java.util.List;

import test.entity.Emp;

public interface EmpService {
	/**
	 * ��ҳ��ѯ
	 * @param pageIndex ��ǰ��ʾ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize);
	/**
	 * ������
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * ��ҳ��
	 * @return
	 */
	public int getTotalPage(int pageSize);
}
