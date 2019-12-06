import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

interface SetupDriver {
    WebDriver setUpDriver() throws IOException;

    void closeDriver(WebDriver driver);
}

class myChromeDriver implements SetupDriver {

    public WebDriver setUpDriver() {
        return setUpChromeDriver();
    }

    public WebDriver setUpChromeDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", getClass().getResource("drivers/chromedriver78.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}

class myMazilaDriver implements SetupDriver {

    public WebDriver setUpDriver() {
        return setUpMazilaDriver();
    }

    public WebDriver setUpMazilaDriver() {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", getClass().getResource("drivers/geckodriver1.exe").getPath());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}

