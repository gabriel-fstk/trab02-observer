package main.java.com.leilao.models;

import main.java.com.leilao.interfaces.Subject;
import java.util.ArrayList;
import java.util.List;

public class Leiloeiro implements Subject {
    private List<Licitante> licitantes;
    private float ofertaAtual;

    public Leiloeiro() {
        this.licitantes = new ArrayList<>();
    }

    public void novaOferta(float oferta) {
        this.ofertaAtual = oferta;
        notifyObservers();
    }

    @Override
    public void addObserver(Licitante licitante) {
        licitantes.add(licitante);
    }

    @Override
    public void removeObserver(Licitante licitante) {
        licitantes.remove(licitante);
    }

    @Override
    public void notifyObservers() {
        for (Licitante licitante : licitantes) {
            licitante.update(ofertaAtual);
        }
    }
}
