import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Name;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    public final String URL = "https://demoqa.com/automation-practice-form";
    public final String FORM_TEXT = "Student Registration Form";
    public final String MODAL_TEXT = "Thanks for submitting the form";
    public SelenideElement
            formTitle = $(".practice-form-wrapper"),
            modalTitle = $("#example-modal-sizes-title-lg");
    private SelenideElement
            formFirstNameInput = $("#firstName"),
            formLastNameInput = $("#lastName"),
            formEmailInput = $("#userEmail"),
            formUserNumberInput = $("#userNumber"),
            formDateOfBirthInput = $("#dateOfBirthInput"),
            formSubmit = $("#submit"),
            formSubjectsInput = $("#subjectsInput"),
            formUploadPictureInput = $("#uploadPicture"),
            formCurrentAddressInput = $("#currentAddress");


    public SelenideElement formResultsTable = $(".table-responsive");

    public RegistrationsPage openPage(String URL) {
        open(URL);
        return this;
    }

    public RegistrationsPage validateFormTitle(SelenideElement FORM, String TEXT) {
        FORM.shouldHave(text(TEXT));
        return this;
    }

    public RegistrationsPage firstNameInput(String firstName) {
        formFirstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationsPage lastNameInput(String lastName) {
        formLastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationsPage emailInput(String email) {
        formEmailInput.setValue(email);
        return this;
    }

    public RegistrationsPage userNumberInput(String userNumber) {
        formUserNumberInput.setValue(userNumber);
        return this;
    }

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

    public RegistrationsPage subjectsInput(String subjects, String fullSubjects) {

        formSubjectsInput.sendKeys(subjects);
        $(byText(fullSubjects)).click();
        return this;
    }

    public RegistrationsPage pictureInput(String picture) {

        formUploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationsPage addressInput(String address) {

        formCurrentAddressInput.setValue(address);
        return this;
    }

    public RegistrationsPage stateAndCityInput(String state, String city) {

        $(byText("Select State")).scrollTo().click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationsPage submitClick() {

        formSubmit.scrollTo().click();
        return this;
    }

    RegistrationsPage parent(String key, String meaning) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(meaning));
        return this;
    }

}
