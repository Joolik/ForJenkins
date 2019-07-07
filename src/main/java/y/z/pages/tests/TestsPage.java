package y.z.pages.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import y.z.base.BasePage;

public class TestsPage extends BasePage {

    public static final String PAGE_TITLE = "Проверьте ваш английский | Cambridge English";

    @FindBy(partialLinkText = "тест для взрослых")
    private WebElement testAdult;

    @FindBy(partialLinkText = "тест для школьников")
    private WebElement testSchool;

    public TestsPage(WebDriver driver) {
        super(driver);
    }

    // Начать тест для взрослых
    @Step("Начать тест для взрослых")
    public void startTestAdult() {
        testAdult.click();
    }

    // Начать тест для школьников
    public void startTestSchool() {
        testSchool.click();
    }
}
