package com.jgdy3.produkt;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Rachunek {
    @Getter
    private List<Produkt> produktList;

    public void dodajProdukt(Produkt produkt) {
        produktList.add(produkt);
    }

    public void wypiszRachunek() {
        System.out.println("Rachunek: ");
        for (Produkt produkt : produktList) {
            System.out.println(produkt.getNazwa() + " -> " + produkt.podajCeneBrutto());
        }
    }

    public double podsumujRachunekNetto() {
        return produktList.stream()
                .mapToDouble(Produkt::getCena)
                .sum();
    }

    public double podsumujRachunekBrutto() {
        return produktList.stream()
                .mapToDouble(Produkt::podajCeneBrutto)
                .sum();
    }

    public double podsumujRachunekNettoPetla() {
        double suma = 0.0;

        for (Produkt produkt : produktList) {
            suma += produkt.getCena();
        }

        return suma;
    }

    public double zwrocWartośćPodatku() {
        return podsumujRachunekBrutto() - podsumujRachunekNetto();
    }


    public void zwrocRoznicePodatku() {
        double suma8 = 0.0;
        double suma23 = 0.0;

        for (Produkt produkt : produktList) {
            suma8 += (produkt.getCena() + produkt.getCena() * 0.08);
            suma23 += (produkt.getCena() + produkt.getCena() * 0.23);
        }

        System.out.println("Wartość rachunku dla 23% podatku: " + suma23);
        System.out.println("Wartość rachunku dla 8% podatku: " + suma8);
    }

    public List<Produkt> zwrocProduktyZVatem8(){
        return produktList.stream()
                .filter(produkt -> produkt.getPodatek() == PodatekProduktu.VAT8)
                .collect(Collectors.toList());
    }
}
