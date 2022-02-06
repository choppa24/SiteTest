package pages;

import additional.User;
import elements.Button;
import elements.Input;
import elements.Label;
import framework.base.BaseForm;
import framework.utils.LoggerUtility;
import framework.utils.TestUtility;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    private final Button webTablesButton = new Button(By.xpath("//li/span[contains(text(),'Web Tables')]"), "alertsButton");
    private final Label  webTablesLabel  = new Label(By.xpath("//div[@class='main-header' and contains(text(),'Web Tables')]"),
            "uniqueElement from WebTables");
    private final Button addButton = new Button(By.xpath("//button[@id='addNewRecordButton']"), "addButton");
    private final Label registrationLabel = new Label(By.xpath("//div[text()='Registration Form']"), "RegLabel");
    private final Input firstNameInput = new Input(By.id("firstName"), "First Name Input");
    private final Input lastNameInput = new Input(By.id("lastName"), "Last Name Input");
    private final Input emailInput = new Input(By.id("userEmail"), "User Email Input");
    private final Input ageInput = new Input(By.id("age"), "Age Input");
    private final Input salaryInput = new Input(By.id("salary"), "Salary Input");
    private final Input departmentInput = new Input(By.id("department"), "Department Input");
    private final Button submitButton = new Button(By.id("submit"),"Submit button");
    private Label nameLabel;
    private final Button deleteButton = new Button(By.xpath("(//span[@title='Delete'])[last()]"),"Delete button");
    private String sampleLocator = "((//span[@title='Delete'])[last()]//ancestor::div[@class='rt-tr-group'])//div[text()='";

    public ElementsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"), "uniqueElement from AlertsAndFramePage"), "AlertsAndFramePage");
    }

    public void clickWebTables() {
        webTablesButton.click();
    }

    public boolean isWebTables(){
        return webTablesLabel.isDisplayed();
    }

    public void clickAddButton(){
        addButton.click();
    }

    public boolean isRegistrationLabel(){
        return registrationLabel.isDisplayed();
    }

    public void inputData(User user){
        LoggerUtility.info("Ввод тестовых данных.");
        firstNameInput.sendStringKey(user.getFirstName());
        lastNameInput.sendStringKey(user.getLastName());
        emailInput.sendStringKey(user.getEmail());
        ageInput.sendStringKey(user.getAge());
        salaryInput.sendStringKey(user.getSalary());
        departmentInput.sendStringKey(user.getDepartment());

    }

    public void submitButtonClick(){
        submitButton.click();
    }

    public boolean isDataInput(String checkField){
        nameLabel = new Label(By.xpath(sampleLocator + checkField + "']"), "First name field");
        return nameLabel.isDisplayed();
    }

    public void deleteButtonClick(){
        deleteButton.click();
    }

    public boolean isUserDelete(String checkField){
        nameLabel = new Label(By.xpath(sampleLocator + checkField + "']"), "First name field");
        try{
            return (!nameLabel.isDisplayed());
        }
        catch (Exception e){
            return true;
        }
    }

}
