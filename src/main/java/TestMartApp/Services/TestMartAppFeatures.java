package TestMartApp.Services;

import TestMartApp.Utils.APICommonMethods;
import TestMartApp.Utils.APIConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class TestMartAppFeatures {
    /**
     * Prints the titles of all products that have a rating less than or equal to the provided criteria.
     * @param rating The rating threshold.
     */
    public void getProductTitlesByWorseRating(double rating) throws Exception {
        List<JSONObject> productsList = APICommonMethods.getAllObjects(APIConstants.PRODUCTS,"products");
        List<String> ratingTitlesList = new LinkedList<>();
        for (JSONObject product:productsList
        ) {
            if(product.getDouble("rating")<=rating){
                ratingTitlesList.add(product.get("title").toString());
            }
        }
    }

    /**
     * Returns the cart with the highest total value.
     * @returns The cart with the highest total value.
     */
    public JSONObject getCartWithHighestTotal() throws Exception {
        List<JSONObject> cartsList = APICommonMethods.getAllObjects(APIConstants.CARTS,"carts");
        JSONObject maxCart=cartsList.get(0);
        for (JSONObject cart: cartsList
        ) {
            if(cart.getInt("total")>maxCart.getInt("total")){
                maxCart=cart;
            }
        }
        return maxCart;
    }

    /**
     * Returns the cart with the lowest total value.
     * @returns The cart with the lowest total value.
     */
    public JSONObject getCartWithLowestTotal() throws Exception {
        List<JSONObject> cartsList = APICommonMethods.getAllObjects(APIConstants.CARTS,"carts");
        JSONObject minCart =cartsList.get(0);
        for (JSONObject cart: cartsList
        ) {
            if(cart.getInt("total") < minCart.getInt("total")){
                minCart =cart;
            }
        }
        return minCart;
    }

    /**
     * Enriches the product information in a user's cart by adding product images.
     * The current product information in a cart has limited fields.
     * This method adds the `images` field for each product in a given user's cart.
     * Note: This method only applies to the first element from the `carts[]` JSON response.
     * @param userId The ID of the user whose cart's product information will be enriched.
     * @returns A list of products with enriched information in the user's cart.
     */
    public List<JSONObject> addProductImagesToUserCart(Integer userId) throws Exception {
        CartClass cartClass = new CartClass();
        List<JSONObject> cartsList = cartClass.getUserCarts(userId);
        List<JSONObject> updatedProducts = new LinkedList<>();
        JSONArray productArray = (JSONArray) cartsList.get(0).get("products");
        for (Object product:productArray
        ) {
            JSONObject updatedProduct = (JSONObject)product;
            updatedProduct.put("images","tbd");
            updatedProducts.add(updatedProduct);
        }
        return updatedProducts;
    }
}
