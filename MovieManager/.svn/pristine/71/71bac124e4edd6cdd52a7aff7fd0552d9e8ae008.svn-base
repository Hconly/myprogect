package dao;

import java.util.List;

import entity.Table_Schedule;

public interface ScheduleDao {
	/**
	 * 添加安排影片信息
	 * @param order
	 * @return
	 */
	public int addSchedual(Table_Schedule shedule);
	/**
	 * 根据传入的id删除指定的安排影片信息
	 * 
	 * @param lid 传入的要删除的安排影片信息id
	 * @return 返回sql语句操作的行数
	 */
	public int deleteSchedule(int sid);

	/**
	 * 根据传入的id修改指定的安排影片信息
	 * 
	 * @param level 传入修改对象
	 * @param lid   传入要修改的安排影片信息id
	 * @return 返回sql语句操作的行数
	 */
	public int updateSchedule(Table_Schedule schedule);

	/**
	 * 查找所有安排影片信息
	 * 
	 * @return 返回查找的安排影片信息对象集合
	 */
	public List<Table_Schedule> findAll();

	/**
	 * 根据传入的影厅id查找对应的安排影片信息
	 * 
	 * @param lid 传入要查找的id
	 * @return 返回查找到的安排影片信息
	 */
	public Table_Schedule getScheduleById(int sid);

	/**
	 * 模糊查询
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_Schedule> getScheduleLikeByColumn(String column, Object value);
	
	public Table_Schedule getByMid(int mid);

	

	public List<Table_Schedule> getListMid(int mid);

	Table_Schedule getByTid(int tid);
	
}