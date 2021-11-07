import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    public final String URL = "https://demoqa.com/automation-practice-form";
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            formFirstNameInput = $("#firstName"),
            formLastNameInput = $("#lastName"),
            formEMAILInput = $("#userEmail"),
            formUserNumberInput = $("#userNumber"),
            formDateOfBirthInput = $("#dateOfBirthInput"),

    formResultsTable = $(".table-responsive");

    public RegistrationsPage openPage(String URL) {
        open(URL);
        return this;
    }

    public RegistrationsPage validateFormTitle() {
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    //ввод firstName
    public RegistrationsPage firstNameInput(String firstName) {
        formFirstNameInput.setValue(firstName);
        return this;
    }

    //ввод lastName
    public RegistrationsPage firstLastInput(String lastName) {
        formLastNameInput.setValue(lastName);
        return this;
    }

    //ввод email
    public RegistrationsPage emailInput(String email) {
        formEMAILInput.setValue(email);
        return this;
    }

    //ввод userNumber
    public RegistrationsPage userNumberInput(String userNumber) {
        formUserNumberInput.setValue(userNumber);
        return this;
    }

    //ввод dateOfBirth
    public RegistrationsPage dateOfBirthInput(String year, String month, String day) {

        formDateOfBirthInput.click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(byText(day)).click();
        return this;
    }


    public RegistrationsPage hobbiesInput(HobbiesInput SPORTS) {
        $(SPORTS.getSelector()).click();
        return this;
    }

    public RegistrationsPage hobbiesInput(HobbiesInput SPORTS, HobbiesInput READING) {
        $(SPORTS.getSelector()).click();
        $(READING.getSelector()).click();
        return this;
    }

    public RegistrationsPage hobbiesInput(HobbiesInput SPORTS, HobbiesInput READING, HobbiesInput MUSIC) {
        $(SPORTS.getSelector()).click();
        $(READING.getSelector()).click();
        $(MUSIC.getSelector()).click();
        return this;
    }

    public RegistrationsPage genderInput(GenderInput gender) {

        $(gender.getSelector()).click();
        return this;
    }
}
