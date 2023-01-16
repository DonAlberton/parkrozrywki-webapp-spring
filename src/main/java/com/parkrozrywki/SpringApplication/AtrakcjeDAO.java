package com.parkrozrywki.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AtrakcjeDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AtrakcjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Atrakcje> list(){
        String sql = "SELECT id_atrakcji, nazwa_atrakcji, cena_atrakcji, stan_atrakcji, minimalny_wzrost, data_otwarcia, wysokosc, czas_trwania FROM atrakcje";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Atrakcje atrakcja) {

    }

    /* Read – odczytywanie danych z bazy */
    public Atrakcje get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Atrakcje atrakcja) {

    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {

    }
}
