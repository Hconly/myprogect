package org.lq.dao;

import java.util.List;

import org.lq.entity.Emp;

public interface EmpDao {
    int deleteByPrimaryKey(int empno);

    int insert(Emp record);

    Emp selectByPrimaryKey(int empno);

    int updateByPrimaryKey(Emp record);
    
    
    List<Emp> findPage(int pageIndex,int pageSize,String ename);
    
    int getCount(String ename);
    
}