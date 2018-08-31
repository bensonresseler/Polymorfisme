package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Dier> dieren = new ArrayList<>();
        dieren.add(new Hond("Bello"));
        dieren.add(new Kat("Minou"));
        //dieren.add(new Dier("animal"));
        for (Dier d : dieren) {
            System.out.printf("Ik heet %s en ik %s%n", d.getNaam(), d.getGeluid());
        }
    }
}

abstract class Dier {
    public abstract String getNaam();
    public abstract String getGeluid();
}

class Hond extends Dier{
    private String naam;
    private String geluid = "blaf";

    public Hond(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getGeluid() {
        return geluid;
    }
}

class Kat extends Dier{
    private String naam;
    private String geluid = "miauw";

    public Kat(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getGeluid() {
        return geluid;
    }
}