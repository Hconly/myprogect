package dao;

import java.util.List;

import entity.Table_MovieType;

public interface MovieTypeDao {
	// 添加
	public int addMovieType(Table_MovieType m);

	// 删除
	int deleteMovie(int id);

	// 修改
	public int updateMovieType(Table_MovieType m);

	// 查询全部
	List<Table_MovieType> findAll();

	// 根据id查询
	Table_MovieType getById(int id);

	// 模糊查询

	List<Table_MovieType> likeByColumn(String columnName, Object value);

	
}
