package TestCases;

import TestMartApp.Services.ProductClass;
import Utilis.TestCommonMethods;
import Utilis.TestConstants;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductServiceTest {
    ProductClass productClass = new ProductClass();

    @Test
    public void getAllProductsTest() throws Exception {
        List<JSONObject> productListApp = productClass.getAllProducts();
        List<JSONObject> productListTest = TestCommonMethods.getAllTestObjects(TestConstants.PRODUCTS, "products");
        Assertions.assertTrue(TestCommonMethods.areListsMatch(productListApp, productListTest, "id", "title"),
                "getAllProducts method works as expected");
    }
}
