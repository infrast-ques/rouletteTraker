import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPagePokerDom {


    public void login(WebDriver driver, String login, String password) throws InterruptedException {
        /**
         * Переход на страницу авторизации
         */

        driver.get(VarData.url);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        /**
         * Ожидание прогрузки
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"login\"]")));

        /**
         * Ввод логина
         */
        driver.findElement(By.cssSelector("input[type=\"login\"]")).sendKeys(login);
        /**
         * Ввод пароля
         */
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(password);
        /**
         * Время на ввод каптчи, после чего необходимо перейти в необходимое лобби
         */
        Thread.sleep(60000);
        System.out.println("Left 10 second to start");
        Thread.sleep(15000);
        System.out.println("Start");
    }
}
