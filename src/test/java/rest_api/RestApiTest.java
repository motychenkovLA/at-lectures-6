package rest_api;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred_site.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred_site.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import rest_api.base.BaseApiTest;
import services.bugred_site.BugredController;

public class RestApiTest extends BaseApiTest {

    @DisplayName("Тест №1 - Проверка успешной регистрации")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("112233");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

    }
}
