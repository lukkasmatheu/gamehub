package org.acme.jogador.models;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="jogador")
public class JogadorEntity extends PanacheMongoEntity {
    public ObjectId id;
    public String nome;
    public int forca;
    public int agilidade;
    public int vida;
    public int energia;
    public int estamina;


    public static JogadorEntity findByName(String name){
        return find("name", name).firstResult();
    }
}



