import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserId extends BaseApiTest{

    public static Response getUserIdTest(Integer id) {
        return RestAssured
                .given()
                .log().all()
                .when()
                .get("/users/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }
}