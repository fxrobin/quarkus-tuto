package fr.fxjavadevblog.qjg;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class IT_VideoGameResource
{
    public static final String ENDPOINT = "/api/videogames/v1";

    @Test
    void testAll()
    {        
        given().when()
               .get(ENDPOINT + "/")
               .then()
               .statusCode(200)
               .assertThat().body(containsString("XENON"), 
                                  containsString("RICK"), 
                                  containsString("LOTUS"));
    }

}
