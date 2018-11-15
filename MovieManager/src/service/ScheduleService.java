package service;

import java.util.List;

import entity.Table_Schedule;

public interface ScheduleService {
	/**
	 * ���ݵ�Ӱ��Ų�ѯ
	 * 
	 * @param mid
	 * @return
	 */
	public Table_Schedule getByMid(int mid);

	/**
	 * ���ݵ�Ӱ��Ų�ѯ,������Ƭ����
	 * @param mid
	 * @return
	 */
	public List<Table_Schedule> getmid(int mid);
	
	
	
	public List<Table_Schedule> getmid1(int mid);

	/**
	 * ��ѯ���е�Ӱ��Ƭ
	 */
	public List<Table_Schedule> FindAll();

	/**
	 * ��Ƭ���
	 */
	public boolean addschule(Table_Schedule schedule);

	/**
	 * ɾ��
	 * 
	 * @param sid��ƬID
	 * @return
	 */
	public boolean deleteschule(int sid);

	/**
	 * �޸�
	 * 
	 * @param sid
	 * @return
	 */
	public boolean updateschule(Table_Schedule schedule);
	public Table_Schedule getScheduleBySid(int sid);

}
