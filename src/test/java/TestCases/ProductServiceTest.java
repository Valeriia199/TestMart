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
    @Test
    public void getAllProductsParametersTest() throws Exception {
        List<JSONObject> productsApp = productClass.getAllProducts(10, 10, "title,price");
        List<JSONObject> productsTest = TestCommonMethods.getAllTestObjects(TestConstants.PRODUCTS_PRICE,"products");
        Assertions.assertTrue(TestCommonMethods.areListsMatch(productsApp, productsTest, "title","price"),
                "getAllProducts with parameters method works as expected");
    }
    @Test
    public void getProductByIdTest() throws Exception {
        JSONObject productsApp = productClass.getProduct(1);
        JSONObject productsTest = TestCommonMethods.getJSONObject(TestConstants.PRODUCTS_1);
        Assertions.assertTrue(TestCommonMethods.areJSONObjectsMatch(productsApp,productsTest,"id", "title"),
                "getProductById method works as expected");
    }
    @Test
    public void getProductByQueryTest() throws Exception {
        List<JSONObject> productsApp = productClass.searchProducts("phone");
        List<JSONObject> productsTest = TestCommonMethods.getAllTestObjects(TestConstants.PRODUCTS_SEARCH_PHONE, "products");
        Assertions.assertTrue(TestCommonMethods.areListsMatch(productsApp,productsTest,"brand", "title"),
                "getProductByQuery method works as expected");
    }
}
