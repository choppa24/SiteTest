package framework.base;

import framework.utils.ConfigUtility;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseElement {
    protected By locator;
    protected String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        LoggerUtility.info("Проверка интерактивности элемента: " + name);
        this.waitForPresent();
        return DriverUtility.findElements(this.locator).size() >0;
    }

    public void click() {
        LoggerUtility.info("Клик по элементу: " + name);
        this.waitForPresent();
        DriverUtility.findElement(this.locator).click();
    }

    public String getText() {
        LoggerUtility.info("Получение текста элемента: " + name);
        this.waitForPresent();
        return DriverUtility.findElement(this.locator).getText();
    }

    public String getAttribute(String name) {
        LoggerUtility.info("Вывод текста элемента: " + name);
        this.waitForPresent();
        return DriverUtility.findElement(this.locator).getAttribute(name);
    }

    public void waitForPresent() {
        WebDriverWait wait = new WebDriverWait(DriverUtility.getDriver(), ConfigUtility.getIntValue("explicitTime"));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
