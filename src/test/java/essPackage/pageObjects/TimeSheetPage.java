package essPackage.pageObjects;

import essPackage.ApplicationHooks.BaseClass;
import essPackage.utils.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;

public class TimeSheetPage extends BaseClass {
    WebDriver driver;
    UtilityClass utils;

    public TimeSheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new UtilityClass(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Timesheet']")
    WebElement timeSheet;

    @FindBy(xpath = "//span[normalize-space()='Start Creating Timesheet']")
    WebElement createBtn;

    @FindBy(id = "dateTemplate")
    WebElement calander;

    @FindBy(xpath = "//table[@class='p-datepicker-calendar']")
    List<WebElement> datePicker;

    @FindBy(id = "timesheetCategory")
    WebElement category;
    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> categoryList;

    @FindBy(xpath = "//span[normalize-space()='Select Activity']")
    WebElement activity;
    @FindBy(className = "p-dropdown-items")
    List<WebElement> activityList;

    @FindBy(id = "timesheetHours")
    WebElement hours;

    @FindBy(xpath = "//span[normalize-space()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//span[normalize-space()='Save & Review']")
    WebElement saveAndReview;

    @FindBy(xpath = "//div[@role='alert']//*[contains(normalize-space()," +
            "'Timesheet created successfully')]")
    WebElement successMSG;

    @FindBy(css = ".p-checkbox-box.p-component")
    WebElement checkBox;

    @FindBy(xpath = "//span[normalize-space()='Save & Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@role='alert']//*[normalize-space()=" +
            "'Your Timesheet has been shared with Love Dhaka for approval']")
    WebElement submittedMSG;

    public void navigateToTimeSheet() {
        utils.WaitForElement(timeSheet);
        timeSheet.click();
    }

    public void createNewTimeSheet() {
        utils.WaitForElement(createBtn);
        createBtn.click();
    }

    public void clickOnCalender() {
        utils.WaitForElement(calander);
        calander.click();

        utils.waitForFreshElements(datePicker);
        String currentDate = String.valueOf(LocalDate.now().getDayOfMonth());

        for (WebElement date : datePicker) {
            if (date.getText().trim().equals(currentDate) && date.isEnabled()) {
                date.click();
                break;
            }
        }

    }

    public void selectCategory() {
        utils.WaitForElement(category);
        category.click();

        String select = prop.getProperty("Category");
        List<WebElement> options = utils.waitForElementList(categoryList);

        for (WebElement option : options) {
            String text = option.getText();
            System.out.println("Option:\n" + text);
            if (text.equalsIgnoreCase(select)) {
                utils.waitForElementToBeClickable(option);
                option.click();
                break;
            }
        }

    }

    public void selectActivity() {

        utils.WaitForElement(activity);
        activity.click();

        String selectActivity = prop.getProperty("Activity");
        utils.waitForElementList(activityList);
        for (WebElement choose : activityList) {
            System.out.println("chhose: " + choose.getText());
            if (choose.getText().trim().equalsIgnoreCase(selectActivity)) {
                utils.waitForElementList(activityList);
                choose.click();
                break;
            }
        }
    }

    public void workingHours() {
        utils.WaitForElement(hours);
        hours.click();
        hours.sendKeys("8");
    }

    public void addAndSaveTimeSheet() {
        utils.WaitForElement(addButton);
        addButton.click();

        utils.WaitForElement(saveAndReview);
        saveAndReview.click();
    }

    public void veryFyAlert() {
        utils.WaitForElement(successMSG);
        String actualText = successMSG.getText();
        String expectedText = "Timesheet created successfully";
        Assert.assertTrue(actualText.contains("successfully") || actualText.contains
                ("created"), "Alert message mismatch! Found: " + actualText);
    }

    public void SelectBox() {
        utils.WaitForElement(checkBox);
        checkBox.click();
    }

    public void submitTimeSheet() {
        utils.WaitForElement(submitBtn);
        submitBtn.click();
    }
    public  void veryFySubmit(){
        utils.WaitForElement(submittedMSG);
        String actualMassage = submittedMSG.getText();
        Assert.assertTrue(actualMassage.contains("Timesheet has been shared")
                ,"Alert message mismatch! Found:" +actualMassage);
    }

}
