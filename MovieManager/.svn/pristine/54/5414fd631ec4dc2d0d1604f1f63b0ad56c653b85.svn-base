package dao;

import java.util.List;

import entity.Table_Movie;

public interface MovieDao {

	// 添加
	public int  addMovie(Table_Movie movie);

	// 删除
	int deleteMovie(int id);

	// 修改
	public int updateMovie(Table_Movie movie);

	// 查询全部
	List<Table_Movie> findAll();

	// 根据id查询
	List<Table_Movie> getById(int tid);
	
	// 模糊查询
	public List<Table_Movie> findAAll() ;

	List<Table_Movie> likeByColumn(String columnName, Object value);
	public List<Table_Movie> findMovieByType(int tid);
	public List<Table_Movie> findMovieByName(String name);
	public Table_Movie getbyId(int mid);
	public Table_Movie getbyName(String name);

	public List<Table_Movie> findMovieByHot(int hot);

	
	
	
}
