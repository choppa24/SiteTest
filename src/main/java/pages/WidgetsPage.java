package pages;

import elements.Button;
import elements.Input;
import elements.Label;
import elements.Slider;
import framework.base.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class WidgetsPage extends BaseForm {
    private final int MAX_NUMBER_OF_ITERATION = 1000;
    private final Label slidersPageLabel = new Label(By.xpath("//div[@class='main-header' and contains(text(),'Slider')]"),
            "uniqueElement from SliderPage");
    private final Label progressBarPageLabel = new Label(By.xpath("//div[@class='main-header' and contains(text(),'Progress Bar')]"),
            "uniqueElement from ProgressBarPage");
    private final Slider slider = new Slider(By.xpath("//div[@id='sliderContainer']//span/input"), "uniqueElement from Slider");
    private final Input sliderValue = new Input(By.id("sliderValue"), "uniqueElement from SliderValue");
    private final Button sliderButton = new Button(By.xpath("//li/span[contains(text(),'Slider')]"), "sliderButton");
    private final Button progressBarButton = new Button(By.xpath("//li/span[contains(text(),'Progress Bar')]"), "Progress Bar Button");
    private final Button startStopButton = new Button(By.xpath("//button[@id='startStopButton']"),"Start and stop Button");
    private final Label progressBarLabel = new Label(By.xpath("//div[@id='progressBar']/div"),
            "uniqueElement from Progress Bar");

    public WidgetsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Widgets')]"), "uniqueElement from WidgetsPage"), "WidgetsPage");
    }

    public boolean isSliders(){
        return slidersPageLabel.isDisplayed();
    }

    public boolean isProgressBar(){
        return progressBarPageLabel.isDisplayed();
    }

    public void setSliders(int i){
        int actualValue = Integer.parseInt(slider.getAttribute("value"));
        int counter = 0;
        if (actualValue < i){
            while (actualValue < i && counter <= MAX_NUMBER_OF_ITERATION)
            {
                counter++;
                slider.sendStringKey(Keys.ARROW_RIGHT);
                actualValue = Integer.parseInt(slider.getAttribute("value"));
            }
        }
        else {
            while (actualValue > i && counter <= MAX_NUMBER_OF_ITERATION )
            {
                counter++;
                slider.sendStringKey(Keys.ARROW_LEFT);
                actualValue = Integer.parseInt(slider.getAttribute("value"));
            }
        }
    }

    public void clickSliders() {
        sliderButton.click();
    }

    public void clickStartStopButton() {
        startStopButton.click();
    }

    public void clickStartStopButton(int age) {
        int actualValue = Integer.parseInt(progressBarLabel.getAttribute("aria-valuenow"));
        int counter = 0;
        while (actualValue < age && counter <= MAX_NUMBER_OF_ITERATION ){
            counter++;
            actualValue = Integer.parseInt(progressBarLabel.getAttribute("aria-valuenow"));
        }
        clickStartStopButton();
    }

    public int getProgressBarValue(){
        return Integer.parseInt(progressBarLabel.getAttribute("aria-valuenow"));
    }

    public void clickProgressBarButton(){
        progressBarButton.click();
    }

    public int getSliderValue(){
        return Integer.parseInt(sliderValue.getAttribute("value"));
    }
}
