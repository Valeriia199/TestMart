package TestCases;

import TestMartApp.Services.CartClass;
import Utilis.TestCommonMethods;
import Utilis.TestConstants;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartServiceTest {
    CartClass cartClass = new CartClass();

    @Test
    public void getAllCartsTest() throws Exception {
        List<JSONObject> cartsListApp = cartClass.getAllCarts();
        List<JSONObject> cartsListTest = TestCommonMethods.getAllTestObjects(TestConstants.CARTS, "carts");
        Assertions.assertTrue(TestCommonMethods.areListsMatch(cartsListApp, cartsListTest, "id"),
                "getAllCarts method works as expected");
    }
}
