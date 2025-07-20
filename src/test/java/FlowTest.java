import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class FlowTest {
        private final String userName = "Bob";
        private final String userJob = "QA Engineer";
        private final String updatedName = "Jane";
        private final String updatedJob = "Automation Engineer";
        private static Integer createdUserId;

        @Test
        public void createUserTest() {
            Response response = new CreateUserTest().testCreateUser(userName, userJob);
            createdUserId = response.jsonPath().getInt("id");
        }

        @Test(dependsOnMethods = "createUserTest")
        public void getUserTest() {
            Response response = new GetUserIdTest().getUserIdTest(createdUserId);
        }

        @Test(dependsOnMethods = "getUserTest")
        public void updateUserTest() {
            Response response = new PutUserIdTest().putUserIdTest(createdUserId, updatedName, updatedJob);
        }

        @Test(dependsOnMethods = "updateUserTest")
        public void deleteUserTest() {
            new DeleteUserIDTest().deleteUserIdTest(createdUserId);
    }
}
