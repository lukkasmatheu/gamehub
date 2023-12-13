package org.acme.gamehub.orquestrador.controller;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.acme.gamehub.orquestrador.models.Combate;
import org.acme.gamehub.orquestrador.models.Jogador;
import org.acme.gamehub.orquestrador.service.OrquestadorService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/orquestrador")
public class OrquestradorController {

    @Inject
    @RestClient
    OrquestadorService orquestadorService;

    @POST
    @Path("/criar/Jogador")
    public Jogador criarJogador(Jogador jogador) {
        return orquestadorService.createPlayer(jogador);
    }

    @POST
    @Path("/combate")
    public Combate criarJogador(String idJogadorOne,String idJogadortwo ) {
        return orquestadorService.combate(idJogadorOne,idJogadortwo);
    }

}
