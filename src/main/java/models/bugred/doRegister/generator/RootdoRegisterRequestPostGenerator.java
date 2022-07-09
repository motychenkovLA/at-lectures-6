package models.bugred.doRegister.generator;

import com.github.javafaker.Faker;
import models.bugred.doRegister.request.RootdoRegisterRequestPostModel;

public class RootdoRegisterRequestPostGenerator {
    public static RootdoRegisterRequestPostModel randomEmailAndName(String password){
        Faker faker = Faker.instance();
        String email = faker.bothify("???###@email.ru");
        String name = faker.name()
                .name();
        return new RootdoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}
