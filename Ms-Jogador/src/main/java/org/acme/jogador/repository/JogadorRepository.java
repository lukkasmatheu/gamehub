package org.acme.jogador.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.jogador.models.JogadorEntity;

import static io.quarkus.mongodb.panache.PanacheMongoEntityBase.find;

@ApplicationScoped
public class JogadorRepository implements PanacheMongoRepository<JogadorEntity> {

    public JogadorEntity findByName(String name){
        return find("name", name).firstResult();
    }
}