package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController;

public class RestTest extends BaseApiTest {

    @Test
    public void doRegister() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123");
        RequestSpecification url = BugredController.prepareDoRegister(model);
        Response post = url.post();
        post.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email",Matchers.equalTo(model.getEmail()));


    }
@Test
    public void repeatDoRegister(){
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123");
        RequestSpecification url = BugredController.prepareDoRegister(model);
        url.post();
        Response post = url.post(); // второй раз отправляем такой же запрос
        post.then()
                .statusCode(200)
                .body("message",Matchers.containsString(model.getEmail()))
                .body("type",Matchers.equalTo("error"));
    }
}
