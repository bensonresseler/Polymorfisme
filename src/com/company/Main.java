package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws BankRekeningException {
        Scanner scanner = new Scanner(System.in);
        Map<String, BankRekening> rekeningen = new HashMap<>();
        rekeningen.put("000-0000011-11", new BankRekening("000-0000011-11"));
        rekeningen.put("000-0000022-22", new PositieveBankRekening("000-0000022-22"));
        System.out.println("De rekeningen:");
        for(String rek:rekeningen.keySet()){
            System.out.println( rek);
        }
        System.out.print("Welke rekening: ");
        String r = scanner.nextLine();
        BankRekening rekening = rekeningen.get(r);
        System.out.print("Wilt u 1) storten 2)afhalen? ");
        String antwoord = scanner.nextLine();
        System.out.print("Welk bedrag? ");
        int bedrag = Integer.parseInt(scanner.nextLine());
        if (antwoord.equals("1")){
            rekening.storten(bedrag);
        }else if (antwoord.equals("2")){
            rekening.afhalen(bedrag);
        }
        for(BankRekening rek: rekeningen.values()){
            System.out.printf("%s: %d EURO%n", rek.getRekeningnummer(), rek.getSaldo());
        }
    }
}

class BankRekeningException extends Exception {
    public BankRekeningException(String message) {
        super(message);
    }
}


class BankRekening {
    private String rekeningnummer;
    private int saldo = 0;

    public BankRekening(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void storten(int bedrag) {
        saldo += bedrag;
    }

    public void afhalen(int bedrag) throws BankRekeningException {
        saldo -= bedrag;
    }
}

class PositieveBankRekening extends BankRekening {
    private int saldo = 0;

    public PositieveBankRekening(String rekeningnummer) {
        super(rekeningnummer);
    }

    @Override
    public void afhalen(int bedrag) throws BankRekeningException {
        if (bedrag > saldo) throw new BankRekeningException("Het saldo mag niet negatief worden.");
        else saldo -= bedrag;
    }
}
