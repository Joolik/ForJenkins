package y.z;

import org.testng.annotations.Test;
import y.z.pages.tests.TestAdultPage;
import y.z.pages.tests.TestsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LevelTestAdults extends BaseTest {

    private TestsPage testsPage;
    private TestAdultPage testAdultPage;

    @Override
    protected void initPages() {
        testsPage = new TestsPage(driver);
        testAdultPage = new TestAdultPage(driver);
    }

    // Переход ко второй странице с вопросами
    @Test
    public void goNextTest() {
        testsPage.startTestAdult();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 1"));
        testAdultPage.setAnswer(1,1);
        testAdultPage.setAnswer(2,2);
        testAdultPage.setAnswer(3,2);
        testAdultPage.setAnswer(4,1);
        testAdultPage.setAnswer(5,3);

//        testAdultPage.setAnswer1(0);
//        testAdultPage.setAnswer2(1);
//        testAdultPage.setAnswer3(1);
//        testAdultPage.setAnswer4(0);
//        testAdultPage.setAnswer5(2);
        testAdultPage.submit();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 2"));

    }

    // Ответы есть только на часть вопросов. Ошибка при переходе к следующей странице.
    @Test
    public void goNextPartialErrorTest() {
        testsPage.startTestAdult();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 1"));
        testAdultPage.setAnswer(1,1);
        testAdultPage.setAnswer(2,2);
        testAdultPage.setAnswer(3,2);
        testAdultPage.setAnswer(4,1);
//        testAdultPage.setAnswer1(1);
//        testAdultPage.setAnswer2(0);
//        testAdultPage.setAnswer3(1);
//        testAdultPage.setAnswer4(2);
        testAdultPage.submit();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 1"));
        assertThat("Ошибка с текстом не найдена", testAdultPage.errorExist("You must answer all questions before you can proceed to the next step"));

    }

    // Нет ни одного ответа. Ошибка при переходе к следующей странице.
    @Test
    public void goNextEmptyErrorTest() {
        testsPage.startTestAdult();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 1"));
        testAdultPage.submit();
        assertThat(testAdultPage.getPageTitle(), equalTo(testAdultPage.PAGE_TITLE));
        assertThat(testAdultPage.getTestPageNumber(), equalTo("Page 1"));
        assertThat("Ошибка с текстом не найдена", testAdultPage.errorExist("You must answer all questions before you can proceed to the next step"));

    }

}
