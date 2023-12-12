package org.acme.gamehub.orquestrador.service;

import org.acme.gamehub.orquestrador.clients.CombateClient;
import org.acme.gamehub.orquestrador.clients.JogadorClient;
import org.acme.gamehub.orquestrador.models.Combate;
import org.acme.gamehub.orquestrador.models.Jogador;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrquestadorService {
    @Inject
    JogadorClient jogadorClient;
    @Inject
    CombateClient combateClient;

    public Jogador createPlayer(Jogador jogador) {
        return jogadorClient.create(jogador);
    }

    public Combate combate(String idJogadorOne, String idJogadortwo) {
        Jogador jogador1 = jogadorClient.getuser(idJogadorOne);
        Jogador jogador2 = jogadorClient.getuser(idJogadortwo);
        return combateClient.combate(jogador1, jogador2);
    }
    
}
