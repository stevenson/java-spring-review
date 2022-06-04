package com.stevenson.demo;

import com.stevenson.demo.api.CreatePersonRequest;
import com.stevenson.demo.api.PersonDto;
import com.stevenson.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldCreateNewPerson() {
        ResponseEntity<PersonDto> response = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/person",
                CreatePersonRequest.builder()
                        .name("newPerson")
                        .email("some email")
                        .age(18)
                        .build(),
                PersonDto.class);

        assertThat(response, is(notNullValue()));
        assertThat(response.getStatusCodeValue(), is(200));
    }
}
