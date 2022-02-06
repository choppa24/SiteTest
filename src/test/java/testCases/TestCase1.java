

package testCases;

import framework.base.BaseTest;
import framework.utils.*;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsAndFramePage;
import pages.HomePage;

public class TestCase1 extends BaseTest {
    private final int LENGTH = 15;

    @Test
    public void test() {
        LoggerUtility.info("TESTCASE1");
        LoggerUtility.info("Step1: Перейти на главную страницу ");
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
        alertsAndFramePage.clickAlerts();
        Assert.assertTrue(alertsAndFramePage.isAlerts(), "Page Alerts not open");

        LoggerUtility.info("Step3: Нажать на кнопку Click Button to see alert ");
        alertsAndFramePage.clickSeeAlertButton();
        Assert.assertEquals(AlertUtility.getTextToAlert(),"You clicked a button",
                    "the wrong alert is open.");

        LoggerUtility.info("Step4: Нажать на кнопку OK ");
        AlertUtility.acceptAlert();


        LoggerUtility.info("Step5: Нажать на кнопку On button click, confirm box will appear");
        alertsAndFramePage.clickConfirmBoxButton();
        Assert.assertEquals(AlertUtility.getTextToAlert(),"Do you confirm action?",
                    "the wrong alert is open.");

        LoggerUtility.info("Step6: Нажать на кнопку OK ");
        AlertUtility.acceptAlert();

        Assert.assertTrue(alertsAndFramePage.isDisplayedSpan(), "span 'You selected Ok' not displayed");

        LoggerUtility.info("Step7: Нажать на кнопку 'On button click, prompt box will appear'");
        alertsAndFramePage.clickPromptBoxButton();
        Assert.assertEquals(AlertUtility.getTextToAlert(),"Please enter your name",
                "the wrong alert is open.");

        LoggerUtility.info("Step8: Ввести случайно сгенерированный текст, нажать на кнопку OK");
        String name = RandomUtility.getRandomString(LENGTH);
        AlertUtility.sendKeysToAlert(name);
        AlertUtility.acceptAlert();
        Assert.assertTrue(alertsAndFramePage.getInputName().endsWith(name) ,
                "the names do not match");
    }
}
