package TestMartApp.Services;

import TestMartApp.Utils.APICommonMethods;
import TestMartApp.Utils.APIConstants;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.util.List;

public class UserClass {
    public List <JSONObject> getAllUsers() throws Exception {
        return APICommonMethods.getAllObjects(APIConstants.USERS,"users");
    }

    public JSONObject getUser(Integer userId) throws Exception {
        return APICommonMethods.getObjectById(APIConstants.USERS,"users", userId);
    }

    public List <JSONObject> searchUsers(String query) throws Exception {
        return APICommonMethods.searchByQuery(APIConstants.USERS,"users",query);
    }
}

