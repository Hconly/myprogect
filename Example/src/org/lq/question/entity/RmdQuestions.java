package org.lq.question.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 选项题
 * @author Administrator
 *
 */
public class RmdQuestions {
	private Integer id;//编号
	private String question;//题干
	private String correct;//答案
	private Integer quest_type; //题干类型
	private int quest_ctgr;//知识点类型
	private String descrpt;//描述
}
