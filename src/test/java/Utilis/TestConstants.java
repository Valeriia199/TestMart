package Utilis;


import io.restassured.RestAssured;

public class TestConstants {
    public static final String BaseURI= RestAssured.baseURI="https://dummyjson.com/";
    public static final String PRODUCTS = BaseURI+"products";
    public static final String PRODUCTS_PRICE = BaseURI+"products?limit=10&skip=10&select=title,price";
    public static final String PRODUCTS_1 = BaseURI+"products/1";
    public static final String PRODUCTS_SEARCH_PHONE = BaseURI+"products/search?q=phone";
    public static final String PRODUCTS_CATEGORIES = BaseURI+"products/categories";
    public static final String PRODUCTS_SMARTPHONES = BaseURI+"products/category/smartphones";
    public static final String CARTS = BaseURI+"carts";
    public static final String CARTS_1 = BaseURI+"carts/1";
    public static final String CARTS_USER_5 = BaseURI+"carts/user/5";
    public static final String USERS = BaseURI+"users";
    public static final String USERS_1 = BaseURI+"users/1";
    public static final String USERS_SEARCH_JOHN = BaseURI+"users/search?q=John";

}

