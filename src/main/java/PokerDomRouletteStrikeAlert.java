import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PokerDomRouletteStrikeAlert extends Thread {

    WebDriver driver;
    WebElement gameWindow;
    int numberOfThread;

    PokerDomRouletteStrikeAlert(){

    }

    public PokerDomRouletteStrikeAlert(WebDriver driver, WebElement gameWindow, int numberOfThread) {
        this.driver = driver;
        this.gameWindow = gameWindow;
        this.numberOfThread = numberOfThread;
    }

    public void run() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        List<WebElement> webElementsList;
        ArrayList<String> stringsListColor = new ArrayList<String>();
        System.out.println("Thread number " + numberOfThread + " is started.");
        while (true) {

            try {
                /**
                 * Проверка на появления алерта о превышении времени бездействия
                 */
                if (wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("div.box--1AqBW")))) {
                    System.out.println("Thread number " + numberOfThread + " is aborted.");
                    break;
                }
            } catch (Exception e) {
            }

            try {
                /**
                 * В список помещаются доступные из лобби 10 элементов последних выпавших чисел и цветов для выбранного стола
                 */
                webElementsList = (gameWindow.findElements(By.cssSelector("div.recentNumbersContainer--3-f5t div[data-role=\"single-ball-result\"]")));
                for (int i = 0; i < 10; i++) {
                    /**
                     * Из каждого элемента извлекается значение атрибута класса, которое содержит выпавший цвет и переписывается в список строк
                     */
                    stringsListColor.add(i, webElementsList.get(i).getAttribute("class"));
                }

                /**
                 * Происходит проверка на то, что цвет выпавших последних ячеек одинаковый
                 */
                if ((stringsListColor.get(0).contains("red")) && (stringsListColor.get(1).contains("red")) && (stringsListColor.get(2).contains("red"))
                        && (stringsListColor.get(3).contains("red")) && (stringsListColor.get(4).contains("red")) && (stringsListColor.get(5).contains("red"))
                        && (stringsListColor.get(6).contains("red")) && (stringsListColor.get(7).contains("red"))
                    //&& (stringsListColor.get(8).contains("red"))
                        ) {
                    /**
                     * Если в текущем окне игры выпало 8 одинаковых цветов продрят, то проигрывается аудио дорожка
                     */
                    alarm();
                    /**
                     * Затем выводится лог в консоль
                     */
                    System.out.println(numberOfThread + " " + new Date() + "================================ COLOR red");
                    System.out.println(webElementsList.get(0).getAttribute("class") + " " + webElementsList.get(0).getText());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }

                    /**
                     * Происходит проверка на то, что цвет выпавших последних ячеек одинаковый
                     */
                } else if ((stringsListColor.get(0).contains("black")) && (stringsListColor.get(1).contains("black")) && (stringsListColor.get(2).contains("black"))
                        && (stringsListColor.get(3).contains("black")) && (stringsListColor.get(4).contains("black")) && (stringsListColor.get(5).contains("black"))
                        && (stringsListColor.get(6).contains("black")) && (stringsListColor.get(7).contains("black"))
                    //&& (stringsListColor.get(8).contains("black"))
                        ) {
                    /**
                     * Если в текущем окне игры выпало 8 одинаковых цветов продрят, то проигрывается аудио дорожка
                     */
                    alarm();
                    /**
                     * Затем выводится лог в консоль
                     */
                    System.out.println(numberOfThread + " " + new Date() + "================================ COLOR black");
                    System.out.println(webElementsList.get(0).getAttribute("class") + " " + webElementsList.get(0).getText());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                }

                /**
                 * Ожидание нового броска
                 */
                waiter(webElementsList);
                stringsListColor.clear();
                webElementsList.clear();
            } catch (Exception e) {
            }
            stringsListColor.clear();
            System.gc();
        }

    }

    public void waiter(List<WebElement> webElementsList1) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        /**
         * Запись значения всех 10 значений для дальнейшего сравнения
         */
        ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < webElementsList1.size(); i++) {
            list1.add(i, webElementsList1.get(i).getAttribute("class") + " " + webElementsList1.get(i).getText());
        }
        ArrayList<String> list2 = new ArrayList<String>();
        List<WebElement> webElementsList2;

        /**
         * Проверка равен ли изначальный список значений обновленному
         */
        while (true) {

            /**
             * Парсинг новых значений, если они не будут равны старым, то значит выпало новое значение и цикл будет прерван
             */
            webElementsList2 = (gameWindow.findElements(By.cssSelector("div.recentNumbersContainer--3-f5t div[data-role=\"single-ball-result\"]")));
            for (int i = 0; i < webElementsList2.size(); i++) {
                list2.add(i, webElementsList2.get(i).getAttribute("class") + " " + webElementsList2.get(i).getText());
            }

            /**
             * Собственно само сравнение
             */
            if (!list1.equals(list2)) {
                list2.clear();
                break;
            }

            /**
             * Проверка на появления алерта о превышении времени бездействия
             */
            try {
                if (wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("div.box--1AqBW")))) {
                    System.out.println("Thread number " + numberOfThread + " is aborted.");
                    break;
                }
            } catch (Exception e) {
            }
            list2.clear();
        }
    }

    public void alarm() {
        File a = new File(VarData.getTrackAlert());
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(a);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-35);
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
