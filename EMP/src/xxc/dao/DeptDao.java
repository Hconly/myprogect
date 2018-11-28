package xxc.dao;

import java.util.List;

import xxc.entity.Dept;

public interface DeptDao {
		//��Ӽ�¼
		int insert(Dept d);
		//����Ա��
		int update(Dept dept);
		//ɾ��Ա��
		int delete(int id);
		
		Dept getDept(int id);
		/**
		 * ��ҳ��ѯ
		 * @param pageIndex ��ǰҳ��
	     * @param pageSize ÿҳ��ʾ������
	     * @param dname ��ѯ��������
	     * @return
		 */
		List<Dept> findAll(int pageIndex,int pageSize,String dname);
		
		 /**
	     * 	���ݲ������Ʋ�ѯ����
	     * 	��ȡ������
	     * @param dname
	     * @return
	     */
	    int getCount(String dname);
}
