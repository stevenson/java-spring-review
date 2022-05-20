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
        final String sql = "INSERT INTO person VALUES (uuid_generate_v4(), ?)";
        return jdbcTemplate.update(sql, person.getName());

    }

    @Override
    public List<Person> retrieveAll() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> retrieveById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id =?";
        Person person =  jdbcTemplate.queryForObject(sql,  (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String personName = resultSet.getString("name");
            return new Person(personId, personName);
        }, id);
        return Optional.ofNullable((person));
    }

    @Override
    public int update(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deleteById(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
}
