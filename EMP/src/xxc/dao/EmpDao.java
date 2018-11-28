package xxc.dao;

import java.util.List;
import xxc.entity.Emp;

public interface EmpDao {
	//��Ӽ�¼
			int insert(Emp d);
			//����Ա��
			int update(Emp d);
			//ɾ��Ա��
			int delete(int id);
			
			Emp getEmp(int id);
			/**
			 * ��ҳ��ѯ
			 * @param pageIndex ��ǰҳ��
		     * @param pageSize ÿҳ��ʾ������
		     * @param dname ��ѯ��������
		     * @return
			 */
			List<Emp> findAll(int pageIndex,int pageSize,String ename);
			
			 /**
		     * 	���ݲ������Ʋ�ѯ����
		     * 	��ȡ������
		     * @param dname
		     * @return
		     */
		    int getCount(String ename);
}
