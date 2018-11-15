package entity.dto;

import entity.Table_Movie;
import entity.Table_MovieType;
import entity.Table_Schedule;
/**
 * 电影拓展类
 * @author Administrator
 *
 */
public class MovieDto {
	private Table_Movie movie;//电影类
	private Table_MovieType movietype;//电影类型类
	private Table_Schedule schedule;//排片类

	public Table_MovieType getMovietype() {
		return movietype;
	}

	public void setMovietype(Table_MovieType movietype) {
		this.movietype = movietype;
	}

	public Table_Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Table_Schedule schedule) {
		this.schedule = schedule;
	}

	public Table_Movie getMovie() {
		return movie;
	}

	public void setMovie(Table_Movie movie) {
		this.movie = movie;
	}

}
