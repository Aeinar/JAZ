package rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Actor;
import domain.Comments;
import domain.Film;
import domain.Rating;
import Services.FilmHandling;

@Path("/films")
public class RestFilm {
	
	private FilmHandling base = new FilmHandling();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> getAll() {
		return base.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Film film) {
		base.add(film);
		return Response.ok(film.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Film result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Film film) {
		Film result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		film.setId(id);
		base.update(film);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Film result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		base.delete(result);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{filmId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comments> getComments(@PathParam("filmId") int filmId) {
		Film result = base.getById(filmId);
		if (result == null) {
			return null;
		}
		if (result.getComments() == null) {
			result.setComments(new ArrayList<Comments>());
		}
		return result.getComments();
	}
	
	
	@POST
	@Path("/{id}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") int filmId, Comments comment) {
		Film result = base.getById(filmId);
		if (result == null) {
			return Response.status(404).build();
		}
		if (result.getComments() == null) {
			result.setComments(new ArrayList<Comments>());
		}
		
		base.addComment(result, comment);

		return Response.ok().build();
	}
	
	
	
	@DELETE
	@Path("/{id}/comments/{commentId}")
	public Response deleteComment(@PathParam("id") int filmId, @PathParam("commentId") int commentId) {
		Film result = base.getById(filmId);
		if (result == null) {
			return Response.status(404).build();
		}
		base.deleteComment(result, commentId);
		return Response.ok().build();
	}
	
	
	
	
	@GET
	@Path("/{filmId}/ratings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> getRatings(@PathParam("filmId") int filmId) {
		Film result = base.getById(filmId);
		if (result == null) {
			return null;
		}
		if (result.getRatings() == null) {
			result.setRatings(new ArrayList<Rating>());
		}
		return result.getRatings();
	}
	
	@POST
	@Path("/{id}/ratings")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRatings(@PathParam("id") int filmId, Rating rating) {
		Film result = base.getById(filmId);
		if (result == null) {
			return Response.status(404).build();
		}
		if (result.getRatings() == null) {
			result.setRatings(new ArrayList<Rating>());
		}
		base.addRating(result, rating);
		return Response.ok().build();
	}
	
	//wyœwietlenie aktorów danego filmu
	
	@GET
	@Path("/{filmId}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActors(@PathParam("filmId") int filmId) {
		Film result = base.getById(filmId);
		if (result == null) {
			return null;
		}
		
		return base.addActor(filmId);
	}
}