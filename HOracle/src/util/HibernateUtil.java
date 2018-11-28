package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory;
    static {
        
        Configuration configure = new Configuration().configure();
        
        sessionFactory = configure.buildSessionFactory();
    }
    //����һ�����ӹ���
    public static Session openSession(){
        return sessionFactory.openSession();
    }
}
