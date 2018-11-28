package org.lq.dao;

import java.util.List;

import org.lq.entity.Dept;

public interface DeptDao {
    int insert(Dept record);
   
    int update(Dept dept);
    
    int delete(int id);
    
    Dept getDept(int id);
    /**
     * ��ҳ��ѯ
     * @param pageIndex ��ǰҳ��
     * @param pageSize ÿҳ��ʾ������
     * @param dname ��ѯ��������
     * @return
     */
    List<Dept> findAll(int pageIndex,int pageSize,String dname);
    
    /**
     * ���ݲ������Ʋ�ѯ����
     * @param dname
     * @return
     */
    int getCount(String dname);
    
    
}