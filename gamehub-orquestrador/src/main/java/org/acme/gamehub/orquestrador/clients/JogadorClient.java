package org.acme.gamehub.orquestrador.clients;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

import org.acme.gamehub.orquestrador.RequestUUIDHeaderFactory;
import org.acme.gamehub.orquestrador.models.Jogador;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/extensions")
@RegisterRestClient
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface JogadorClient {

   
    @GET
    @Path("/{id}")
    public Jogador getuser(String id);

    @POST
    public Jogador create(Jogador person);
    
    @PUT
    @Path("/{id}")
    public void update(String id, Jogador person);

    @DELETE
    @Path("/{id}")
    public void delete(String id);

    @GET
    @Path("/search/{name}")
    public Jogador search(String name);

    @GET
    @Path("/count")
    public Long count();
}
