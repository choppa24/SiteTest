package testCases;

import framework.base.BaseTest;
import framework.utils.ConfigUtility;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsAndFramePage;
import pages.HomePage;

import java.util.Set;

public class TestCase4 extends BaseTest {
    private final int SCROLL_X = 0;
    private final int SCROLL_Y = 250;

    @Test
    public void test(){
        LoggerUtility.info("\nTESTCASE4");
        LoggerUtility.info("Step1: Перейти на главную страницу");
        LoggerUtility.info("Открытие главной страницы");
        DriverUtility.get((ConfigUtility.getStringValue("url")));
        HomePage homePage = new HomePage();
        LoggerUtility.info("Проверка уникального элемента страницы Homepage");
        Assert.assertTrue(homePage.isUniqueElementDisplayed(), "No unique element found for homePage.");
        homePage.closeAd();

        LoggerUtility.info("Step2: Кликнуть на кнопку Alerts, Frame & Windows.\n" +
                "На открывшейся странице в левом меню кликнуть пункт Browser Windows");
        try {
            homePage.clickAlertsButton();
        }
        catch (Exception e){
            LoggerUtility.error("Не удалось нажать конопку 'Alerts, Frame & Windows' ");
        }
        LoggerUtility.info("Создание страницы Alerts");
        AlertsAndFramePage alertsAndFramePage = new AlertsAndFramePage();
        Assert.assertTrue(alertsAndFramePage.isUniqueElementDisplayed(), "No unique element found for AlertsAndFramePage.");
        alertsAndFramePage.clickBrowserWindowButton();
        String parentHandle = DriverUtility.getWindowHandle();
        Set<String> beforeWindowsSet = DriverUtility.getWindowHandles();

        LoggerUtility.info("Step3: Кликнуть на кнопку New Tab");
        alertsAndFramePage.clickTabButton();
        Set<String> afterWindowsSet = DriverUtility.getWindowHandles();
        afterWindowsSet.removeAll(beforeWindowsSet);
        String newWindow = afterWindowsSet.iterator().next();
        DriverUtility.switchTo().window(newWindow);
        String actualUrl = DriverUtility.getCurrentUrl();
        Assert.assertTrue(actualUrl.endsWith("/sample"),"");

        LoggerUtility.info("Step4: Закрыть текущую вкладку");
        DriverUtility.close();
        DriverUtility.switchTo().window(parentHandle);
        actualUrl = DriverUtility.getCurrentUrl();
        Assert.assertTrue(actualUrl.endsWith("/browser-windows"), "");

        LoggerUtility.info("Step5: В левом меню выбрать Elements → Links");
        alertsAndFramePage.clickElementsButton();
        DriverUtility.scrolling(SCROLL_X, SCROLL_Y);
        alertsAndFramePage.clickLinksButton();
        Assert.assertTrue(alertsAndFramePage.isLinksForm(),"Links form not open");

        LoggerUtility.info("Step6: Перейти по ссылке Home");
        parentHandle = DriverUtility.getWindowHandle();
        beforeWindowsSet = DriverUtility.getWindowHandles();
        alertsAndFramePage.clickHomeLink();
        afterWindowsSet = DriverUtility.getWindowHandles();
        afterWindowsSet.removeAll(beforeWindowsSet);
        newWindow = afterWindowsSet.iterator().next();
        DriverUtility.switchTo().window(newWindow);
        actualUrl = DriverUtility.getCurrentUrl();
        Assert.assertTrue(actualUrl.endsWith("demoqa.com/"),"home page not open");

        LoggerUtility.info("Step7: Переключиться на прошлую вкладку");
        DriverUtility.switchTo().window(parentHandle);
        actualUrl = DriverUtility.getCurrentUrl();
        Assert.assertTrue(actualUrl.endsWith("links"),"Links page not open");
    }
}
