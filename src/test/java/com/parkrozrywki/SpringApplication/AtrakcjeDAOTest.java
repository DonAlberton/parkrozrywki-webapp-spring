package com.parkrozrywki.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

        for (Atrakcje atrakcja: listaAtrakcji){
            System.out.println(atrakcja);
        }
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}