package test.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dept {
	private int deptNo;
	private String dname;
	private String loc;
}
