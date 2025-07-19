import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    public static final String BASE_URL = "https://reqres.in/api";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

}
