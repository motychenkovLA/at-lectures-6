package models.services.bugred;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;

public class BugredController {
    private static final String HOST = "http://users.bugred.ru/";

    public static RequestSpecification prepareDoRegister(RootDoRegisterRequestPostModel userModel) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(HOST)
                .basePath("tasks/rest/doregister")
                .body(userModel);
    }

    public static RequestSpecification prepareCreateCompany(RootCreateCompanyRequestPostModel companyModel){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(HOST)
                .basePath("tasks/rest/createcompany")
                .body(companyModel);
    }
}