package org.lq.power.entity;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfo {
    private Integer staffId;

    private Integer roleId;

    private String staffName;

    private String staffSex;

    private Integer staffAge;

    private String staffNativePlace;

    private String staffIdcard;

    private Date staffBrithday;

    private String staffOfficePhone;

    private String staffMobilePhone;

    private String staffEamil;

    private String staffAddr;

    private String staffQq;

    private Date staffEntryTime;

    private String staffEductionLevel;

    private String staffRemark;

    private String staffState;

    private String userNumber;

    private String userPassowrd;

  
}