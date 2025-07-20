import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.*;

public class FlowTest {
        private final String userName = "Bob";
        private final String userJob = "QA Engineer";
        private final String updatedName = "Jane";
        private final String updatedJob = "Automation Engineer";
        private static Integer createdUserId;

    @Test
    public void createUserTest() {
        Response response = new CreateUser().createUserTest(userName, userJob);
        assertEquals(response.statusCode(), 201);
        assertNotNull(response.jsonPath().getString("id"));
        assertFalse(response.jsonPath().getString("id").isEmpty());
        assertNotNull(response.jsonPath().getString("createdAt"));

        createdUserId = response.jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "createUserTest")
    public void getUserTest() {
        Response response = new GetUserId().getUserIdTest(createdUserId);
        System.out.println(response.asString());

        assertEquals(response.statusCode(), 200);
        assertEquals(Optional.of(response.jsonPath().getInt("data.id")), createdUserId);
    }

    @Test(dependsOnMethods = "getUserTest")
    public void updateUserTest() {
        Response response = new PutUserId().putUserIdTest(createdUserId, updatedName, updatedJob);
         assertEquals(response.statusCode(), 200);
         assertEquals(response.jsonPath().getString("name"), updatedName);
         assertEquals(response.jsonPath().getString("job"), updatedJob);
    }

    @Test(dependsOnMethods = "updateUserTest")
    public void deleteUserTest() {
        Response response = new DeleteUserID().deleteUserIdTest(createdUserId);
        assertEquals(response.statusCode(), 204);
    }

     @Test
     public void negativeGetUserIdTest() {
     int nonExistentId = 9999;
     Response response = new GetUserId().getUserIdTest(nonExistentId);
     assertEquals(response.statusCode(), 404);
     }
}
