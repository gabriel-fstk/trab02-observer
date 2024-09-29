package main.java.com.leilao.models;

import main.java.com.leilao.interfaces.Subject;
import java.util.ArrayList;
import java.util.List;

public class Leiloeiro implements Subject {
    private List<Licitante> licitantes;
    private double ofertaAtual;
    private Licitante licitanteAtual;

    public Leiloeiro() {
        this.licitantes = new ArrayList<>();
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

    public void receberLance(Licitante licitante, double valor) {
        if (valor > this.ofertaAtual) {
            this.ofertaAtual = valor;
            this.licitanteAtual = licitante; // Armazena o licitante atual
            System.out.println("Novo lance de " + licitante.getNome() + ": " + valor);
            notifyObservers();
        } else {
            System.out.println("Lance menor ou igual ao atual. Desconsiderado.");
        }
    }

    public void anunciarVencedor() {
        if (licitanteAtual != null) {
            System.out.println("Vencedor: " + licitanteAtual.getNome() + " com o lance de " + ofertaAtual);
        } else {
            System.out.println("Nenhum vencedor.");
        }
    }
}
