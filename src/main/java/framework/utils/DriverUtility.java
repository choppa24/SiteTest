package framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverUtility {
    private static WebDriver driver = null;
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static FirefoxOptions firefoxOptions = new FirefoxOptions();

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver() {
        if (driver == null)  {
            String browserName = ConfigUtility.getStringValue("browserName");
            switch (browserName){
                case "Chrome":
                    chromeOptions.addArguments(ConfigUtility.getStringValue("windowSize"));
                    chromeOptions.addArguments(ConfigUtility.getStringValue("browserLanguage"));
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "Firefox":
                    firefoxOptions.addArguments(ConfigUtility.getStringValue("windowSize"));
                    firefoxOptions.addArguments(ConfigUtility.getStringValue("browserLanguage"));
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(chromeOptions);
                    break;
                default:
                    LoggerUtility.error("Неправильное название браузера!");
                    throw new RuntimeException();
            }
            driver.manage().timeouts().implicitlyWait(ConfigUtility.getIntValue("pauseTime"),
                    TimeUnit.MILLISECONDS);
        }
    }

    public static void scrolling(int x, int y ){
        try {
            LoggerUtility.info("Скролл формы: ");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy("+ x + "," + y +")", "");
        }
        catch (Exception e){
            LoggerUtility.error("Скролл формы не удался");
        }

    }

    public static WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public static void quit(){
        LoggerUtility.info("Зактрытие браузера.");
        driver.quit();
    }

    public static void get(String url){
        LoggerUtility.info("Открытие браузера. Переход по ссылке");
        driver.get(url);
    }

    public static String getWindowHandle(){
        LoggerUtility.info("Получение дискриптора страницы");
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandles(){
        LoggerUtility.info("Получение дискрипторов страниц");
        return driver.getWindowHandles();
    }

    public static String getCurrentUrl(){
        LoggerUtility.info("Получение URL страницы");
        return driver.getCurrentUrl();
    }

    public static void close(){
        LoggerUtility.info("Зактрытие окна.");
        driver.close();
    }

    public static void refresh(){
        LoggerUtility.info("Обнуление драйвера");
        driver = null;
    }

    public static WebDriver.TargetLocator switchTo(){
        LoggerUtility.info("Переключение");
        return driver.switchTo();
    }

    public static void switchToFrame(By locator){
        LoggerUtility.info("Переключение в фрейм");
        driver.switchTo().frame(findElement(locator));
    }

    public static void switchToDefault(){
        switchTo().defaultContent();
    }
}
