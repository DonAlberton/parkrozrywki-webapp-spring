package com.parkrozrywki.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.thymeleaf.util.ListUtils.size;

class TransakcjeDAOTest {

    @Autowired
    private TransakcjeDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB03");
        datasource.setPassword("BDBTGRB03");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new TransakcjeDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList(){
        List<Transakcje> listaKlientow = dao.list("Alberto");

        System.out.println(listaKlientow);

    }


    @Test
    void list() {
    }


    @Test
    void delete() {
    }
}