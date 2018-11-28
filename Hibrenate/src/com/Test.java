package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import java.util.List;

public class Test {

    @org.junit.Test
    public void save(){
        Session session = HibernateUtil.openSession();
        /**
         * sessionFactory 负责初始化hibernate 创建session对象
         */
        User user = new User();
        user.setFirst("First");
        user.setLast("last");
        user.setPhone("phone");
        user.setEmail("Email");

        session.save(user);
        session.close();
    }

    @org.junit.Test
    public void query(){
        //HQL方式查询 查询所有  对象鱼类的该校你
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from com.User");
        List<User> list = query.list();

        System.out.println(list.toString());
        transaction.commit();
    }

    @org.junit.Test
    public void delete(){

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setId(3);
        session.delete(user);

        transaction.commit();
    }

    @org.junit.Test
    public void getOne(){
        //查询一条记录get
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1);
        System.out.println(user);


        transaction.commit();


        //先查询再更新   只会更新修改的字段 不然会将其他没有更新的记录设置为null


        //直接创建对象不支持级联删除

        //查询之后再删除的对象支持级联删除

        //SaveOrUpdate()如果没有设置id是保存 相当于插入一条新数据
        //如果设置id是更新
    }
}
