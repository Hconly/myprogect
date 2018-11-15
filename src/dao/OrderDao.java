package dao;

import java.util.List;

import entity.Table_Level;
import entity.Table_Order;

/**
 * 订单业务层接口
 * @author Administrator
 *
 */
public interface OrderDao {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public int addOrder(Table_Order order);
	/**
	 * 根据传入的id删除指定的订单
	 * 
	 * @param lid 传入的要删除的订单id
	 * @return 返回sql语句操作的行数
	 */
	public int deleteOrder(int oid);

	/**
	 * 根据传入的id修改指定的订单信息
	 * 
	 * @param level 传入修改对象
	 * @param lid   传入要修改的订单id
	 * @return 返回sql语句操作的行数
	 */
	public int updateOrder(Table_Order order);

	/**
	 * 查找所有订单
	 * 
	 * @return 返回查找的订单对象集合
	 */
	public List<Table_Order> findAll();

	/**
	 * 根据传入的订单id查找对应的订单对象
	 * 
	 * @param lid 传入要查找的id
	 * @return 返回查找到的订单对象
	 */
	public Table_Order getOrderById(int oid);

	/**
	 * 模糊查询
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_Order> getOrderLikeByColumn(String column, Object value);
	/**
	 * 根据客户编号查询订单
	 * @param cid 传入要查寻的客户编号
	 * @return
	 */
	public List<Table_Order> getOrderByCustomer(int cid);

	
	
}
