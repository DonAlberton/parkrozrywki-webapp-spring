package com.parkrozrywki.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class Transakcje {
    private Integer id_atrakcji;
    private Integer id_klienta;

    private String nazwa_atrakcji;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    public Transakcje() {

    }

    public Transakcje(Integer id_klienta, Integer id_atrakcji, String nazwa_atrakcji, Date data) {
        this.id_atrakcji = id_atrakcji;
        this.data = data;
        this.nazwa_atrakcji = nazwa_atrakcji;
        this.id_klienta = id_klienta;
    }

    public Integer getId_atrakcji() {
        return id_atrakcji;
    }

    public void setId_atrakcji(Integer id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public Integer getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Integer id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getNazwa_atrakcji() {
        return nazwa_atrakcji;
    }

    public void setNazwa_atrakcji(String nazwa_atrakcji) {
        this.nazwa_atrakcji = nazwa_atrakcji;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Transakcje{" +
                "id_atrakcji=" + id_atrakcji +
                ", id_klienta=" + id_klienta +
                ", nazwa_atrakcji='" + nazwa_atrakcji + '\'' +
                ", data=" + data +
                '}';
    }

}
