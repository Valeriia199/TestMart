package TestMartApp.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APICommonMethods {
     public static String getRequest(String utlToRead) throws Exception{
         StringBuilder result= new StringBuilder();
         URL url=new URL(utlToRead);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         try (BufferedReader reader = new BufferedReader(
                 new InputStreamReader(conn.getInputStream()))) {
             for (String line; (line = reader.readLine()) != null; ) {
                 result.append(line);
             }
         }
         return result.toString();
     }
    public static List<JSONObject> getAllObjects(String objectURL, String token) throws Exception {
        String responseString = APICommonMethods.getRequest(objectURL);
        JSONObject responseJson = new JSONObject(responseString);
        JSONArray objectsJArray = responseJson.getJSONArray(token);
        List<org.json.JSONObject> listOfObjects = new ArrayList<>();
        if (objectsJArray !=null){
            for (int i = 0; i< objectsJArray.length(); i++){
                listOfObjects.add(objectsJArray.optJSONObject(i));
            }
        }
        return listOfObjects;
    }
}