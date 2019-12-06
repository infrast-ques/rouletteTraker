import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LaunchRX7 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {

        /**
         * Инициализация драйвера, в данную переменную можно передать также фаерфокс драйвер
         */
        SetupDriver webDriverClass = new myChromeDriver();
        driver = webDriverClass.setUpDriver();

        /**
         * Вся работа программы завязана на одном скрипте, что вызывается ниже
         */
        MainScriptPokerDom mainScriptPokerDom = new MainScriptPokerDom();
        mainScriptPokerDom.mainScript(driver);

        /**
         * Якобы завершение работы скрипта, но сюда он не дойдет
         */
        System.out.println("End script");
        webDriverClass.closeDriver(driver);
    }
}
