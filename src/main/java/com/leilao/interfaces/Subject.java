package main.java.com.leilao.interfaces;

import main.java.com.leilao.models.Licitante;

public interface Subject {
    void addObserver(Licitante licitante);
    void removeObserver(Licitante licitante);
    void notifyObservers();
}

