package testCases;

import additional.User;
import framework.base.BaseTest;
import framework.utils.ConfigUtility;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import framework.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class TestCase3 extends BaseTest {

    @Test
    public void test(){
        LoggerUtility.info("\nTESTCASE3");
        LoggerUtility.info("Step1: Перейти на главную страницу ");
        LoggerUtility.info("Открытие главной страницы");
        DriverUtility.get((ConfigUtility.getStringValue("url")));
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUniqueElementDisplayed(), "No unique element found for homePage.");
        homePage.closeAd();

        LoggerUtility.info("Step2: Кликнуть на кнопку Elements.\n" +
                "На открывшейся странице в левом меню кликнуть пункт Web Tables");
        homePage.clickElementsButton();
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.clickWebTables();
        Assert.assertTrue(elementsPage.isWebTables(), "Page WebTables not open");

        LoggerUtility.info("Step3: Кликнуть на кнопку Add");
        elementsPage.clickAddButton();
        Assert.assertTrue(elementsPage.isRegistrationLabel(),"Registration form not open");

        LoggerUtility.info("Step4: Ввести данные пользователя User № из таблицы  и затем нажать на кнопку Submit");
        User user1 =  new User("Jon","Show","knownothing@gmail.com","30","3000","alpha");
        User user2 =  new User("Buttercup","Cumbersnatch","BudapestCandygram@mail.ru",
                "41","2000","beta");
        elementsPage.inputData(user1);
        elementsPage.submitButtonClick();
        Assert.assertTrue(elementsPage.isDataInput(user1.getFirstName()),"user is not entered in the table");

        LoggerUtility.info("Step5: Нажать на кнопку Delete в строке  пользователя User № ");
        elementsPage.deleteButtonClick();
        Assert.assertTrue(elementsPage.isUserDelete(user1.getFirstName()),"user is not removed from the table");
    }
}
