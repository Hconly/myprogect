package org.lq.question.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CspQuestions {
	private Integer id;
	private String question;
	private String std_answer;
	private Integer quest_type;
	private int quest_ctgr;
	private String descrpt;
}
