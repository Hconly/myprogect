package xxc.service;

import java.util.List;
import xxc.entity.Emp;
import xxc.util.Page;

public interface EmpService {
	public List<Emp> findAll();
	/**
	 * ��ҳ
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @param dname ��ѯ��(��ѡ)
	 * @return page ��ҳ����
	 */
	public Page<Emp> findPage(int pageIndex,int pageSize,String...ename);
	
	public boolean saveEmp(Emp emp);
	
	public boolean deleteEmpByNo(int no);
	
	public boolean updateEmp(Emp emp);
	
	public Emp getEmpByNo(int no);
}
