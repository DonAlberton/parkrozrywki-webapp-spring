package com.parkrozrywki.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtrakcjeDAOTest {

    @Autowired
    private AtrakcjeDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB03");
        datasource.setPassword("BDBTGRB03");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AtrakcjeDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Atrakcje> listaAtrakcji = dao.list();
        System.out.println(listaAtrakcji.size());

        for (Atrakcje atrakcja: listaAtrakcji){
            System.out.println(atrakcja);
        }
    }

    @Test
    void save() {
        //LocalDate date = new LocalDate();
        Date date = new Date();
        //Atrakcje atrakcja = new Atrakcje(8, "Teges Szmeges", 20, "Dzialajacy", 100, date, 200, 90, "0", 1);

        //dao.save(atrakcja);
    }

    @Test
    void get() {
    }

    @Test
    void update() {
        Atrakcje atrakcja = new Atrakcje();
        atrakcja.setId_atrakcji(7);
        atrakcja.setStan_atrakcji("Nie dzialajacy");
        atrakcja.setCena_atrakcji(75);

        dao.update(atrakcja);
    }

    @Test
    void delete() {
    }
}