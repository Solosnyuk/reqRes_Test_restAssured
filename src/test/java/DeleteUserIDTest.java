import io.restassured.RestAssured;

public class DeleteUserIDTest extends BaseApiTest {

    public void deleteUserIdTest(Integer id) {
        RestAssured
                .given()
                .header(API_KEY, API_VALUE)
                .when()
                .delete("/users/" + id)
                .then()
                .statusCode(204);
    }
}
