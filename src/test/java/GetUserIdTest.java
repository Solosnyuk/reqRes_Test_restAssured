import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserIdTest extends BaseApiTest{

    public static Response getUserIdTest(Integer id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(API_KEY, API_VALUE)
                .when()
                .get("/users/{id}", id)
                .then()
                .extract()
                .response();
    }
}