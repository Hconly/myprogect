package org.lq.power.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnthortyInfo {
    private Integer anthorty_id;

    private Integer anthorty_pid;

    private String anthorty_name;

    private String anthorty_desc;

    private String anthorty_url;
    
    private AnthortyInfo parent;//���ڵ����
    
    private List<AnthortyInfo> childs=new ArrayList<>();//�����ӽڵ�
    
    private boolean checked=false; //��ǰȨ���Ƿ�ѡ��

   
}