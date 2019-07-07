package y.z;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    private ChromeOptions options;
    private Properties properties;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--headless");
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/test/resources/data.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("browser.implicitly.timeout.ms")), TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("browser.page.load.timeout.ms")), TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(Long.parseLong(properties.getProperty("browser.set.script.timeout.ms")), TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        initPages();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    protected abstract void initPages();
}
