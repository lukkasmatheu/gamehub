package org.acme.jogador;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.jogador.models.JogadorEntity;
import org.bson.types.ObjectId;

import java.net.URI;

@Path("/jogador")
public class JogadorController {

    @Inject
    JogadorService service;


    @GET
    @Path("/{id}")
    public JogadorEntity get(String id) {
        return JogadorEntity.findById(new ObjectId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(JogadorEntity person) {
        person.persist();
        return Response.created(URI.create("/persons/" + person.id)).build();
    }

    @PUT
    @Path("/{id}")
    public void update(String id, JogadorEntity person) {
        person.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        JogadorEntity person = JogadorEntity.findById(new ObjectId(id));
        if(person == null) {
            throw new NotFoundException();
        }
        person.delete();
    }

    @GET
    @Path("/search/{name}")
    public JogadorEntity search(String name) {
        return JogadorEntity.findByName(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return JogadorEntity.count();
    }

}