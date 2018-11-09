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
 * ¿Î³ÌÄ¿Â¼
 * @author Administrator
 *
 */
public class OlstCatagory {
	private int  id;
	private String  content;
	private int  pid;
	private OlstCatagory parent;

}
