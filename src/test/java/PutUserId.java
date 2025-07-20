import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutUserId extends BaseApiTest {

    public Response putUserIdTest(Integer id, String newName, String newJob) {
        String requestBody = "{ \"name\": \"" + newName + "\", \"job\": \"" + newJob + "\" }";

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(API_KEY, API_VALUE)
                .body(requestBody)
                .when()
                .put("/api/users/" + id)
                .then()
                .extract()
                .response();
    }
}
