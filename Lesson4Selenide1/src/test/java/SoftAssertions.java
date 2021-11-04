import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {
    @Test
    void softAssertions() {
        // - Откройте страницу Selenide в Github
        open("https://github.com/search?q=selenide");

        // - Перейдите в раздел Wiki проекта
        $(byText("Wikis")).click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[title=SoftAssertions]").shouldHave(text("SoftAssertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("[title=SoftAssertions]").click();
        $(".markdown-body").shouldHave(text("com.codeborne.selenide.junit5.SoftAssertsExtension"));



//        sleep(5000);
    }
}
