package test;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController;

public class RestTest extends BaseApiTest {

    @DisplayName("Тест №1 Проверка успешной регистрации")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("tY7sd09");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()));
    }

    @DisplayName("Тест №2 Проверка повторной регистрации")
    @Test
    public void doReplyTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("34gfd09");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        requestSpecification.post();
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Тест №3 Проверка успешной регистрации компании")
    @Test
    public void registrationCompanyTest() {
        RootDoRegisterRequestPostModel regModel = RootDoRegisterRequestPostGenerator.randomEmailAndName("htdege5hd9");
        RequestSpecification registerRequest = BugredController.prepareDoRegister(regModel);
        Response regResponse = registerRequest.post();

        regResponse.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(regModel.getName()));

        RootCreateCompanyRequestPostModel createCompanyModel = RootCreateCompanyRequestPostGenerator.generate(regModel.getEmail(),
                "ИП",regModel.getEmail(),regModel.getEmail(),regModel.getEmail());
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(createCompanyModel);
        Response createCompanyResponse = createCompanyRequest.post();

        createCompanyResponse.then()
                .statusCode(200)
                .body("company.name", Matchers.equalTo(createCompanyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(createCompanyModel.getCompany_type()));
    }
}
