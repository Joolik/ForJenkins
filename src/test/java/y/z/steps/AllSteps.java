package y.z.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import y.z.pages.tests.TestAdultPage;
import y.z.pages.tests.TestsPage;

public class AllSteps {

    private TestsPage testsPage;
    private TestAdultPage testAdultPage;

    public AllSteps(WebDriver driver) {
        testsPage = new TestsPage(driver);
        testAdultPage = new TestAdultPage(driver);
    }

    @Step("На вопрос {0} выбран ответ {1}")
    public void setAnswer(int questionNumber, int answerNumber) {
        testAdultPage.setAnswer(questionNumber, answerNumber);
    }

    @Step("Начать тест для взрослых")
    public void startTestAdult() {
        testsPage.startTestAdult();
    }
}
