package service.Impl;

import dao.SeatDao;
import dao.Impl.SeatDaoImpl;
import entity.Table_Seat;
import service.SeatService;

public class SeatServiceImpl implements SeatService{
	SeatDao seatDao=new SeatDaoImpl();
	
	@Override
	public Table_Seat getSeatBySid(int sid) {
		return seatDao.getSeatById(sid);
	}

	@Override
	public boolean updateSeatState(int id,int hid,int seat_id) {
		
		return seatDao.updateSeat(id,hid,seat_id)>0;
	}

}
