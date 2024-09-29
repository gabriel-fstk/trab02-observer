import main.java.com.leilao.models.Leiloeiro;
import main.java.com.leilao.models.Licitante;

public class Main {
    public static void main(String[] args) {
       
        Leiloeiro leiloeiro = new Leiloeiro();

        Licitante licitante1 = new Licitante("Joao");
        Licitante licitante2 = new Licitante("Maria");
        Licitante licitante3 = new Licitante("Carlos");

        leiloeiro.addObserver(licitante1);
        leiloeiro.addObserver(licitante2);
        leiloeiro.addObserver(licitante3);

        leiloeiro.receberLance(licitante1, 1000);
        leiloeiro.receberLance(licitante2, 1500);
        leiloeiro.receberLance(licitante3, 2000);
        
        leiloeiro.anunciarVencedor();
    }
}
