package org.acme.gamehub.orquestrador.clients;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

import org.acme.gamehub.orquestrador.RequestUUIDHeaderFactory;
import org.acme.gamehub.orquestrador.models.Combate;
import org.acme.gamehub.orquestrador.models.Jogador;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/jogador")
@RegisterRestClient
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface CombateClient {

    @GET
    @Path("/{id}")
    public Combate get(String id);

    @POST
    public Combate combate(Jogador jogador1, Jogador jogador2 );

    @PUT
    @Path("/{id}")
    public void update(String id, Combate person);

    @DELETE
    @Path("/{id}")
    public void delete(String id);
}
