package elements;

import framework.base.BaseElement;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Slider extends BaseElement {

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void sendStringKey(Keys keys){
        LoggerUtility.info("Сдвиг слайдера" + name);
        waitForPresent();
        DriverUtility.findElement(this.locator).sendKeys(keys);
    }
}
