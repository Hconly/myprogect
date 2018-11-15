package dao;

import java.util.List;

import entity.Table_Customer;

public interface CustomerDao {
	/**
	 * 添加客户
	 * 
	 * @param customer 传入客户对象
	 * @return 返回sql语句操作的行数
	 */
	public int addCustomer(Table_Customer customer);

	/**
	 * 通过传入的id删除指定的客户信息
	 * 
	 * @param cid 传入要删除的客户id
	 * @return 返回sql语句操作的行数
	 */
	public int deleteCustomer(int cid);

	/**
	 * 根据传入的客户id修改指定客户的信息
	 * 
	 * @param customer 传入修改的信息
	 * @param cid      指定修改的客户id
	 * @return 返回sql语句操作的行数
	 */
	public int updateCustomer(Table_Customer customer);

	/**
	 * 根据传入的客户code修改指定客户的信息
	 * 
	 * @param customer
	 * @param ccode
	 * @return
	 */
	public int updateCustomer1(Table_Customer customer);

	/**
	 * 查询所有客户
	 * 
	 * @return 返回查询到的客户对象集合
	 */
	public List<Table_Customer> findAll();

	/**
	 * 根据传入的客户id查询客户信息
	 * 
	 * @param cid 传入要查询的客户id
	 * @return 返回查询到的客户对象
	 */
	public Table_Customer getCustomerById(int cid);

	/**
	 * 模糊查询
	 * 
	 * @param column 传入模糊查询的条件
	 * @param value  传入模糊查询的值
	 * @return 返回查询到的客户对象集合
	 */
	public List<Table_Customer> getCustomerLikeByColumn(String column, Object value);
	
	
	/**
	 * 获取客户ID的最大值，以确定最新注册的客户
	 */
	public Table_Customer getCustomerByMaxId();
	
	/**
	 * 根据用户名查找用户
	 */
	public Table_Customer getCustomerByCname(String cname);
	/**
	 * 根据会员卡号查找用户
	 */
	public Table_Customer getCustomerByCcode(String ccode);
}
