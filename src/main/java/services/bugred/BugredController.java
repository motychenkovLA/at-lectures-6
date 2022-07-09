package services.bugred;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import models.bugred.createcompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.request.RootdoRegisterRequestPostModel;

public class BugredController {
    private static final String HOST = "http://users.bugred.ru/";

    public static RequestSpecification prepareDoRegister (RootdoRegisterRequestPostModel model){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(HOST)
                .basePath("tasks/rest/doregister")
                .body(model);
    }
    public static RequestSpecification prepareCreateCompany (RootCreateCompanyRequestPostModel model){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(HOST)
                .basePath("tasks/rest/createcompany")
                .body(model);
    }
}
