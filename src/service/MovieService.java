package service;

import java.util.List;

import entity.Table_Movie;
import entity.dto.MovieDto;


public interface MovieService {
	

	// ���
	boolean addMovie(Table_Movie m);

	// ɾ��
	boolean deleteMovie(int id);

	// �޸�
	boolean updateMovie(Table_Movie m);

	// ��ѯȫ��
	List<MovieDto> findAll();

	// ����id��ѯ
	List<MovieDto> getById(int tid);

	// ģ����ѯ

	List<MovieDto> findByShowName(String name, String value);
	public List<Table_Movie> findAAll() ;
	public List<Table_Movie> findMovieByName(String name);
	public List<Table_Movie> findMovieByType(int tid);
	public Table_Movie getbyId(int mid);
	public Table_Movie getbyName(String name);
	public List<Table_Movie> findMovieByHot(int hot);
}
