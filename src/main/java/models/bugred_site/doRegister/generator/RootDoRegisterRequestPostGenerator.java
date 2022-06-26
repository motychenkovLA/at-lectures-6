package models.bugred_site.doRegister.generator;

import com.github.javafaker.Faker;
import models.bugred_site.doRegister.request.RootDoRegisterRequestPostModel;

public class RootDoRegisterRequestPostGenerator {

    public static RootDoRegisterRequestPostModel randomEmailAndName(String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("???###@gmail.com"); // ?-буквы, #-числа
        String name = faker.name().name();

        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}
