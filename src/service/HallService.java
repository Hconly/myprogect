package service;

import java.util.List;

import entity.Table_Hall;

public interface HallService {
	public boolean addHall(Table_Hall hall);
	public boolean deleteHall(int hid);
	public boolean update(Table_Hall hall,int hid);
	public List<Table_Hall> findAll();
	public Table_Hall getHallById(int hid);
	

}
