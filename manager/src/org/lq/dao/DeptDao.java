package org.lq.dao;

import java.util.List;

import org.lq.entity.Dept;

public interface DeptDao {
    int insert(Dept record);
   
    int update(Dept dept);
    
    int delete(int id);
    
    Dept getDept(int id);
    /**
     * 分页查询
     * @param pageIndex 当前页数
     * @param pageSize 每页显示的行数
     * @param dname 查询部门名称
     * @return
     */
    List<Dept> findAll(int pageIndex,int pageSize,String dname);
    
    /**
     * 根据部门名称查询数量
     * @param dname
     * @return
     */
    int getCount(String dname);
    
    
}