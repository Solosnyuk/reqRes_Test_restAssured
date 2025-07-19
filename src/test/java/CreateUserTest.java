import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseApiTest{

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        RestAssured
                .given()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post("/users")
                .then()
                    .statusCode(201)
                    .body("id",not(equalTo("")))
                    .body("id",notNullValue())
                    .body("createdAt", notNullValue());
    }


}
