package pages;

import elements.Button;
import elements.Label;
import frames.IFrame;
import framework.base.BaseForm;
import framework.utils.LoggerUtility;
import org.openqa.selenium.By;

public class AlertsAndFramePage extends BaseForm {
    private final int FIRST_FRAME = 1;
    private final int SECOND_FRAME = 2;
    private final int THIRD_FRAME = 3;
    private final int FOURTH_FRAME = 4;

    private final Button alertsButton = new Button(By.xpath("//li/span[contains(text(),'Alerts')]"), "alertsButton");
    private final Button seeAlertButton = new Button(By.xpath("//span[contains(text(),'Click Button')]//parent::div//following-sibling::div[@class='col']/button"),
            "clickMeButton");
    private final Label  alertsLabel  = new Label(By.xpath("//div[@class = 'main-header' and text()='Alerts']"),
            "uniqueElement from Alerts");
    private final Button confirmBoxButton = new Button(By.xpath("//span[contains(text(),'confirm box')]//parent::div//following-sibling::div[@class='col']/button"),
            "clickMeButton");
    private final Label confirmResult = new Label(By.id("confirmResult"), "You selected Ok");
    private final Button promptBoxButton = new Button(By.xpath("//span[contains(text(),'prompt box')]//parent::div//following-sibling::div[@class='col']/button"),
            "clickMeButton");
    private final Label inputName = new Label(By.xpath("//span[@id='promptResult']"), "input name");
    private final Button nestedFramesButton = new Button(By.xpath("//li/span[contains(text(),'Nested')]"), "nestedFramesButton");
    private final Button framesButton = new Button(By.xpath("//li/span[text()='Frames']"), "framesButton");
    private final IFrame frame3 = new IFrame(By.id("frame1"),"Frame 3");
    private final IFrame frame1 = new IFrame(By.id("frame1"),"Frame 1");
    private final IFrame frame2 = new IFrame(By.xpath("//*[contains(text(),'Parent frame')]//iframe"), "Frame 2");
    private final IFrame frame4 = new IFrame(By.id("frame2"),"Frame 4");
    private final Label label1  = new Label(By.xpath("//*[contains(text(),'Parent frame')]"), "Label from iframe 1");
    private final Label label2  = new Label(By.xpath("//*[contains(text(),'Child Iframe')]"), "Label from iframe 2");
    private final Label label34  = new Label(By.id("sampleHeading"), "Label from iframe 3-4");
    private final Button browserWindowsButton = new Button(By.xpath("//li/span[contains(text(),'Browser Windows')]"), "browserWindowsButton");
    private final Button tabButton = new Button(By.id("tabButton"), "tabButton");
    private final Button elementsButton = new Button(By.xpath("//div[@class ='header-text' and contains(text(),'Elements')]"),
            "elementsButton");
    private final Button linksButton = new Button(By.xpath("//li/span[contains(text(),'Links')]"),
            "linksButton");
    private Label uniqueElementsElement = new Label(By.xpath("//div[@class='main-header' and contains(text(),'Links')]"),
            "uniqueElementsElement" );
    private Label homeLink = new Label(By.id("simpleLink"),
            "homeLink" );
    public AlertsAndFramePage() {
        super(new Label(By.className("main-header"), "uniqueElement from AlertsAndFramePage"), "AlertsAndFramePage");
    }

    public boolean isAlerts(){
        return alertsLabel.isDisplayed();
    }

    public void clickAlerts() {
        alertsButton.click();
    }

    public void clickNestedFramesButton() {
        nestedFramesButton.click();
    }

    public void clickFramesButton(){
        framesButton.click();
    }

    public void clickSeeAlertButton() { seeAlertButton.click(); }

    public void clickConfirmBoxButton(){ confirmBoxButton.click(); }

    public boolean isDisplayedSpan(){
       return confirmResult.isDisplayed();
    }

    public void clickPromptBoxButton(){ promptBoxButton.click();}

    public String getInputName(){
        return inputName.getText();
    }

    public String getLabel(int number){
        String label;
        LoggerUtility.info("Получение тектса из iframe  " + number);
        switch (number){
            case FIRST_FRAME:
                frame1.switchToFrame();
                return label1.getText();
            case SECOND_FRAME:
                frame2.switchToFrame();
                label = label2.getText();
                IFrame.outOfFrame();
                return label;
            case THIRD_FRAME:
                frame3.switchToFrame();
                label = label34.getText();
                IFrame.outOfFrame();
                return label;
            case FOURTH_FRAME:
                frame4.switchToFrame();
                label = label34.getText();
                IFrame.outOfFrame();
                return label;
            default:
                return null;
        }
    }

    public void clickBrowserWindowButton(){
        browserWindowsButton.click();
    }

    public void clickTabButton(){
        tabButton.click();
    }

    public void clickElementsButton(){
        elementsButton.click();
    }

    public void clickLinksButton(){
        linksButton.click();
    }

    public boolean isLinksForm(){ return uniqueElementsElement.isDisplayed();}

    public void clickHomeLink(){ homeLink.click();}
}
