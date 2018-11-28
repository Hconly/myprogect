package test.entity;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Emp {
	
	private int empNo;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int dno;
	
}
