package TestMartApp.Services;

import TestMartApp.Utils.APICommonMethods;
import TestMartApp.Utils.APIConstants;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductClass implements ProductService {
    URIBuilder uriBuilder;

    public List<JSONObject> getAllProducts() throws Exception {
        return APICommonMethods.getAllObjects(APIConstants.PRODUCTS, "products");
    }

    public List<JSONObject> getAllProducts(int limit, int skip, String fields) throws Exception {
        uriBuilder = new URIBuilder(APIConstants.PRODUCTS);
        uriBuilder.addParameter("limit", String.valueOf(limit));
        uriBuilder.addParameter("skip", String.valueOf(skip));
        uriBuilder.addParameter("select", fields);
        URL paramURL = uriBuilder.build().toURL();
        return APICommonMethods.getAllObjects(paramURL.toString(), "products");
    }

    public JSONObject getProduct(Integer productId) throws Exception {
        return APICommonMethods.getObjectById(APIConstants.PRODUCTS, "products", productId);
    }

    public List<JSONObject> searchProducts(String query) throws Exception {
        return APICommonMethods.searchByQuery(APIConstants.PRODUCTS, "products", query);
    }

    public List<String> getCategories() throws Exception {
        uriBuilder = new URIBuilder(APIConstants.PRODUCTS + "/categories");
        URL paramURL = uriBuilder.build().toURL();
        String responseString = APICommonMethods.getRequest(paramURL.toString());
        return new ArrayList<>(Arrays.asList(responseString.split(",")));
    }

    public List<JSONObject> getProductsByCategory(String categoryName) throws Exception {
        uriBuilder = new URIBuilder(APIConstants.PRODUCTS + "/category/" + categoryName);
        URL paramURL = uriBuilder.build().toURL();
        return APICommonMethods.getAllObjects(paramURL.toString(), "products");
    }
}