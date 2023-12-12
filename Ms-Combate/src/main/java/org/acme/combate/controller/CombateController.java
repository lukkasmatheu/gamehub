package org.acme.combate.controller;

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
import org.acme.combate.models.CombateEntity;
import org.acme.combate.models.JogadorEntity;
import org.acme.combate.service.CombateService;
import org.bson.types.ObjectId;

@Path("/combate")
public class CombateController {

    @Inject
    CombateService service;


    @GET
    @Path("/{id}")
    public CombateEntity get(String id) {
        return CombateEntity.findById(new ObjectId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CombateEntity combate(JogadorEntity jogador1, JogadorEntity jogador2 ) {
        return service.combate(jogador1,jogador2);
    }

    @PUT
    @Path("/{id}")
    public void update(String id, CombateEntity person) {
        person.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        CombateEntity person = CombateEntity.findById(new ObjectId(id));
        if(person == null) {
            throw new NotFoundException();
        }
        person.delete();
    }
}