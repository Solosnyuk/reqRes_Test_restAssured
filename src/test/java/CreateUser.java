import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class CreateUser extends BaseApiTest{

    public static Response createUserTest(String name, String job) {
        String requestBody = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header(API_KEY, API_VALUE)
                    .body(requestBody)
                .when()
                    .post("/users")
                .then()
                    .extract().response();
    }
}