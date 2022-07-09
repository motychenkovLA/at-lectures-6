package models.bugred.createcompany.generator;

import com.github.javafaker.Faker;
import models.bugred.createcompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.request.RootdoRegisterRequestPostModel;

public class RootCreateCompanyRequestPostGenerator {
    public static RootCreateCompanyRequestPostModel randomCompanyName(String companyType,String emailOwner,String...companyUsers){
        Faker faker = Faker.instance();
        return new RootCreateCompanyRequestPostModel()
                .setCompany_type(companyType)
                .setCompany_name(faker.company().name())
                .setCompany_users(companyUsers)
                .setEmail_owner(emailOwner);
    }
}
