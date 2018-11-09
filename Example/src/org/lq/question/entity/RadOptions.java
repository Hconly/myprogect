package org.lq.question.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RadOptions {
	private Integer id;	//Ö÷¼ü
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private String option_E;
	private Integer rad_id;	//Ìâ¸É±àºÅ
}
