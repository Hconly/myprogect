package org.lq.power.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo {
    private Integer role_id;

    private String role_name;

    private String role_desc;

    private String role_state="1";

    
}