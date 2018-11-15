package service.Impl;

import java.sql.ResultSet;
import java.util.List;

import dao.CustomerDao;
import dao.Impl.CustomerDaoImpl;
import entity.Table_Customer;
import service.CustomerService;
import util.DBUtil;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean addCustomer(Table_Customer customer) {
		return customerDao.addCustomer(customer) > 0;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		return customerDao.deleteCustomer(cid) > 0;
	}

	@Override
	public boolean updateCustomer(Table_Customer customer) {
		return customerDao.updateCustomer(customer) > 0;
	}

	@Override
	public List<Table_Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Table_Customer getCustomerById(int cid) {
		return customerDao.getCustomerById(cid);
	}

	@Override
	public List<Table_Customer> getCustomerLikeByColumn(String column, Object value) {
		return customerDao.getCustomerLikeByColumn(column, value);
	}

	@Override
	public boolean updateCustomer1(Table_Customer customer) {

		return customerDao.updateCustomer1(customer) > 0;
	}

	@Override
	public Table_Customer getCustomerByMaxId() {
		return customerDao.getCustomerByMaxId();
	}

	@Override
	public Table_Customer getCustomerByCname(String cname) {
		return customerDao.getCustomerByCname(cname);
	}

	@Override
	public Table_Customer getCustomerByCcode(String ccode) {
		return customerDao.getCustomerByCcode(ccode);

	}

	

}
