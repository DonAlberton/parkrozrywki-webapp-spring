package com.parkrozrywki.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Atrakcje {
    private Integer id_atrakcji;
    private String nazwa_atrakcji;
    private Integer cena_atrakcji;
    private String stan_atrakcji;
    private Integer minimalny_wzrost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_otwarcia;
    private Integer wysokosc;
    private Integer czas_trwania;

    private String wodna;

    private Integer id_parku;
    public Atrakcje(Integer id_atrakcji, String nazwa_atrakcji, Integer cena_atrakcji, String stan_atrakcji, Integer minimalny_wzrost, Date data_otwarcia, Integer wysokosc, Integer czas_trwania, String wodna, Integer id_parku) {
        this.id_atrakcji = id_atrakcji;
        this.nazwa_atrakcji = nazwa_atrakcji;
        this.cena_atrakcji = cena_atrakcji;
        this.stan_atrakcji = stan_atrakcji;
        this.minimalny_wzrost = minimalny_wzrost;
        this.data_otwarcia = data_otwarcia;
        this.wysokosc = wysokosc;
        this.czas_trwania = czas_trwania;
        this.wodna = wodna;
        this.id_parku = id_parku;
    }

    public Atrakcje(){}

    public Integer getId_atrakcji() {
        return id_atrakcji;
    }

    public void setId_atrakcji(Integer id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public String getNazwa_atrakcji() {
        return nazwa_atrakcji;
    }

    public void setNazwa_atrakcji(String nazwa_atrakcji) {
        this.nazwa_atrakcji = nazwa_atrakcji;
    }

    public Integer getCena_atrakcji() {
        return cena_atrakcji;
    }

    public void setCena_atrakcji(Integer cena_atrakcji) {
        this.cena_atrakcji = cena_atrakcji;
    }

    public String getStan_atrakcji() {
        return stan_atrakcji;
    }

    public void setStan_atrakcji(String stan_atrakcji) {
        this.stan_atrakcji = stan_atrakcji;
    }

    public Integer getMinimalny_wzrost() {
        return minimalny_wzrost;
    }

    public void setMinimalny_wzrost(Integer minimalny_wzrost) {
        this.minimalny_wzrost = minimalny_wzrost;
    }

    public Date getData_otwarcia() {
        return data_otwarcia;
    }

    public void setData_otwarcia(Date data_otwarcia) {
        this.data_otwarcia = data_otwarcia;
    }

    public Integer getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Integer wysokosc) {
        this.wysokosc = wysokosc;
    }

    public Integer getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(Integer czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public String getWodna() {
        return wodna;
    }

    public void setWodna(String wodna) {
        this.wodna = wodna;
    }

    public Integer getId_parku() {
        return id_parku;
    }

    public void setId_parku(Integer id_parku) {
        this.id_parku = id_parku;
    }

    @Override
    public String toString() {
        return "Atrakcje{" +
                "id_atrakcji=" + id_atrakcji +
                ", nazwa_atrakcji='" + nazwa_atrakcji + '\'' +
                ", cena_atrakcji=" + cena_atrakcji +
                ", stan_atrakcji='" + stan_atrakcji + '\'' +
                ", minimalny_wzrost=" + minimalny_wzrost +
                ", data_otwarcia=" + data_otwarcia +
                ", wysokosc=" + wysokosc +
                ", czas_trwania=" + czas_trwania +
                ", wodna='" + wodna + '\'' +
                ", id_parku=" + id_parku +
                '}';
    }
}
