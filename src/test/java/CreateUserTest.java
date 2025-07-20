import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseApiTest{

    public static Response testCreateUser(String name, String job) {
        String requestBody = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header(API_KEY, API_VALUE)
                    .body(requestBody)
                .when()
                    .post("/users")
                .then()
                    .statusCode(201)
                    .body("id",not(equalTo("")))
                    .body("id",notNullValue())
                    .body("createdAt", notNullValue())
                    .extract().response();
    }
}