package TestMartApp.Services;

import TestMartApp.Utils.APICommonMethods;
import TestMartApp.Utils.APIConstants;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class CartClass implements CartService{


    public List <JSONObject> getAllCarts() throws Exception {
      return APICommonMethods.getAllObjects(APIConstants.CARTS,"carts");
    }

    public JSONObject getCart(Integer cartId) throws Exception {
        return APICommonMethods.getObjectById(APIConstants.CARTS,"carts",cartId);
    }


    public List<JSONObject> getUserCarts(Integer userId) throws Exception {
        List<JSONObject>listOfCarts= new LinkedList<>(getAllCarts());
        List<JSONObject>userCartList=new LinkedList<>();
        for (JSONObject cart:listOfCarts
             ) {
            if(cart.get("userId")==userId){
                userCartList.add(cart);
            }

        }
        return userCartList;
    }
}
