package com.sap.corp.azurepoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class EventRepository {

    private static final String SQL_FIND_BY_ID = "SELECT * FROM EVENTS WHERE ID = :id";
    private static final String SQL_FIND_ALL = "SELECT * FROM EVENTS";
    private static final String SQL_INSERT = "INSERT INTO EVENTS (ID, EVENT) values(:id, :event)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM EVENTS WHERE ID = :id";

    private static final BeanPropertyRowMapper<Event> ROW_MAPPER = new BeanPropertyRowMapper<>(Event.class);

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Event findById(Integer id) {
        try {
            final SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, paramSource, ROW_MAPPER);
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Iterable<Event> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, ROW_MAPPER);
    }

    public int save(Event event) {
        final SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", event.getId())
                .addValue("event", event.getEvent());

        return jdbcTemplate.update(SQL_INSERT, paramSource);
    }

    public void deleteById(Integer id) {
        final SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(SQL_DELETE_BY_ID, paramSource);
    }
}