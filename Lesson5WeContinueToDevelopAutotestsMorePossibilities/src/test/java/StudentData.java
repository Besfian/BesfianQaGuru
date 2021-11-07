import com.github.javafaker.Faker;

import java.util.Locale;

public class StudentData {
    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress("test");
    public String address = faker.address().streetAddress();
}

