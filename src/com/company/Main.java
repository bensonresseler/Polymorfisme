package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Persoon> personen = new HashSet<>();
        personen.add(new Persoon("Karen", LocalDate.of(1974, 10, 28)));
        personen.add(new Persoon("Kristel", LocalDate.of(1975, 12, 10)));
        personen.add(new Persoon("Kathleen", LocalDate.of(1978, 6, 18)));
        personen.add(new Leeftijdleugenaar("Josje", LocalDate.of(1986, 2, 16)));
        for (Persoon p : personen) {
            System.out.printf("%s is %d jaar oud.%n", p.getNaam(), p.getLeeftijd());
        }
    }
}

    class Persoon {
        private String naam;
        private LocalDate geboortedatum;

        public Persoon(String naam, LocalDate geboortedatum) {
            this.naam = naam;
            this.geboortedatum = geboortedatum;
        }

        public String getNaam() {
            return naam;
        }

        public int getLeeftijd() {
            LocalDate vandaag = LocalDate.now();
            Period periode = Period.between(geboortedatum, vandaag);
            return periode.getYears();
        }
    }

    class Leeftijdleugenaar extends Persoon {
        public Leeftijdleugenaar(String naam, LocalDate geboortedatum) {
            super(naam, geboortedatum);
        }

        @Override
        public int getLeeftijd() {
            return super.getLeeftijd() + 10;
        }
    }
