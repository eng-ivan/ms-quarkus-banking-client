package core.ics;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;

@QuarkusTest
@QuarkusTestResource(InitializerContainerTest.class)
public class ClientControllerTest {


    @Test
    void listClient() {
        given()
                .when()
                .get("/api/client/list")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    void findClientByID() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/client/{id}")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    void connectionTest() throws UnknownHostException {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/api/test")
                .then()
                .statusCode(OK.getStatusCode());
    }

}