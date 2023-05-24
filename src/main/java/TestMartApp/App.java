package TestMartApp;

import TestMartApp.Services.CartClass;
import TestMartApp.Services.ProductClass;
import TestMartApp.Services.UserClass;

public class App {
    public static void main(String[] args) throws Exception {
        CartClass cartClass=new CartClass();
        cartClass.getAllCarts();
        ProductClass productClass=new ProductClass();
        productClass.getAllProducts();
        productClass.getAllProducts(20,1,"brand,price");
        productClass.getProduct(1);
        productClass.searchProducts("phone");
        productClass.getProductsByCategory("smartphones");
        UserClass userClass=new UserClass();
        userClass.getAllUsers();
        userClass.getUser(1);
        userClass.searchUsers("John");
    }
}
