package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Figuur[] figuren = new Figuur[4];
        for (int i = 0; i < 2; i++) {
            System.out.print("Geef zijde van vierkant: ");
            int zijde = Integer.parseInt(scanner.nextLine());
            figuren[i] = new Vierkant(zijde);
        }
        for (int i = 2; i < figuren.length; i++) {
            System.out.print("Geef straal van cirkel: ");
            int straal = Integer.parseInt(scanner.nextLine());
            figuren[i] = new Cirkel(straal);
        }
        Arrays.sort(figuren);
        for (Figuur f : figuren) {
            System.out.printf("Een %s met oppervlakte %.2f%n", f, f.getOppervlakte());
        }
    }
}

abstract class Figuur implements Comparable<Figuur>{
    public abstract double getOppervlakte();


    @Override
    public int compareTo(Figuur o){
        return Double.compare(this.getOppervlakte(), o.getOppervlakte());
    }

}


class Vierkant extends Figuur implements Comparable<Figuur>{
    private int zijde;

    public Vierkant(int zijde) {
        this.zijde = zijde;
    }

    public double getOppervlakte() {
        return zijde * zijde;
    }

    @Override
    public String toString() {
        return "Vierkant";
    }
}


class Cirkel extends Figuur implements Comparable<Figuur>{
    private int straal;
    private double oppervlakte;

    public Cirkel(int straal) {
        this.straal = straal;
    }

    public double getOppervlakte() {
        oppervlakte = straal*straal*Math.PI;
        return oppervlakte;
    }
    @Override
    public String toString() {
        return "Cirkel";
    }
}