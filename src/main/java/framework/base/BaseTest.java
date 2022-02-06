package framework.base;

import framework.utils.ConfigUtility;
import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import framework.utils.TestUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void initialization() {
        ConfigUtility.setMyUtility();
        TestUtility.setTestUtility();
    }

    @BeforeMethod
    public void setDriver() {
        DriverUtility.setDriver();
    }

    @AfterMethod
    public void quit(){
        LoggerUtility.info("Закрытие драйвера");
        DriverUtility.quit();
        DriverUtility.refresh();
    }
}
