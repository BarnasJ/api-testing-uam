package com.example.apitesting.rest;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GETfilmsTest {


    @Test
    public void getAllFilms() {

        int count = given()
                .baseUri("https://swapi.dev/api/")
                .log().everything()
        .when()
                .get("films/")
        .then()
                .log().everything()
                .extract()
                .body().path("count");

        System.out.println("COUNT: " + count);

    }

    @Test
    public void getOneFilm() {

        int episode_id =
            given()
                .baseUri("https://swapi.dev/api/")
                .pathParam("id", 1)
                .log().everything()
            .when()
                .get("films/{id}")
            .then()
                .log().everything()
                .extract()
                .body().path("episode_id");

        assertEquals(5, episode_id);

    }

    @Test
    public void getOneFilmInWookie() {

        String episode_id =
                given()
                        .baseUri("https://swapi.dev/api/")
                        .pathParam("id", 1)
                        .param("format", "wookiee")
                        .log().everything()
                    .when()
                        .get("films/{id}/")
                    .then()
                        .log().everything()
                        .extract()
                        .body().asString();

        System.out.println("episode_id: " + episode_id);

    }


}
