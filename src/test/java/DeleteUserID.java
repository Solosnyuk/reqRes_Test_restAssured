import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUserID extends BaseApiTest {

    public Response deleteUserIdTest(Integer id) {
        return RestAssured
                .given()
                .log().all()
                .header(API_KEY, API_VALUE)
                .when()
                .delete("/users/" + id)
                .then()
                .log().all()
                .extract().response();
    }
}
