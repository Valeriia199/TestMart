package TestMartApp.Services;

import java.util.List;

public interface ProductService <P,C>{
    /*
     * Get all products of TestMart
     * API endpoint to get data: https://dummyjson.com/products
     */
    List<P> getAllProducts() throws Exception;

    /*
     * Get all products of TestMart using parameters
     * API endpoint to get data: https://dummyjson.com/products?limit={limit}&skip={skip}&select={comma separated
     * fields of product}
     */
    List<P> getAllProducts(int limit, int skip, String fields) throws Exception;

    /*
     * Get a single product
     * API endpoint to get data: https://dummyjson.com/products/{productId}
     */
    P getProduct(Integer productId) throws Exception;

    /**
     * Search for products in TestMart
     * API endpoint to get data: https://dummyjson.com/products/search?q={query}
     */
    List<P> searchProducts(String query) throws Exception;

    /*
     * Get all products categories in TestMart
     * API endpoint to get data: https://dummyjson.com/products/categories
     */
    List<C> getCategories() throws Exception;

    /*
     * Get all products of a category
     * API endpoint to get data: https://dummyjson.com/products/category/{categoryName}
     */
    List<P> getProductsByCategory(String categoryName) throws Exception;
}

