package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import dao.MovieTypeDao;
import dao.ScheduleDao;
import dao.Impl.MovieDaoImpl;
import dao.Impl.MovieTypeDaoImpl;
import dao.Impl.ScheduleDaoImpl;
import entity.Table_Movie;
import entity.Table_MovieType;
import entity.Table_Schedule;
import entity.dto.MovieDto;
import service.MovieService;
import service.ScheduleService;

public class MovieServiceImpl implements MovieService {
	MovieDao mdao = new MovieDaoImpl();
	ScheduleDao sdao=new ScheduleDaoImpl();
	@Override
	public boolean addMovie(Table_Movie m) {

		return mdao.addMovie(m)>0;
	}

	@Override
	public boolean deleteMovie(int id) {

		return mdao.deleteMovie(id)>0;
	}

	@Override
	public boolean updateMovie(Table_Movie m) {
		
		return mdao.updateMovie(m)>0;
	}

	@Override
	public List<MovieDto> findAll() {
		List<MovieDto> listdto =new ArrayList<>();
		List<Table_Movie> list=mdao.findAll();
		
		for (Table_Movie table_Movie : list) {
			MovieDto md=new MovieDto();
			md.setMovie(table_Movie);
			
			MovieTypeDao mtdao=new MovieTypeDaoImpl();
			Table_MovieType movieType=mtdao.getById(table_Movie.getTid());
			md.setMovietype(movieType);
			
			listdto.add(md);
		}
		return listdto;
	}
	public List<Table_Movie> findAAll() {
		return mdao.findAAll();
	}
	
	

	

	
	@Override
	public List<MovieDto> findByShowName(String name, String value) {
		List<MovieDto> listdto =new ArrayList<>();
		List<Table_Movie> list=mdao.likeByColumn(name, value);
		for (Table_Movie table_Movie : list) {
			MovieDto md=new MovieDto();
			md.setMovie(table_Movie);
			MovieTypeDao mtdao=new MovieTypeDaoImpl();
			Table_MovieType movieType=mtdao.getById(table_Movie.getTid());
			md.setMovietype(movieType);
			listdto.add(md);
		}
		return listdto;
	}

	@Override
	public List<MovieDto> getById(int tid) {
		List<MovieDto> listdto =new ArrayList<>();
		List<Table_Movie> list=mdao.getById(tid);
		MovieDto md;
		for (Table_Movie table_Movie : list) {
			 md=new MovieDto();
			md.setMovie(table_Movie);
			MovieTypeDao mtdao=new MovieTypeDaoImpl();
			Table_MovieType movieType=mtdao.getById(table_Movie.getTid());
			md.setMovietype(movieType);
			ScheduleService ss=new ScheduleServiceImpl();
			Table_Schedule ts=ss.getByMid(table_Movie.getMid());
			md.setSchedule(ts);
			
			
			listdto.add(md);
		}
		return listdto;
	}
	
	public List<Table_Movie> findMovieByName(String name) {
		return mdao.findMovieByName(name);
	}

	public List<Table_Movie> findMovieByType(int tid) {
		return mdao.findMovieByType(tid);
	}
	public Table_Movie getbyId(int mid) {
		return mdao.getbyId(mid);
		
		
		
	}

	@Override
	public Table_Movie getbyName(String name) {
		
		return mdao.getbyName(name);
	}

	@Override
	public List<Table_Movie> findMovieByHot(int hot) {
		return mdao.findMovieByHot(hot);
	}
	
	
	

}
