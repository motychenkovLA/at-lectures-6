package autotests.RestApi;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import autotests.base.BaseApiTest;
import models.services.bugred.BugredController;

public class RestApiTest extends BaseApiTest {

    @DisplayName("Тест №1 - Проверка успешной регистрации пользователя")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("abracadabra");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

    }

    @DisplayName("Тест №2 - Проверка повторной регистрации")
    @Test
    public void doReRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("abracadabra");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        requestSpecification.post();

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }


    @DisplayName("Тест №3 - Проверка успешной регистрации компании")
    @Test
    public void createCompanyTest() {
        RootDoRegisterRequestPostModel userModel = RootDoRegisterRequestPostGenerator.randomEmailAndName("abracadabra");
        RequestSpecification registerRequest = BugredController.prepareDoRegister(userModel);
        Response registerResponse = registerRequest.post();

        registerResponse.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(userModel.getName()));


        RootCreateCompanyRequestPostModel createCompanyModel = RootCreateCompanyRequestPostGenerator.generate(
                userModel.getEmail(), "ИП", userModel.getEmail(), userModel.getEmail());
        RequestSpecification companyRequestSpecification = BugredController.
                prepareCreateCompany(createCompanyModel);
        Response createCompanyResponse = companyRequestSpecification.post();

        createCompanyResponse.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(createCompanyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(createCompanyModel.getCompany_type()));
    }
}
