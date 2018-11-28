package test;
import java.util.List;

import test.dao.EmpDao;
import test.dao.impl.EmpDaoImpl;
import test.entity.Emp;

public class Test {

	public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
		int pageIndex = 2;
		int pageSize = 3;
		
		List<Emp> list= dao.pageList(pageIndex, pageSize,"E");
		System.out.println("��"+pageIndex+"/"+pageSize+"������");
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
