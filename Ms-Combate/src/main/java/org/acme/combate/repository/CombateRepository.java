package org.acme.combate.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import org.acme.combate.models.CombateEntity;

@ApplicationScoped
public class CombateRepository implements PanacheMongoRepository<CombateEntity> {

    public CombateEntity findByName(String name){
        return find("name", name).firstResult();
    }
}