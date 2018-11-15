package dao;

import java.util.List;

import entity.Table_Hall;


public interface HallDao {
	/**
	 * 添加影厅
	 * @param order
	 * @return
	 */
	public int addHall(Table_Hall hall);
	/**
	 * 根据传入的id删除指定的影厅
	 * 
	 * @param lid 传入的要删除的影厅id
	 * @return 返回sql语句操作的行数
	 */
	public int deleteHall(int hid);

	/**
	 * 根据传入的id修改指定的影厅信息
	 * 
	 * @param level 传入修改对象
	 * @param lid   传入要修改的影厅id
	 * @return 返回sql语句操作的行数
	 */
	public int updateHall(Table_Hall hall, int hid);

	/**
	 * 查找所有影厅
	 * 
	 * @return 返回查找的影厅对象集合
	 */
	public List<Table_Hall> findAll();

	/**
	 * 根据传入的影厅id查找对应的影厅对象
	 * 
	 * @param lid 传入要查找的id
	 * @return 返回查找到的影厅对象
	 */
	public Table_Hall getHallById(int hid);

	/**
	 * 模糊查询
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_Hall> getHallLikeByColumn(String column, Object value);
}
