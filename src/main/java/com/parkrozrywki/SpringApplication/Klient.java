package com.parkrozrywki.SpringApplication;

public class Klient {
    private int id_klienta;
    private String imie;
    private String nazwisko;
    private String numer_telefonu;
    private String email;
    private int id_adresu;

    public Klient(int id_klienta, String imie, String nazwisko, String numer_telefonu, String email, int id_adresu) {
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer_telefonu = numer_telefonu;
        this.email = email;
        this.id_adresu = id_adresu;
    }
    public Klient(){}

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
