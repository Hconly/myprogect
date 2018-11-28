package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.omg.PortableServer.POA;

public class DBUtil {
	public static void main(String[] args) {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		People people = new People();
		
		people.setAddr("河南郑州");
		people.setEmail("123@qq.com");
		people.setGender("女");
		people.setName("王五");
		people.setPhone("137387387438");
		//保存一条记录
		session.save(people);
		beginTransaction.commit();	
	}
	@Test
	public void getOneOne() {
		Session session = HibernateUtil.openSession();
		People people = session.get(People.class, 1);
		System.out.println(people);
	}
}
