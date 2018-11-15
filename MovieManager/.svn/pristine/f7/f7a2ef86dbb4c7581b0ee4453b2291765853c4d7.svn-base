package service.Impl;

import java.util.List;

import dao.ScheduleDao;
import dao.Impl.ScheduleDaoImpl;
import entity.Table_Schedule;
import service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {
	ScheduleDao sd=new ScheduleDaoImpl();
	
	public Table_Schedule getByMid(int mid) {
		
		return sd.getByMid(mid);
	}

	@Override
	public List<Table_Schedule> FindAll() {
		List<Table_Schedule> list=sd.findAll();
		return list;
	}

	@Override
	public boolean addschule(Table_Schedule schedule) {
		
		return sd.addSchedual(schedule)>0;
	}

	@Override
	public boolean deleteschule(int sid) {
		
		return sd.deleteSchedule(sid)>0;
	}

	@Override
	public boolean updateschule(Table_Schedule schedule) {
		
		return sd.updateSchedule(schedule)>0;
	}

	@Override
	public List<Table_Schedule> getmid(int mid) {
		List<Table_Schedule> list=sd.getScheduleLikeByColumn("mid", mid);
		return list;
	}
	
	public List<Table_Schedule> getmid1(int mid) {
		return sd.getListMid(mid);
	}
	
	@Override
	public Table_Schedule getScheduleBySid(int sid) {
		return sd.getScheduleById(sid);
	}

}
