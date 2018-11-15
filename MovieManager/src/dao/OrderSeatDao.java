package dao;

import java.util.List;


import entity.Table_OrderSeat;

public interface OrderSeatDao {
	/**
	 * ��Ӷ�����λ
	 * @param orderSeat
	 * @return
	 */
	public int addOrderSeat(Table_OrderSeat orderSeat);
	/**
	 * ���ݴ����idɾ��ָ���Ķ�����λ
	 * 
	 * @param lid �����Ҫɾ���Ķ�����λid
	 * @return ����sql������������
	 */
	public int deleteOrder(int oid);

	/**
	 * ���ݴ����id�޸�ָ���Ķ�����λ��Ϣ
	 * 
	 * @param level �����޸Ķ���
	 * @param lid   ����Ҫ�޸ĵĶ���id
	 * @return ����sql������������
	 */
	public int updateOrder(Table_OrderSeat orderSeat, int oid);

	/**
	 * �������ж���
	 * 
	 * @return ���ز��ҵĶ�����λ���󼯺�
	 */
	public List<Table_OrderSeat> findAll();

	/**
	 * ���ݴ���Ķ���id���Ҷ�Ӧ�Ķ�����λ����
	 * 
	 * @param lid ����Ҫ���ҵ�id
	 * @return ���ز��ҵ��Ķ�����λ����
	 */
	public List<Table_OrderSeat> getOrderById(int oid);

	/**
	 * ģ����ѯ
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_OrderSeat> getOrderSeatLikeByColumn(String column, Object value);
	/**
	 * ���ݿͻ���Ų�ѯ����
	 * @param cid ����Ҫ��Ѱ�Ŀͻ����
	 * @return
	 */
	public List<Table_OrderSeat> getOrderByCustomer(int cid);
}
