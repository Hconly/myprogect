package service;

import java.util.List;

import entity.Table_MovieType;


public interface MovietypeService {
	// 添加
	boolean addMovieType(Table_MovieType m);

	// 删除
	boolean deleteMovieType(int id);

	// 修改
	boolean updateMovieType(Table_MovieType m);

	// 查询全部
	List<Table_MovieType> findAll();

	// 根据id查询
	Table_MovieType getById(int id);

}
