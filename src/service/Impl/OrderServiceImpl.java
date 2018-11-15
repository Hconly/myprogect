package service.Impl;

import java.util.List;

import dao.OrderDao;
import dao.Impl.OrderDaoImpl;
import entity.Table_Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao=new OrderDaoImpl();
	@Override
	public boolean addOrder(Table_Order order) {
		return orderDao.addOrder(order)>0;
	}

	@Override
	public boolean deleteOrder(int oid) {
		return orderDao.deleteOrder(oid)>0;
	}

	@Override
	public boolean updateOrder(Table_Order order) {
		return orderDao.updateOrder(order)>0;
	}

	@Override
	public List<Table_Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Table_Order getOrderById(int oid) {
		return orderDao.getOrderById(oid);
	}

	@Override
	public List<Table_Order> getOrderByCid(int cid) {
		return orderDao.getOrderLikeByColumn("cid", cid);
	}

}
