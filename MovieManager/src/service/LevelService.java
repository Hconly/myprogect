package service;

import java.util.List;

import entity.Table_Level;

public interface LevelService {
	/**
	 * 添加会员级别
	 * @param level 传入会员级别对象
	 * @return 如果返回true则表示添加成功
	 */
	public boolean addLevel(Table_Level level);
	/**
	 * 根据传入的id删除指定的会员级别
	 * @param lid 传入的要删除的会员级别id
	 * @return 如果返回true则表示删除成功
	 */
	public boolean deleteLevel(int lid);
	/**
	 * 根据传入的id修改指定的会员级别信息
	 * @param level 传入修改对象
	 * @param lid 传入要修改的会员级别id
	 * @return 如果返回true则表示修改成功
	 */
	public boolean updateLevel(Table_Level level,int lid);
	/**
	 * 查找所有会员级别
	 * @return 返回查找的会员级别对象集合
	 */
	public List<Table_Level> findAll();
	/**
	 * 根据传入的会员级别id查找对应的会员级别对象
	 * @param lid 传入要查找的id
	 * @return 返回查找到的会员级别对象
	 */
	public Table_Level getLevelById(int lid);
	/**
	 * 模糊查询
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_Level> getLevelLikeByColumn(String column,Object value); 
}
