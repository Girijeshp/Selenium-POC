package essPackage.stepDefinitions;

import essPackage.ApplicationHooks.BaseClass;
import essPackage.pageObjects.TimeSheetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TimeSheetFeature extends BaseClass {
    TimeSheetPage timeSheet;

    @When("the user navigates to the timesheet section")
    public void the_user_navigates_to_the_timesheet_section() {
        timeSheet = new TimeSheetPage(driver);
        timeSheet.navigateToTimeSheet();
    }

    @And("Clicks on Create new Timesheet")
    public void clicks_on_Create_new_Timesheet() {
        timeSheet.createNewTimeSheet();
    }

    @And("selects the current date and fill all details")
    public void selects_the_current_date_and_fill_all_details() {
        timeSheet.clickOnCalender();
        timeSheet.selectCategory();
        timeSheet.selectActivity();
        timeSheet.workingHours();
    }

    @And("User clicks on add and save")
    public void user_clicks_on_add_and_save() {
        timeSheet.addAndSaveTimeSheet();
    }

    @And("User reviews the timesheet")
    public void user_reviews_the_timesheet() {
        timeSheet.veryFyAlert();
        timeSheet.SelectBox();
    }

    @And("User submits the timesheet")
    public void user_submits_the_timesheet() {
        timeSheet.submitTimeSheet();
    }

    @And("Verify submitted message")
    public void verify_submitted_message() {

        timeSheet.veryFySubmit();

    }

}
