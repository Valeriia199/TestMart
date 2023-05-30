package Utilis;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

import java.util.List;

public class TestCommonMethods {
    public static RequestSpecification request;

    public static String responseString (String url){
        return RestAssured.given().get(url).getBody().asString();
    }

    public static JSONObject getJSONObject(String objectURL) throws Exception {
        return new JSONObject(responseString(objectURL));
    }

    public static List<JSONObject> getAllTestObjects(String testURL, String token) throws Exception {
        JSONArray jsonArrayResponse = getJSONObject(testURL).getJSONArray(token);
        List<JSONObject> responseJsonList = new ArrayList<>();
        if (jsonArrayResponse != null) {
            for (Object jObject : jsonArrayResponse
            ) {
                responseJsonList.add((JSONObject) jObject);
            }
        }
        return responseJsonList;
    }
}