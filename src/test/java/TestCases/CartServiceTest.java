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
    @Test
    public void getCartByIdTest() throws Exception {
        JSONObject cartsApp = cartClass.getCart(1);
        JSONObject cartsTest = TestCommonMethods.getJSONObject(TestConstants.CARTS_1);
        Assertions.assertTrue(TestCommonMethods.areJSONObjectsMatch(cartsApp, cartsTest, "id", "userId"),
                "getCartById method works as expected");
    }
}
