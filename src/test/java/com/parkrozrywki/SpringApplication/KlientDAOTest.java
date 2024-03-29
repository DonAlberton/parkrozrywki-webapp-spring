package com.parkrozrywki.SpringApplication;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.thymeleaf.util.ListUtils.size;

class KlientDAOTest {
    @Autowired
    private KlientDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB03");
        datasource.setPassword("BDBTGRB03");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlientDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        List<Klient> listaKlientow = dao.list();

        for (Klient klient: listaKlientow){
            System.out.println(klient);
        }

        System.out.println(listaKlientow);
        System.out.println(size(listaKlientow));
        System.out.println(listaKlientow.isEmpty());
        assertFalse(listaKlientow.isEmpty());
    }


    @Test
    void list() {
    }

    @Test
    void save() {
        Klient klient = new Klient(12, "Don", "Alberton", "000000000", "Donalberto@gmail.com", 1);
        dao.save(klient);
    }

    @Test
    void get() {
        int id = 7;
        Klient klient = dao.get(id);
        assertNotNull(klient);
    }

    @Test
    void update() {
        Integer id = 7;
        Klient klient = new Klient();
        klient.setId_klienta(1);
        klient.setNumer_telefonu("000000000");
        dao.update(klient);
    }

    @Test
    void delete() {
    }
}