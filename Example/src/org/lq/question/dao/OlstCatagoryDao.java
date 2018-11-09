package org.lq.question.dao;

import org.lq.question.entity.OlstCatagory;

public interface OlstCatagoryDao extends BaseDao<OlstCatagory> {

	int getChildCount(int id);

}
