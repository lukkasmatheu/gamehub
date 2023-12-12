package org.acme.combate.models;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="combate")
public class CombateEntity extends PanacheMongoEntity {
    public JogadorEntity jogador1;
    public JogadorEntity jogador2;
    public Ataque ataque;
    public boolean alive;

    public static CombateEntity findByName(String name){
        return find("name", name).firstResult();
    }
}



