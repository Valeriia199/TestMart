package Utilis;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

import java.util.List;

public class TestCommonMethods {
    public static RequestSpecification request;

    public static String responseString(String url) {
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

    public static boolean areListsMatch(List<JSONObject> listFromApp, List<JSONObject> listFromTest, String compareBy) {
        boolean isMatch = false;
        if (listFromApp.size() == listFromTest.size()) {
            for (int i = 0; i < listFromApp.size(); i++) {
                isMatch = (listFromTest.get(i).get(compareBy)).equals(listFromApp.get(i).get(compareBy));
            }
        }
        return isMatch;
    }

    public static boolean areListsMatch(List<JSONObject> listFromApp, List<JSONObject> listFromTest,
                                        String compareBy1, String compareBy2) {
        boolean isMatch = false;
        if (listFromApp.size() == listFromTest.size()) {
            for (int i = 0; i < listFromApp.size(); i++) {
                isMatch = (listFromTest.get(i).get(compareBy1)).equals(listFromApp.get(i).get(compareBy1)) &&
                        (listFromTest.get(i).get(compareBy2)).equals(listFromApp.get(i).get(compareBy2));
            }
        }
        return isMatch;
    }
    public static boolean areJSONObjectsMatch (JSONObject jObject1, JSONObject jObject2, String compareBy1, String compareBy2){
        boolean isMatch = false;
        if(jObject1.length()==jObject2.length()) {
            isMatch = (jObject1.get(compareBy1)).equals(jObject2.get(compareBy1)) &&
                    (jObject1.get(compareBy2)).equals(jObject2.get(compareBy2));
        }
        return isMatch;
    }
}