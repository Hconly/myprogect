package service;

import java.util.List;

import entity.Table_Movie;
import entity.dto.MovieDto;


public interface MovieService {
	

	// 添加
	boolean addMovie(Table_Movie m);

	// 删除
	boolean deleteMovie(int id);

	// 修改
	boolean updateMovie(Table_Movie m);

	// 查询全部
	List<MovieDto> findAll();

	// 根据id查询
	List<MovieDto> getById(int tid);

	// 模糊查询

	List<MovieDto> findByShowName(String name, String value);
	public List<Table_Movie> findAAll() ;
	public List<Table_Movie> findMovieByName(String name);
	public List<Table_Movie> findMovieByType(int tid);
	public Table_Movie getbyId(int mid);
	public Table_Movie getbyName(String name);
	public List<Table_Movie> findMovieByHot(int hot);
}
