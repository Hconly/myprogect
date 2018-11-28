package test.dao;

import java.util.List;

import test.entity.Dept;

public interface DeptDao {
	/**
	 * ��ҳ��ѯ
	 * @param pageIndex ��ǰ��ʾ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return 
	 */
	public List<Dept> pageList(int pageIndex,int pageSize);
	
	/**
	 * ������ѯ��ҳ
	 * @param pageIndex ��ǰ��ʾ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return 
	 */
	public List<Dept> pageList(int pageIndex,int pageSize,String name);
	
	public int getCount();
}
