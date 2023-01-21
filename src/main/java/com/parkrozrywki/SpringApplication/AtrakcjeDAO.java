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
        String sql = "SELECT * FROM atrakcje";
        //id_atrakcji, nazwa_atrakcji, cena_atrakcji, stan_atrakcji, minimalny_wzrost, data_otwarcia, wysokosc, czas_trwania

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Atrakcje atrakcja) {
        SimpleJdbcInsert insertKlient = new SimpleJdbcInsert(jdbcTemplate);
        insertKlient.withTableName("atrakcje").usingColumns("id_atrakcji","nazwa_atrakcji", "cena_atrakcji", "stan_atrakcji", "minimalny_wzrost", "data_otwarcia", "wysokosc", "czas_trwania", "wodna", "id_parku");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcja);
        insertKlient.execute(param);

    }

    /* Read – odczytywanie danych z bazy */
    public Atrakcje get(int id) {
        String sql = "SELECT * FROM atrakcje WHERE id_atrakcji = ?";
        Object[] args = {id};
        Atrakcje atrakcja = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Atrakcje.class));
        return atrakcja;
    }

    /* Update – aktualizacja danych */
    public void update(Atrakcje atrakcja) {
        String sql = "UPDATE atrakcje SET stan_atrakcji=:stan_atrakcji, cena_atrakcji=:cena_atrakcji, nazwa_atrakcji=:nazwa_atrakcji WHERE id_atrakcji=:id_atrakcji";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM atrakcje WHERE id_atrakcji = ?";
        jdbcTemplate.update(sql, id);
    }
}
