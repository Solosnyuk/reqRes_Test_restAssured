import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {
    public static final String BASE_URL = "https://reqres.in/api";
    public static final String API_VALUE = "reqres-free-v1";
    public static final String API_KEY = "x-api-key";

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
