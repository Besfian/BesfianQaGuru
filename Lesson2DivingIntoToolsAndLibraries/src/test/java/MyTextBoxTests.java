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
        //переход по ссылке
        open("https://demoqa.com/automation-practice-form");

        //заполнение
        $("[id=firstName]").setValue("Test");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("test@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9040055515");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("1990")).click();
        $(".react-datepicker__month-select").click();
        $(byText("February")).click();
        $(byText("7")).click();
        $("#subjectsInput").sendKeys("e");
        $(byText("English")).click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
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


    }


    void parent(String key, String meaning) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(meaning));
    }


}
