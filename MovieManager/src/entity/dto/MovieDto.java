package entity.dto;

import entity.Table_Movie;
import entity.Table_MovieType;
import entity.Table_Schedule;
/**
 * ��Ӱ��չ��
 * @author Administrator
 *
 */
public class MovieDto {
	private Table_Movie movie;//��Ӱ��
	private Table_MovieType movietype;//��Ӱ������
	private Table_Schedule schedule;//��Ƭ��

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
