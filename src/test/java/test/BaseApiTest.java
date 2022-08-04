package test;

import extension.AllurePrintStream;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.UnsupportedEncodingException;

public class BaseApiTest {
    static {
//        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL,System.out));
//        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL,System.out));
        try {
            RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL, new AllurePrintStream("request")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, new AllurePrintStream("response")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
