package test.dao;

import java.util.List;

import test.entity.Emp;

public interface EmpDao{
	/**
	 * ��ҳ��ѯ
	 * @param pageIndex ��ǰ��ʾ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize);
	
	/**
	 * ������ѯ��ҳ
	 * @param pageIndex ��ǰ��ʾ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return 
	 */
	public List<Emp> pageList(int pageIndex,int pageSize,String name);
	
	public int getCount();
}
