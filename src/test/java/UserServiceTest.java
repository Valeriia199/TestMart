import TestMartApp.Services.UserClass;
import Utilis.TestCommonMethods;
import Utilis.TestConstants;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {
    UserClass userClass = new UserClass();

    @Test
    public void getAllUsers() throws Exception {
        List<JSONObject> userListApp = userClass.getAllUsers();
        List<JSONObject> userListTest = TestCommonMethods.getAllTestObjects(TestConstants.USERS, "users");
        Assertions.assertTrue(TestCommonMethods.areListsMatch(userListApp, userListTest, "id", "birthDate"),
                "getAllUsers method works as expected");
    }
}
