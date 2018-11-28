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
		
		people.setAddr("����֣��");
		people.setEmail("123@qq.com");
		people.setGender("Ů");
		people.setName("����");
		people.setPhone("137387387438");
		//����һ����¼
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
