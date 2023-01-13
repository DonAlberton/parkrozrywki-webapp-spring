package com.parkrozrywki.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class KlientDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        //super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Klient> list(){
        String sql = "SELECT * FROM klienci";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient sale) {
    }

    /* Read – odczytywanie danych z bazy */
    public Klient get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klient klient) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}