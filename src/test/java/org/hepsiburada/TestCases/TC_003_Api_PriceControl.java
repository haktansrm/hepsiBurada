package org.hepsiburada.TestCases;


import org.hepsiburada.Api.ParseDynamicJson;
import org.testng.annotations.Test;

public class TC_003_Api_PriceControl {
String apiValues="rating";
String brandValue = "brand";
ParseDynamicJson parseDynamicJson = new ParseDynamicJson();

    @Test
    public void jsonNumericValueTest() {

        parseDynamicJson.priceControl(apiValues);
    }
    @Test
    public void jsonBrandTest() {

        parseDynamicJson.brandControl(brandValue);
    }
}
