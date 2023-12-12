package org.acme.gamehub.orquestrador.models;

public class Ataque {
    
    public float areaQuadrada;
    public int dano ;
    public int custoEnergia ;
    public int custoEstamina;
    public int custoVida; // Se habilidate consome vida ao ser executada (randomico)


    // Requisitos de pontos para realização de ataque
    public int agilidade;
    public int forca;

    public Ataque(){
        this.areaQuadrada = (float) (Math.random() * 1574);
        this.dano = (int) ((Math.random() + 1 )* 16500);
        this.custoEnergia = (int) (Math.random() * 7532);
        this.custoEstamina = (int) (Math.random() * 15451);
        this.custoVida = (int) (Math.random() * (Math.random() > 0.5 ? 2000 : 0)); // Se habilidate consome vida ao ser executada (randomico)
        this.forca = (int) (Math.random() * 1500);
        this.agilidade = (int) (Math.random() * 3000);
    }
}
