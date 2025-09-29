#create feature file for ess.
#use @Tag annotation to tag the feature file as ess.
# The feature file should be named ESS.feature.
# The feature file should contain scenarios for employee self service (ESS) application.
# write scenarios for the following functionalities:
# 1. Login
# 2. View Timesheet
# 3. Apply Timesheet
# 4. Submit Timesheet
# 5. Logout.
Feature: Employee Self Service (ESS) Application

  Background: Login to ESS
    Given User is on the ESS login page
    When User enters valid username and password
    And User clicks on the login button
    #Then User should be redirected to the ESS dashboard

  @TimeSheet
  Scenario: Create and submit timesheet
    When the user navigates to the timesheet section
    And Clicks on Create new Timesheet
    And selects the current date and fill all details
    And User clicks on add and save
    And User reviews the timesheet
    And User submits the timesheet
    Then Verify submitted message






