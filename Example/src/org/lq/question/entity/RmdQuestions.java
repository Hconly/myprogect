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
 * ѡ����
 * @author Administrator
 *
 */
public class RmdQuestions {
	private Integer id;//���
	private String question;//���
	private String correct;//��
	private Integer quest_type; //�������
	private int quest_ctgr;//֪ʶ������
	private String descrpt;//����
}
