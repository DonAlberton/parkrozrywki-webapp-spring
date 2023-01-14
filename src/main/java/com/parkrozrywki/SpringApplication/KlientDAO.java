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
    public void save(Klient klient) {
        SimpleJdbcInsert insertKlient = new SimpleJdbcInsert(jdbcTemplate);
        insertKlient.withTableName("klienci").usingColumns("id_klienta","imie", "nazwisko", "numer_telefonu", "email", "id_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertKlient.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Klient get(int id) {
        String sql = "SELECT * FROM klienci WHERE id = ?";
        Object[] args = {id};
        Klient klient = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }

    public Klient get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM klienci WHERE id = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    /* Update – aktualizacja danych */
    public void update(Klient klient) {
        String sql = "UPDATE klienci SET imie=:imie, nazwisko=:nazwisko WHERE id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
