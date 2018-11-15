package dao;

import java.util.List;

import entity.Table_Hall;


public interface HallDao {
	/**
	 * ���Ӱ��
	 * @param order
	 * @return
	 */
	public int addHall(Table_Hall hall);
	/**
	 * ���ݴ����idɾ��ָ����Ӱ��
	 * 
	 * @param lid �����Ҫɾ����Ӱ��id
	 * @return ����sql������������
	 */
	public int deleteHall(int hid);

	/**
	 * ���ݴ����id�޸�ָ����Ӱ����Ϣ
	 * 
	 * @param level �����޸Ķ���
	 * @param lid   ����Ҫ�޸ĵ�Ӱ��id
	 * @return ����sql������������
	 */
	public int updateHall(Table_Hall hall, int hid);

	/**
	 * ��������Ӱ��
	 * 
	 * @return ���ز��ҵ�Ӱ�����󼯺�
	 */
	public List<Table_Hall> findAll();

	/**
	 * ���ݴ����Ӱ��id���Ҷ�Ӧ��Ӱ������
	 * 
	 * @param lid ����Ҫ���ҵ�id
	 * @return ���ز��ҵ���Ӱ������
	 */
	public Table_Hall getHallById(int hid);

	/**
	 * ģ����ѯ
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Table_Hall> getHallLikeByColumn(String column, Object value);
}
