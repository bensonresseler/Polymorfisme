package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Werknemer> werknemers = new ArrayList<>();
        int urengewerkt = 168;
        int uurloon = 17;
        Arbeider joske = new Arbeider("Joske", urengewerkt, uurloon);
        werknemers.add(joske);
        Arbeider lewieke = new Arbeider("Lewieke", urengewerkt, uurloon);
        werknemers.add(lewieke);
        lewieke.setUrenGewerkt(172);
        int maandloon = 3500;
        Bediende marieke = new Bediende("Marieke", maandloon);
        werknemers.add(marieke);
        Bediende sky = new Bediende("Sky", maandloon);
        werknemers.add(sky);
        sky.setMaandloon(3000);
        for(Werknemer w: werknemers){
            System.out.printf("%s verdient %d EURO%n", w.getNaam(), w.getLoon());
        }
        int totaalloon = getMaandloon(werknemers);
        System.out.println("Het totale loon bedraagt " + totaalloon);

    }

    private static int getMaandloon(List<Werknemer> werknemers) {
        int totaal = 0;
        for (Werknemer n: werknemers){
            int loon = n.getLoon();
            totaal += loon;
        } return totaal;
    }

}

abstract class Werknemer {
    private String naam;

    public Werknemer(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public abstract int getLoon();

}

class Arbeider extends Werknemer {
    private int urengewerkt;
    private int uurloon;


    public Arbeider(String naam, int urengewerkt, int uurloon) {
        super(naam);
        this.urengewerkt = urengewerkt;
        this.uurloon = uurloon;
    }


    @Override
    public int getLoon() {
        return urengewerkt*uurloon;
    }


    public void setUrenGewerkt(int uren) {
        this.urengewerkt = uren;
    }
}

class Bediende extends Werknemer {
    private int maandloon;
    private int urengewerkt;

    public Bediende(String naam, int maandloon) {
        super(naam);
        this.maandloon = maandloon;
    }

    public void setMaandloon(int maandloon) {
        this.maandloon = maandloon;
    }

    @Override
    public int getLoon() {
        return maandloon;
    }

}