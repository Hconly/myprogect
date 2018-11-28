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
    
    private AnthortyInfo parent;//父节点对象
    
    private List<AnthortyInfo> childs=new ArrayList<>();//所有子节点
    
    private boolean checked=false; //当前权限是否被选择

   
}