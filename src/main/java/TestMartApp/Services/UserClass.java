package TestMartApp.Services;

import TestMartApp.Utils.APICommonMethods;
import TestMartApp.Utils.APIConstants;
import org.apache.http.client.utils.URIBuilder;

import java.util.List;

public class UserClass {
    URIBuilder uriBuilder;
    public List getAllUsers() throws Exception {
        return APICommonMethods.getAllObjects(APIConstants.USERS,"users");
    }

    public Object getUser(Integer userId) throws Exception {
        return APICommonMethods.getObjectById(APIConstants.USERS,"users", userId);
    }

    public List searchUsers(String query) throws Exception {
        return APICommonMethods.searchByQuery(APIConstants.USERS,"users",query);
    }
}

