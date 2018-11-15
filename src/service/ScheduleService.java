package service;

import java.util.List;

import entity.Table_Schedule;

public interface ScheduleService {
	/**
	 * 根据电影编号查询
	 * 
	 * @param mid
	 * @return
	 */
	public Table_Schedule getByMid(int mid);

	/**
	 * 根据电影编号查询,返回排片集合
	 * @param mid
	 * @return
	 */
	public List<Table_Schedule> getmid(int mid);
	
	
	
	public List<Table_Schedule> getmid1(int mid);

	/**
	 * 查询所有电影排片
	 */
	public List<Table_Schedule> FindAll();

	/**
	 * 排片添加
	 */
	public boolean addschule(Table_Schedule schedule);

	/**
	 * 删除
	 * 
	 * @param sid排片ID
	 * @return
	 */
	public boolean deleteschule(int sid);

	/**
	 * 修改
	 * 
	 * @param sid
	 * @return
	 */
	public boolean updateschule(Table_Schedule schedule);
	public Table_Schedule getScheduleBySid(int sid);

}
