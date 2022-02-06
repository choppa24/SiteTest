package framework.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertUtility {

    public static Alert switchToAlert(){
        LoggerUtility.info("Переключение на алерт");
        waitAlertPresent();
        return DriverUtility.switchTo().alert();
    }

    public static void acceptAlert(){
        LoggerUtility.info("Accept алерт");
        switchToAlert().accept();
    }

    public static void dismissAlert(){
        LoggerUtility.info("Cancel алерт");
        switchToAlert().dismiss();
    }
    public static void sendKeysToAlert(String text){
        LoggerUtility.info("Ввод текста в алерт");
        switchToAlert().sendKeys(text);
    }
    public static String getTextToAlert(){
        LoggerUtility.info("Получение текста из алерта");
        return switchToAlert().getText();
    }

    public static void waitAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverUtility.getDriver(), ConfigUtility.getIntValue("explicitTime"));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
