import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyTextBoxTests {


    @BeforeAll
    static void disclosure() {
        Configuration.startMaximized = true;

    }

    @Test
    void formTest() {


        StudentData faker = new StudentData();

        RegistrationsPage registrationsPage = new RegistrationsPage();
        //переход по ссылке
        registrationsPage.openPage(registrationsPage.URL)

                //проверка названия формы automation-practice-form
                .validateFormTitle(registrationsPage.formTitle, registrationsPage.FORM_TEXT)
                //заполнение
                .firstNameInput(faker.firstName)
                .lastNameInput(faker.lastName)
                .emailInput(faker.userEmail)
                .genderInput(GenderInput.MALE)
                .userNumberInput("8904775511")
                .dateOfBirthInput("1990", "February", "7")
                .hobbiesInput(HobbiesInput.SPORTS, HobbiesInput.READING, HobbiesInput.MUSIC)
                .subjectsInput("e", "English").pictureInput("Test.jpg")
                .addressInput(faker.address)
                .stateAndCityInput("NCR", "Delhi")
                .submitClick()

                //Проверяем что перешли в верное модальное окно
                .validateFormTitle(registrationsPage.modalTitle, registrationsPage.MODAL_TEXT)


                //сравнение данных
                .parent("Student Name", faker.firstName + " " + faker.lastName)
                .parent("Student Email", faker.userEmail)
                .parent("Gender", "Male")
                .parent("Mobile", "8904775511")
                .parent("Date of Birth", "07 February,1990")
                .parent("Subjects", "English")
                .parent("Hobbies", "Sports, Reading, Music")
                .parent("Picture", "Test.jpg")
                .parent("Address", faker.address)
                .parent("State and City", "NCR Delhi");

        sleep(5000);
    }


}
