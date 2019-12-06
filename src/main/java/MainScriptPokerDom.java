import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainScriptPokerDom {

    public void mainScript(WebDriver driver) throws InterruptedException {

        /**
         * Осуществление авторизации
         */
        MainPagePokerDom mainPagePokerDom = new MainPagePokerDom();
        mainPagePokerDom.login(driver, VarData.login, VarData.password);

        while (true) {

            /**
             * Для взаимодействия с окном игры, необходимо переключить драйвер на его айфрейм, который является вложенным в другой айфрейм
             */
            switchTo2ndiframe(driver);

            /**
             * Здесь происходит инициализация игровых окон в лобби
             */
            WebElement alertElement1 = driver.findElement(By.cssSelector("div[data-tableid=\"zosmk25g2f768o52\"]"));
            PokerDomRouletteStrikeAlert alert1 = new PokerDomRouletteStrikeAlert(driver, alertElement1, 1);
            WebElement alertElement2 = driver.findElement(By.cssSelector("div[data-tableid=\"LightningTable01\"]"));
            PokerDomRouletteStrikeAlert alert2 = new PokerDomRouletteStrikeAlert(driver, alertElement2, 2);
            WebElement alertElement3 = driver.findElement(By.cssSelector("div[data-tableid=\"7x0b1tgh7agmf6hv\"]"));
            PokerDomRouletteStrikeAlert alert3 = new PokerDomRouletteStrikeAlert(driver, alertElement3, 3);
            WebElement alertElement4 = driver.findElement(By.cssSelector("div[data-tableid=\"vctlz20yfnmp1ylr\"]"));
            PokerDomRouletteStrikeAlert alert4 = new PokerDomRouletteStrikeAlert(driver, alertElement4, 4);
            WebElement alertElement5 = driver.findElement(By.cssSelector("div[data-tableid=\"wzg6kdkad1oe7m5k\"]"));
            PokerDomRouletteStrikeAlert alert5 = new PokerDomRouletteStrikeAlert(driver, alertElement5, 5);
//            WebElement alertElement6 = driver.findElement(By.cssSelector("div[data-tableid=\"AmericanTable001\"]"));
//            PokerDomRouletteStrikeAlert alert6 = new PokerDomRouletteStrikeAlert(driver, alertElement6, 6);
            WebElement alertElement7 = driver.findElement(By.cssSelector("div[data-tableid=\"lkcbrbdckjxajdol\"]"));
            PokerDomRouletteStrikeAlert alert7 = new PokerDomRouletteStrikeAlert(driver, alertElement7, 7);
            WebElement alertElement8 = driver.findElement(By.cssSelector("div[data-tableid=\"48z5pjps3ntvqc1b\"]"));
            PokerDomRouletteStrikeAlert alert8 = new PokerDomRouletteStrikeAlert(driver, alertElement8, 8);
            WebElement alertElement9 = driver.findElement(By.cssSelector("div[data-tableid=\"SpeedAutoRo00001\"]"));
            PokerDomRouletteStrikeAlert alert9 = new PokerDomRouletteStrikeAlert(driver, alertElement9, 9);
            WebElement alertElement10 = driver.findElement(By.cssSelector("div[data-tableid=\"01rb77cq1gtenhmo\"]"));
            PokerDomRouletteStrikeAlert alert10 = new PokerDomRouletteStrikeAlert(driver, alertElement10, 10);
            WebElement alertElement11 = driver.findElement(By.cssSelector("div[data-tableid=\"f1f4rm9xgh4j3u2z\"]"));
            PokerDomRouletteStrikeAlert alert11 = new PokerDomRouletteStrikeAlert(driver, alertElement11, 11);
            WebElement alertElement12 = driver.findElement(By.cssSelector("div[data-tableid=\"q0a470up68p2b81p\"]"));
            PokerDomRouletteStrikeAlert alert12 = new PokerDomRouletteStrikeAlert(driver, alertElement12, 12);
            WebElement alertElement13 = driver.findElement(By.cssSelector("div[data-tableid=\"lr6t4k3lcd4qgyrk\"]"));
            PokerDomRouletteStrikeAlert alert13 = new PokerDomRouletteStrikeAlert(driver, alertElement13, 13);
            WebElement alertElement14 = driver.findElement(By.cssSelector("div[data-tableid=\"mrpuiwhx5slaurcy\"]"));
            PokerDomRouletteStrikeAlert alert14 = new PokerDomRouletteStrikeAlert(driver, alertElement14, 14);
            WebElement alertElement15 = driver.findElement(By.cssSelector("div[data-tableid=\"k2ony5km7jjaayyd\"]"));
            PokerDomRouletteStrikeAlert alert15 = new PokerDomRouletteStrikeAlert(driver, alertElement15, 15);

            /**
             * Старт инициализированных нитей для сбора информации с каждого отдельного окна
             */
            alert1.start();
            alert2.start();
            alert3.start();
            alert4.start();
            alert5.start();
            //alert6.start();
            alert7.start();
            alert8.start();
            alert9.start();
            alert10.start();
            alert11.start();
            alert12.start();
            alert13.start();
            alert14.start();
            alert15.start();


            alert1.join();
            alert2.join();
            alert3.join();
            alert4.join();
            alert5.join();
            //alert6.join();
            alert7.join();
            alert8.join();
            alert9.join();
            alert10.join();
            alert11.join();
            alert12.join();
            alert13.join();
            alert14.join();
            alert15.join();

            /**
             *  При появлении алерта о превышении времени бездействия нити завершают работу,
             *  после чего страница перезагружается и нити снова возобновляют свою работу.
             */
            driver.get(driver.getCurrentUrl());
            System.gc();
        }
    }

    public WebDriver switchTo2ndiframe(WebDriver driver) {
        driver.switchTo().defaultContent();
        WebElement iframe = driver.findElement(By.cssSelector("iframe[class=\"game__frame\"]"));
        System.out.println(1);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        System.out.println(2);
        iframe = driver.findElement(By.cssSelector("iframe.game-iframe"));
        System.out.println(3);
        driver.switchTo().frame(iframe);
        return driver;
    }
}
