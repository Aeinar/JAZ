package domain;

import java.util.List;

public class Film {
	
	private int id;
	private String title;
	private String year;
	private double filmRating;
	private List<Comments> comments;
	private List<Rating> ratings;
	private List<Integer> actors;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public double getFilmRating() {
		return filmRating;
	}
	public void setFilmRating(double filmRating) {
		this.filmRating = filmRating;
	}
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Integer> getActors() {
		return actors;
	}
	public void setActors(List<Integer> actors) {
		this.actors = actors;
	}
}