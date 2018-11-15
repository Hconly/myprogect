package service.Impl;

import java.util.List;

import dao.MovieTypeDao;
import dao.Impl.MovieTypeDaoImpl;
import entity.Table_Movie;
import entity.Table_MovieType;
import service.MovietypeService;

public class MovietypeServiceImpl implements MovietypeService {
	MovieTypeDao mdao = new MovieTypeDaoImpl();

	@Override
	public boolean addMovieType(Table_MovieType m) {

		return mdao.addMovieType(m) > 0;
	}

	@Override
	public boolean deleteMovieType(int id) {
		if (id > 0) {
			return mdao.deleteMovie(id) > 0;
		} else {
			System.out.println("输入的ID不存在！");
			return false;
		}
	}

	@Override
	public boolean updateMovieType(Table_MovieType m) {

		return mdao.updateMovieType(m) > 0;
	}

	@Override
	public List<Table_MovieType> findAll() {
		List<Table_MovieType> list = mdao.findAll();
		return list;
	}
	
	@Override
	public Table_MovieType getById(int id) {

		return mdao.getById(id);
	}
	

}
