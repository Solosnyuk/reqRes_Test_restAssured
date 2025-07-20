import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserId extends BaseApiTest{

    public static Response getUserIdTest(Integer id) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .header(API_KEY, API_VALUE)
                .when()
                .get("/users/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }
}