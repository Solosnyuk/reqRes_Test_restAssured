import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PutUserIdTest extends BaseApiTest {

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
                .statusCode(200)
                .extract()
                .response();
    }
}
