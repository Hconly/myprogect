package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory;
    static {
        //加载配置文件
        Configuration configure = new Configuration().configure();
        //创建sessionFactory    连接池
        sessionFactory = configure.buildSessionFactory();
    }
    //给外界提供一个方法获取连接工厂
    public static Session  openSession(){
        return sessionFactory.openSession();
    }
}
