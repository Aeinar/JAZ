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

import Services.ActorHandling;
import domain.Actor;
import domain.Film;


@Path("/actors")
public class RestActor {
	
	private ActorHandling base = new ActorHandling();
	
	//pobieranie
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getAll() {
		return base.getAll();
	}
	
	//dodawanie aktorzyn
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Actor actor) {
		base.add(actor);
		return Response.ok(actor.getId()).build();
	}
	
	
	//pobieranie danych o aktorze o okreslonym id
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Actor result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	
	//edycja
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Actor actor) {
		Actor result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		actor.setId(id);
		base.update(actor);
		return Response.ok().build();
	}
	
	
	//kasowanie
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Actor result = base.getById(id);
		if (result == null) {
			return Response.status(404).build();
		}
		base.delete(result);
		return Response.ok().build();
	}
	
	//listowanie filmów okreœlonego aktora
	
	
	@GET
	@Path("/{actorId}/films")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> getComments(@PathParam("actorId") int actorId) {
		Actor result = base.getById(actorId);
		if (result == null) {
			return null;
		}
		if (result.getFilms() == null) {
			result.setFilms(new ArrayList<Film>());
		}
		return result.getFilms();
	}
	
	//dodawanie filmu do danego aktora o okreslonym id
	
	@POST
	@Path("/{id}/films")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFilm(@PathParam("id") int actorId, Film film) {
		Actor result = base.getById(actorId);
		if (result == null) {
			return Response.status(404).build();
		}
		if (result.getFilms() == null) {
			result.setFilms(new ArrayList<Film>());
		}
		
		base.addFilm(result, film);
		return Response.ok().build();
	}
}