package y.z.pages.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import y.z.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TestAdultPage extends BasePage {

    public static final String PAGE_TITLE = "Проверьте ваш английский - для взрослых | Cambridge English";

    @FindBy(xpath = "//div[@class='question-header']/h3")
    private WebElement questionHeader;

    @FindBy(css = "ul#cphMainContent_ctl01_rptQuestions_rblAnswers_0 input")
    private List<WebElement> question1;
    @FindBy(css = "ul#cphMainContent_ctl01_rptQuestions_rblAnswers_1 input")
    private List<WebElement> question2;
    @FindBy(css = "ul#cphMainContent_ctl01_rptQuestions_rblAnswers_2 input")
    private List<WebElement> question3;
    @FindBy(css = "ul#cphMainContent_ctl01_rptQuestions_rblAnswers_3 input")
    private List<WebElement> question4;
    @FindBy(css = "ul#cphMainContent_ctl01_rptQuestions_rblAnswers_4 input")
    private List<WebElement> question5;

    private List allQuestions = new ArrayList();

    @FindBy(css = ".btnSubmit")
    private WebElement btnSubmit;

    @FindBy(xpath = "//p[contains(@class,'error-message')]")
    private List<WebElement> errorList;


    public TestAdultPage(WebDriver driver) {
        super(driver);
        allQuestions.add(question1);
        allQuestions.add(question2);
        allQuestions.add(question3);
        allQuestions.add(question4);
        allQuestions.add(question5);
    }

    @Step("Нажата кнопка Next")
    public void submit() {
        btnSubmit.click();
    }

    @Step("На вопрос {0} выбран ответ {1}")
    public void setAnswer(int questionNumber, int answerNumber) {
        if ((questionNumber - 1) <= allQuestions.size() && (questionNumber > 0)) {
            List<WebElement> question = (List<WebElement>) allQuestions.get(questionNumber - 1);
            if ((answerNumber - 1) <= question.size() && (answerNumber > 0)) {
                question.get(answerNumber - 1).click();
            }
        }
    }

    public void setAnswer1(int answerNumber) {
        if (answerNumber <= question1.size() && (answerNumber >= 0)) {
            question1.get(answerNumber).click();
        }
    }

    public void setAnswer2(int answerNumber) {
        if (answerNumber <= question2.size() && (answerNumber >= 0)) {
            question2.get(answerNumber).click();
        }
    }

    public void setAnswer3(int answerNumber) {
        if (answerNumber <= question3.size() && (answerNumber >= 0)) {
            question3.get(answerNumber).click();
        }
    }

    public void setAnswer4(int answerNumber) {
        if (answerNumber <= question4.size() && (answerNumber >= 0)) {
            question4.get(answerNumber).click();
        }
    }

    public void setAnswer5(int answerNumber) {
        if (answerNumber <= question5.size() && (answerNumber >= 0)) {
            question5.get(answerNumber).click();
        }
    }

    public boolean errorExist(String errorText) {
        for (WebElement we : errorList) {
            System.out.println(we.getText());
            if (we.getText().contains(errorText)) {
                return true;
            }
        }
        return false;
    }

    public String getTestPageNumber() {
        String str = questionHeader.getText().trim();
        return str.substring(str.lastIndexOf("Page"));
    }

}
