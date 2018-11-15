package dao;

import java.util.List;


import entity.Table_OrderSeat;

public interface OrderSeatDao {
	/**
	 * 添加订单座位
	 * @param orderSeat
	 * @return
	 */
	public int addOrderSeat(Table_OrderSeat orderSeat);
	/**
	 * 根据传入的id删除指定的订单座位
	 * 
	 * @param lid 传入的要删除的订单座位id
	 * @return 返回sql语句操作的行数
	 */
	public int deleteOrder(int oid);

	/**
	 * 根据传入的id修改指定的订单座位信息
	 * 
	 * @param level 传入修改对象
	 * @param lid   传入要修改的订单id
	 * @return 返回sql语句操作的行数
	 */
	public int updateOrder(Table_OrderSeat orderSeat, int oid);

	/**
	 * 查找所有订单
	 * 
	 * @return 返回查找的订单座位对象集合
	 */
	public List<Table_OrderSeat> findAll();

	/**
	 * 根据传入的订单id查找对应的订单座位对象
	 * 
	 * @param lid 传入要查找的id
	 * @return 返回查找到的订单座位对象
	 */
	public List<Table_OrderSeat> getOrderById(int oid);

	/**
	 * 模糊查询
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_OrderSeat> getOrderSeatLikeByColumn(String column, Object value);
	/**
	 * 根据客户编号查询订单
	 * @param cid 传入要查寻的客户编号
	 * @return
	 */
	public List<Table_OrderSeat> getOrderByCustomer(int cid);
}
