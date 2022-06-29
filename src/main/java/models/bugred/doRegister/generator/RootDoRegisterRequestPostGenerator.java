package models.bugred.doRegister.generator;

import com.github.javafaker.Faker;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeListener;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;

public class RootDoRegisterRequestPostGenerator {
    public static RootDoRegisterRequestPostModel randomEmailAndName(String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("???????####@gmail.com");
        String name = faker.name()
                .name();
        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}
