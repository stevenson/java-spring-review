package com.stevenson.demo.dao;

import com.stevenson.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> retrieveAll() {
        final String sql = "SELECT id, name FROM person";
        jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
        return null;
    }

    @Override
    public Optional<Person> retrieveById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int update(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deleteById(UUID id) {
        return 0;
    }
}
