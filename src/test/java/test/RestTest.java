package test;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.doRegister.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootCreateCompanyRequestPostModel;
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
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Тест №3 Проверка успешной регистрации компании")
    @Test
    public void registrationCompanyTest() {
        RootDoRegisterRequestPostModel companyModel = RootDoRegisterRequestPostGenerator.randomEmailAndName("htdege5hd9");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(companyModel);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(companyModel.getName()));

        RootCreateCompanyRequestPostModel createCompanyModel = RootCreateCompanyRequestPostGenerator.generate(companyModel.getEmail(),
                "ИП",companyModel.getEmail(),companyModel.getEmail(),companyModel.getEmail());
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(createCompanyModel);
        Response createCompanyResponse = createCompanyRequest.post();

        createCompanyResponse.then()
                .statusCode(200)
                .body("company.name", Matchers.equalTo(createCompanyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(createCompanyModel.getCompany_type()));
    }
}
