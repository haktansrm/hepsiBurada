package org.hepsiburada.TestCases;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hepsiburada.Utils.reports.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_Api_ResponseAndTime_Control {
    @Test
    public void statusAndTimeTest() {
        RestAssured.baseURI = "https://b9943154-149a-4635-9f25-856fb3ac9e54.mock.pstmn.io";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/mock123");

        int statusCode = response.getStatusCode();
        int expectedStatusCode = 200;

        Assert.assertEquals(statusCode, expectedStatusCode);
        ExtentTestManager.getTest().log(Status.PASS, "Status code matched  :"+expectedStatusCode+"" );

        long time = response.getTime();
        long expectedMaxTime = 4000;

        if (time>expectedMaxTime){
            Assert.fail("cevabın gelmesi çok uzun sürdü!");
        }
        ExtentTestManager.getTest().log(Status.PASS, "the response came in the expected time :"+expectedMaxTime+" ");

    }
}

