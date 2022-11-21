package org.hepsiburada.Api;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.Iterator;

import static io.restassured.RestAssured.given;

public class ParseDynamicJson {
    // How to parse dynamic JSON?
    // How to parse nested JSON?
    // Code Explanation : https://www.youtube.com/watch?v=ZjZqLUGCWxo
    public static boolean isNumeric(String string) {
        int intValue;
        double doubleValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        try {
            doubleValue = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static void parseObjectPrice(JSONObject json, String key) {
        String s = json.get(key).toString();
        System.out.println(s);
        if (isNumeric(s)){

            ExtentTestManager.getTest().log(Status.PASS, "Value is numeric");


        }else {
            ExtentTestManager.getTest().log(Status.PASS, "Value is not numeric");
            Assert.fail("değer sayısal değil");


        }

    }
    public static void parseObjectBrand(JSONObject json, String key) {
        String brand = json.get(key).toString();
        System.out.println(brand);
        Assert.assertEquals(brand,"Apple","Brand names not matched");
        ExtentTestManager.getTest().log(Status.PASS, "Brand names matched");


    }
    public static void getKey(JSONObject json, String key) {

        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {

                    if (json.get(nextKeys) instanceof JSONObject) {

                        if (exists == false) {
                            getKey(json.getJSONObject(nextKeys), key);
                        }

                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonarrayString = jsonarray.get(i).toString();
                            JSONObject innerJSOn = new JSONObject(jsonarrayString);

                            if (exists == false) {
                                getKey(innerJSOn, key);
                            }

                        }

                    }

                } catch (Exception e) {
                }

            }

        } else {
            parseObjectPrice(json, key);
        }

    }
    public static void getKeyBrand(JSONObject json, String key) {

        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {

                    if (json.get(nextKeys) instanceof JSONObject) {

                        if (exists == false) {
                            getKeyBrand(json.getJSONObject(nextKeys), key);
                        }

                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonarrayString = jsonarray.get(i).toString();
                            JSONObject innerJSOn = new JSONObject(jsonarrayString);

                            if (exists == false) {
                                getKeyBrand(innerJSOn, key);
                            }

                        }

                    }

                } catch (Exception e) {
                }

            }

        } else {
            parseObjectBrand(json, key);
        }

    }

    public static void priceControl(String apiValues) {

        RestAssured.baseURI = "https://b9943154-149a-4635-9f25-856fb3ac9e54.mock.pstmn.io";
        Response res = given()
                .when()
                .get("/mock123");
        JSONObject jsonResponse = new JSONObject(res.asString());
        getKey(jsonResponse, apiValues);

    }
    public static void brandControl(String brandValue) {

        RestAssured.baseURI = "https://b9943154-149a-4635-9f25-856fb3ac9e54.mock.pstmn.io";
        Response res = given()
                .when()
                .get("/mock123");
        JSONObject jsonResponse = new JSONObject(res.asString());
        getKeyBrand(jsonResponse, brandValue);

    }

}
