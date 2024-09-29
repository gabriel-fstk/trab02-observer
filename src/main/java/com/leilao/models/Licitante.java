package main.java.com.leilao.models;

import main.java.com.leilao.interfaces.Observer;

public class Licitante implements Observer {
    private String nome;
    private double ofertaAtual;

    public Licitante(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(double novaOferta) {
        this.ofertaAtual = novaOferta;
        System.out.println("Licitante " + nome + " foi notificado da nova oferta: R$ " + ofertaAtual);
    }
}
