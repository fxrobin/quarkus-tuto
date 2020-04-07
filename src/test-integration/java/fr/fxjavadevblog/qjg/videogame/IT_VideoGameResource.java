package fr.fxjavadevblog.qjg.videogame;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.qjg.global.TestingGroups;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag(TestingGroups.INTEGRATION_TESTING)
class IT_VideoGameResource
{
    public static final String ENDPOINT = "/api/videogames/v1";

    @Test
    @DisplayName("Get " + ENDPOINT)
    void testGetAllVideoGames()
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
