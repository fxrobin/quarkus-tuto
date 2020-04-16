package fr.fxjavadevblog.qjg.ping;

import static io.restassured.RestAssured.given;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.qjg.global.TestingGroups;
import io.quarkus.test.junit.QuarkusTest;

/**
 * Checking "ping service".
 * 
 * @see fr.fxjavadevblog.qjg.ping.PingService.PingService
 * @author François-Xavier Robin
 *
 */

@QuarkusTest
@Tag(TestingGroups.UNIT_TESTING)
class PingTest
{
    public static final String ENDPOINT = "/api/ping/v1";

    @Test
    void testPing()
    {        
        given().when()
               .get(ENDPOINT)
               .then()
               .statusCode(200)
               .assertThat().body(CoreMatchers.equalTo("pong"));                                 
    }
}
