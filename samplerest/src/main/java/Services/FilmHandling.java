package Services;


import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Comments;
import domain.Film;
import domain.Rating;

public class FilmHandling {
	
	private static List<Film> base = new ArrayList<Film>();
	private static int currentId = -1;
	
	
	
	public List<Film> getAll() {
		return base;
	}
	
	
	public Film getById(int id) {
		for (Film film : base) {
			if (film.getId() == id) {
				return film;
			}
		}
		return null;
	}
	
	
	
	public void add (Film film) {
		film.setId(++currentId);
		base.add(film);
	}
	
	
	
	public void update (Film film) {
		for (Film m : base) {
			if (m.getId() == film.getId()) {
				m.setTitle(film.getTitle());
				m.setYear(film.getYear());
			}
		}
	}
	
	
	public void delete (Film film) {
		base.remove(film);
	}
	
	
	public void addComment (Film film, Comments comment) {
		comment.setId(film.getComments().size());
		film.getComments().add(comment);
	}
	
	public void deleteComment (Film film, int commentId) {
		base.get(film.getId()).getComments().remove(commentId);
	}
	
	
	
	public void addRating(Film film, Rating rating) {
		rating.setId(film.getRatings().size());
		film.getRatings().add(rating);
		
		double sum = 0;
		for (Rating r: film.getRatings()) {
			sum = sum + r.getRating();
		}

		double filmRating = sum/film.getRatings().size();

		film.setFilmRating(filmRating);
	}
	
	public List<Actor> addActor(int filmId) {
		FilmHandling base = new FilmHandling();
		List<Actor> actorsInAFilm = new ArrayList<Actor>();
		List<Actor> actorsbase = new ActorHandling().getAll();
		
		
		
		for (Film film : base.getAll()) {
			if (film.getId() == filmId) {
				for (Integer actorId : film.getActors()) {
					for (Actor actor : actorsbase) {
						if (actor.getId() == actorId) {
							actorsInAFilm.add(actor);
						}
					}
				}
			}
		}
		
		return actorsInAFilm;
	}
}