package testCases;

import framework.base.BaseTest;
import framework.utils.ConfigUtility;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsAndFramePage;
import pages.HomePage;

public class TestCase2 extends BaseTest {
    private final int FIRST_FRAME = 1;
    private final int SECOND_FRAME = 2;
    private final int THIRD_FRAME = 3;
    private final int FOURTH_FRAME = 4;
    private final int SCROLL_X = 0;
    private final int SCROLL_Y = 250;

    @Test
    public void test(){
        LoggerUtility.info("\nTESTCASE2");
        LoggerUtility.info("Step1: Перейти на главную страницу");
        LoggerUtility.info("Открытие главной страницы");
        DriverUtility.get((ConfigUtility.getStringValue("url")));
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUniqueElementDisplayed(), "No unique element found for homePage.");
        homePage.closeAd();

        LoggerUtility.info("Step2: Кликнуть на кнопку Alerts, Frame & Windows.\n" +
                "На открывшейся странице в левом меню кликнуть пункт Alerts");
        homePage.clickAlertsButton();
        AlertsAndFramePage alertsAndFramePage = new AlertsAndFramePage();
        Assert.assertTrue(alertsAndFramePage.isUniqueElementDisplayed(), "No unique element found for AlertsAndFramePage.");
        DriverUtility.scrolling(SCROLL_X, SCROLL_Y);
        alertsAndFramePage.clickNestedFramesButton();

        Assert.assertEquals(alertsAndFramePage.getLabel( FIRST_FRAME), "Parent frame");
        Assert.assertEquals(alertsAndFramePage.getLabel( SECOND_FRAME), "Child Iframe");

        LoggerUtility.info("Step3: В левом меню выбрать пункт Frames");
        DriverUtility.scrolling(SCROLL_X, SCROLL_Y);
        alertsAndFramePage.clickFramesButton();
        Assert.assertEquals(alertsAndFramePage.getLabel(THIRD_FRAME),alertsAndFramePage.getLabel(FOURTH_FRAME),
                "Iframes labels don't match");
    }
}
