package service.Impl;

import java.util.List;

import dao.LevelDao;
import dao.Impl.LevelDaoImpl;
import entity.Table_Level;
import service.LevelService;

public class LevelServiceImpl implements LevelService{
	LevelDao levelDao=new LevelDaoImpl();
	@Override
	public boolean addLevel(Table_Level level) {
		return levelDao.addLevel(level)>0;
	}

	@Override
	public boolean deleteLevel(int lid) {
		return levelDao.deleteLevel(lid)>0;
	}

	@Override
	public boolean updateLevel(Table_Level level, int lid) {
		return levelDao.updateLevel(level, lid)>0;
	}

	@Override
	public List<Table_Level> findAll() {
		return levelDao.findAll();
	}

	@Override
	public Table_Level getLevelById(int lid) {
		return levelDao.getLevelById(lid);
	}

	@Override
	public List<Table_Level> getLevelLikeByColumn(String column, Object value) {
		return levelDao.getLevelLikeByColumn(column, value);
	}

}
