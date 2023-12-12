package org.acme.combate.service;

import org.acme.combate.models.Ataque;
import org.acme.combate.models.CombateEntity;
import org.acme.combate.models.JogadorEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CombateService {

    public CombateEntity combate(JogadorEntity jogador1, JogadorEntity jogador2) {
        CombateEntity combate = new CombateEntity();
        Ataque novoAtaque = new Ataque();
        if(validaAtributos(jogador1,novoAtaque)){
            jogador2.vida -= novoAtaque.dano;
            if(jogador2.vida <= 0){
                jogador2.vida = 0;
                combate.alive = false; 
            }
            combate.jogador1 = jogador1;
            combate.jogador2 = jogador2;
            combate.ataque = novoAtaque;
        }
        return combate;
    }

    private boolean validaAtributos(JogadorEntity jogador, Ataque novoAtaque) {
        if(jogador.agilidade < novoAtaque.agilidade){
            return false;
        }
        if(jogador.forca < novoAtaque.forca){
            return false;
        }
        if(jogador.energia > novoAtaque.custoEnergia){
            jogador.energia -= novoAtaque.custoEnergia;
        }
        if(jogador.estamina > novoAtaque.custoEstamina){
            jogador.estamina -= novoAtaque.custoEstamina;
        }
        if(jogador.vida > novoAtaque.custoVida){
            jogador.vida -= novoAtaque.custoVida;
        }
        return true;
    }

}
