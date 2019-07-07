package y.z.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BasePage extends BaseWebComponent {

    @FindBy(xpath = "//li[@class='navigation_item']/a")
    private List<WebElement> menuUp;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    // Получить заголовок страницы
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Получить верхнее меню (6 items)
    public List<WebElement> getMenuUp() {
        return menuUp;
    }

}
