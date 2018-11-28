package xxc.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	
		private int empno;
		private String ename;
		private String job;
		private int mgr;
		private Date hiredate;
		private double sal;
		private double comm;
		private int deptno;		
		
}
