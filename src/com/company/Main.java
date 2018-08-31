package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Lijn> lijnen = new ArrayList<>();
        lijnen.add(new VerticaleLijn(2));
        lijnen.add(new HorizontaleLijn(5));
        lijnen.add(new HorizontaleLijn(3));
        for (Lijn lijn : lijnen) {
            System.out.println("De lijn: ");
            lijn.teken();
        }
    }
}

abstract class Lijn {
    public abstract void teken();
}

class HorizontaleLijn extends Lijn {
    private int aantalLijnen;

    public HorizontaleLijn(int aantalLijnen) {
        super();
        this.aantalLijnen = aantalLijnen;
    }
    public void teken(){
        String tekenLijn = "";

        for (int i = 0;i < aantalLijnen;i++){
              tekenLijn = tekenLijn + '*';
            }
        System.out.printf(tekenLijn + "%n");
    }

}

class VerticaleLijn extends Lijn {
    private int aantalLijnen;

    public VerticaleLijn(int aantalLijnen) {
        super();
        this.aantalLijnen = aantalLijnen;
    }

    public void teken(){
        String tekenLijn = "";
        for (int i = 0;i < aantalLijnen;i++){
            tekenLijn = tekenLijn + "*\n";
        }
        System.out.printf(tekenLijn);
    }
}