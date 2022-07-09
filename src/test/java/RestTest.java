import base.BaseApiTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createcompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.createcompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.generator.RootdoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootdoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController;

import java.util.regex.Matcher;


public class RestTest extends BaseApiTest {

    @DisplayName("Проверка успешной регистрации")
    @Test
    public void doRegistor() {
        RootdoRegisterRequestPostModel model = RootdoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));
    }

    @DisplayName("Проверка повторной регистрации")
    @Test
    public void doRegistorRe() {
        RootdoRegisterRequestPostModel model = RootdoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        requestSpecification.post();
        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Проверка создания компании")
    @Test
    public void greateCompany() {
        RootdoRegisterRequestPostModel model = RootdoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

        RootCreateCompanyRequestPostModel model2 = RootCreateCompanyRequestPostGenerator.randomCompanyName("ИП", model.getEmail(), model.getEmail());
        RequestSpecification requestSpecification2 = BugredController.prepareCreateCompany(model2);

        Response response2 = requestSpecification2.post();
        response2.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.containsString(model2.getCompany_name()))
                .body("company.type", Matchers.containsString(model2.getCompany_type()));
    }


}
