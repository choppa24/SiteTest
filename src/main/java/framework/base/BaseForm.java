package framework.base;

import framework.utils.DriverUtility;
import framework.utils.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;

public abstract class BaseForm {
    private BaseElement uniqueElement;
    protected String name;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isUniqueElementDisplayed() {
        LoggerUtility.info("Проверка уникального элемента формы: " + name);
        return this.uniqueElement.isDisplayed();
    }


}
