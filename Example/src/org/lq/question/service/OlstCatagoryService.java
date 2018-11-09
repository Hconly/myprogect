package org.lq.question.service;

import java.util.List;

import org.lq.question.entity.OlstCatagory;

public interface OlstCatagoryService {
	
	boolean saveCatagory(OlstCatagory catagory);
	
	boolean updateCatagory(OlstCatagory catagory);
	
	boolean deleteCatagoryById(int id);

	List<OlstCatagory> findAll();
	
	List<OlstCatagory> LikeAll(String txt);
	
	OlstCatagory getCatagoryById(int id);
	
	List<OlstCatagory> getParentCatagory();
	
	List<OlstCatagory> getCatagoryInParent();
	
	
}
