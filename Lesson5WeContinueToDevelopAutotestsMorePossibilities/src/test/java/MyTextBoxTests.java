import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        RegistrationsPage registrationsPage = new RegistrationsPage();
        //переход по ссылке
        registrationsPage.openPage(registrationsPage.URL)

        //проверка названия формы automation-practice-form
        .validateFormTitle()
        //заполнение
        .firstNameInput("Test")
                .firstLastInput("Testov")
                .emailInput("test@mail.ru")
                .genderInput(GenderInput.FEMALE)
                .userNumberInput("9040055515")
                .dateOfBirthInput("1990", "February", "7")
                .hobbiesInput(HobbiesInput.SPORTS, HobbiesInput.MUSIC, HobbiesInput.READING);

        $("#subjectsInput").sendKeys("e");
        $(byText("English")).click();

        $("#uploadPicture").uploadFromClasspath("Test.jpg");

        $("#currentAddress").setValue("Testik");

        $(byText("Select State")).scrollTo().click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        $("#submit").scrollTo().click();

        //Проверяем что перешли в верное модальное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        parent("Student Name", "Test Testov");
        parent("Student Email", "test@mail.ru");
        parent("Gender", "Male");
        parent("Mobile", "9040055515");
        parent("Date of Birth", "07 February,1990");
        parent("Subjects", "English");
        parent("Hobbies", "Sports, Reading, Music");
        parent("Picture", "Test.jpg");
        parent("Address", "Testik");
        parent("State and City", "NCR Delhi");

        sleep(5000);
    }


    void parent(String key, String meaning) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(meaning));
    }


}
