package TestMartApp.Services;

import java.util.List;

public interface UserService<U> {
    /*
     * Get all users of TestMart
     * API endpoint to get data: https://dummyjson.com/users
     */
    List<U> getAllUsers() throws Exception;

    /*
     * Get a single user
     * API endpoint to get data: https://dummyjson.com/users/{userId}
     */
    U getUser(Integer userId) throws Exception;

    /*
     * Search users
     * API endpoint to get data: https://dummyjson.com/users/search?q={query}
     */
    List<U> searchUsers(String query) throws Exception;
}
