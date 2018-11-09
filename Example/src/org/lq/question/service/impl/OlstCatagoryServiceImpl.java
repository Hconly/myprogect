package org.lq.question.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lq.question.dao.OlstCatagoryDao;
import org.lq.question.dao.impl.OlstCatagoryDaoImpl;
import org.lq.question.entity.OlstCatagory;
import org.lq.question.service.OlstCatagoryService;

import lombok.extern.log4j.Log4j;

@Log4j
public class OlstCatagoryServiceImpl implements OlstCatagoryService {
	
	private OlstCatagoryDao catagoryDao = new OlstCatagoryDaoImpl();

	@Override
	public boolean saveCatagory(OlstCatagory catagory) {
		log.info("添加课程类型:["+catagory+"]");
		return catagoryDao.save(catagory)>0;
	}

	@Override
	public boolean updateCatagory(OlstCatagory catagory) {
		log.info("修改课程类型:["+catagory+"]");
		return catagoryDao.update(catagory)>0;
	}

	@Override
	public boolean deleteCatagoryById(int id) {
		int count = catagoryDao.getChildCount(id);
		int num = 0;
		if(count==0) {
			num =catagoryDao.delete(id);
		}else {
			num = -1;
		}
		log.info("删除课程类型:["+id+"]");
		return num>0;
	}

	@Override
	public List<OlstCatagory> findAll() {
		log.info("查询全部课程信息!");
		return catagoryDao.findAll();
	}

	@Override
	public List<OlstCatagory> LikeAll(String txt) {
		log.info("模糊查询课程类型:[%"+txt+"%]");
		return catagoryDao.likeAll(txt);
	}

	@Override
	public OlstCatagory getCatagoryById(int id) {
		log.info("根据编号查询课程信息:["+id+"]");
		return catagoryDao.findById(id);
	}

	@Override
	public List<OlstCatagory> getParentCatagory() {
		List<OlstCatagory> listAll = findAll();
		List<OlstCatagory> parentList = new ArrayList();
		for (OlstCatagory olstCatagory : listAll) {
			if(olstCatagory.getPid()==0) {
				parentList.add(olstCatagory);
			}
		}
		
		return parentList;
	}

	@Override
	public List<OlstCatagory> getCatagoryInParent() {
		List<OlstCatagory> childs = findAll();
		
		List<OlstCatagory> parentList = getParentCatagory();
		for (OlstCatagory parent : parentList) {
			for (OlstCatagory child : childs) {
				if(child.getPid() == parent.getId()) {
					child.setParent(parent);
				}
			}
		}
		return childs;
	}

}





