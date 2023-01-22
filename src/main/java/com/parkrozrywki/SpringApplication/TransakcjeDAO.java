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
public class TransakcjeDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public TransakcjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Transakcje> list(String imie){
        String sql = "select transakcje.id_klienta, transakcje.id_atrakcji, transakcje.data,atrakcje.nazwa_atrakcji from transakcje inner join atrakcje on transakcje.id_atrakcji = atrakcje.id_atrakcji where transakcje.id_klienta = 15";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transakcje.class));
    }

    /* Read – odczytywanie danych z bazy */
    public Transakcje get(int id) {
        String sql = "SELECT * FROM transakcje WHERE id_klienta = ?";
        Object[] args = {id};
        Transakcje transakcje = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Transakcje.class));
        return transakcje;
    }

}
