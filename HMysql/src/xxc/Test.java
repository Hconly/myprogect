package xxc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration configure = new Configuration().configure(); 
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		
		User user = new User();
		user.setEmail("1234");
		user.setFirstname("1234");
		user.setLastname("1234");
		user.setPhone("1234");
		
		openSession.save(user);
		
		openSession.close();
		sessionFactory.close();
	}
}
