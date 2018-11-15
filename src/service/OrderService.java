package service;

import java.util.List;

import entity.Table_Order;

public interface OrderService {
	public boolean addOrder(Table_Order order);
	public boolean deleteOrder(int oid);
	public boolean updateOrder(Table_Order order);
	public List<Table_Order> findAll();
	public Table_Order getOrderById(int oid);
	public List<Table_Order> getOrderByCid(int cid);
}
