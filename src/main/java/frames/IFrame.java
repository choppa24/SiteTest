package frames;

import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.openqa.selenium.By;

public class IFrame  {
    private By locator;
    private String name;

    public IFrame(By locator, String name){
        this.locator = locator;
        this.name = name;
    }

    public void switchToFrame(){
        LoggerUtility.info("Переход на frame " + name);
        DriverUtility.switchToFrame(locator);
    }

    public static void outOfFrame(){
        LoggerUtility.info("Переход основной контент");
        DriverUtility.switchToDefault();
    }

}