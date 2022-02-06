package pages;

import elements.Button;
import elements.Image;
import framework.base.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {
    private final Button alertsAndFrameButton = new Button(By.xpath("//h5[contains(text(),'Alerts, Frame')]//parent::div"),
            "alertsAndFrameButton");
    private final Button adCloseButton = new Button(By.id("close-fixedban"), "adCloseButton");

    private final Button elementsButton = new Button(By.xpath("//h5[contains(text(),'Elements')]//parent::div"),
            "elementsButton");
    private final Button widgetsButton = new Button(By.xpath("//h5[contains(text(),'Widgets')]//parent::div"),
            "widgetsButton");

    public HomePage() {
        super(new Image(By.className("banner-image"),
                "uniqueElement from HomePage"), "Home Page");
    }

    public void closeAd() {
        adCloseButton.click();
    }

    public void clickAlertsButton() {
        alertsAndFrameButton.click();
    }

    public void clickElementsButton() {
        elementsButton.click();
    }

    public void clickWidgetsButton() {
        widgetsButton.click();
    }



}
