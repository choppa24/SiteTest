package testCases;

import framework.base.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.WidgetsPage;

public class TestCase5 extends BaseTest {
    private final double FAULT = 2;
    private final int MAX_VALUE_FROM_RANDOM = 100;
    private final int SCROLL_X = 0;
    private final int SCROLL_Y = 250;

    @Test
    public void test(){

        LoggerUtility.info("Step1: Перейти на главную страницу");
        LoggerUtility.info("Открытие главной страницы");
        DriverUtility.get((ConfigUtility.getStringValue("url")));
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUniqueElementDisplayed(), "No unique element found for homePage.");
        try {
            homePage.closeAd();
        }
        catch (Exception e){
            LoggerUtility.error("Не удалось закрыть рекламу");
        }

        LoggerUtility.info("Step2: Кликнуть на кнопку Widgets. В левом меню выбрать пункт Slider");
        homePage.clickWidgetsButton();
        WidgetsPage widgetsPage = new WidgetsPage();
        DriverUtility.scrolling(SCROLL_X, SCROLL_Y);
        Assert.assertTrue(widgetsPage.isUniqueElementDisplayed(), "No unique element found for WidgetsPage.");
        widgetsPage.clickSliders();
        Assert.assertTrue(widgetsPage.isSliders(), "Page Sliders not open");

        LoggerUtility.info("Step3: Установить слайдеру корректное случайно сгенерированное значение");
        int valueForSlider = RandomUtility.getRandomInt(MAX_VALUE_FROM_RANDOM);
        widgetsPage.setSliders(valueForSlider);
        Assert.assertEquals(widgetsPage.getSliderValue(), valueForSlider, "Slider value does not match");

        LoggerUtility.info("Step4: В левом меню выбрать пункт Progress Bar");
        DriverUtility.scrolling(SCROLL_X, SCROLL_Y);
        widgetsPage.clickProgressBarButton();
        Assert.assertTrue(widgetsPage.isProgressBar(), "Page Progress Bar not open");

        LoggerUtility.info("Step5: Нажать на кнопку Start.");
        widgetsPage.clickStartStopButton();

        LoggerUtility.info("Step6: Нажать на кнопку Stop, когда на полосе загрузки появится значение," +
                " равное возрасту инженера, выполняющего задание");
        int age = TestUtility.getIntValue("myAge");
        widgetsPage.clickStartStopButton(age);
        Assert.assertTrue((widgetsPage.getProgressBarValue() + FAULT >= age) &&  (widgetsPage.getProgressBarValue() - FAULT <= age),
                "The value on the load bar does not match the age of the engineer");

    }
}
