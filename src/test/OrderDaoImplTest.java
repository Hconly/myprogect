package test;

import dao.OrderDao;
import dao.Impl.OrderDaoImpl;
import entity.Table_Order;
import junit.framework.TestCase;

public class OrderDaoImplTest extends TestCase {
	OrderDao od;
	protected void setUp() throws Exception {
		od=new OrderDaoImpl();
		super.setUp();
	}

	public void testAddOrder() {
		
		Table_Order to=new Table_Order();
		to.setCid(1001);
		to.setSid(0505);
		to.setBuydate("2018-0-10-01");
		System.out.println(od.addOrder(to));
	}

	public void testDeleteOrder() {
		fail("Not yet implemented");
	}

	public void testUpdateOrder() {
		fail("Not yet implemented");
	}

	public void testFindAll() {
		fail("Not yet implemented");
	}

	public void testGetOrderById() {
		fail("Not yet implemented");
	}

	public void testGetOrderLikeByColumn() {
		fail("Not yet implemented");
	}

	public void testGetOrderByCustomer() {
		fail("Not yet implemented");
	}

}
