package com.jgdy3.produkt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produkt {
    private String nazwa;
    private double cena;
    private PodatekProduktu podatek;

    public double podajCeneBrutto() {
        return cena + (podatek.getPodatek() * cena);
    }

}
