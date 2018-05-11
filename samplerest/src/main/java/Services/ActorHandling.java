package Services;


import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Film;

public class ActorHandling {
	
	private static List<Actor> base = new ArrayList<Actor>();
	private static int currentId = -1;
	
	public List<Actor> getAll() {
		return base;
	}
	
	public Actor getById(int id) {
		for (Actor actor : base) {
			if (actor.getId() == id) {
				return actor;
			}
		}
		return null;
	}
	
	public void add (Actor actor) {
		actor.setId(++currentId);
		base.add(actor);
	}
	
	public void update (Actor actor) {
		for (Actor a : base) {
			if (a.getId() == actor.getId()) {
				a.setName(actor.getName());
				a.setSurname(actor.getSurname());
			}
		}
	}
	
	public void delete (Actor actor) {
		base.remove(actor);
	}
	
	public void addFilm (Actor actor, Film film) {
		
		FilmHandling baseFilms = new FilmHandling();
		
		for (Film m : baseFilms.getAll()) {
			if (m.getId() == film.getId()) {
				actor.getFilms().add(m);

				if (m.getActors() == null) {
					m.setActors(new ArrayList<Integer>());
				}
				
				m.getActors().add(actor.getId());
			}
		}
	}
}