// create feature file for ess.
// use @Tag annotation to tag the feature file as ess.
// The feature file should be named ESS.feature.
// The feature file should contain scenarios for employee self service (ESS) application.
// write scenarios for the following functionalities:
// 1. Login
// 2. View Timesheet
// 3. Apply Timesheet
// 4. Submit Timesheet
// 5. Logout.
Feature: Employee Self Service (ESS) Application

  Scenario: Login to ESS
    Given the user is on the ESS login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the ESS dashboard

  Scenario: View Timesheet
    Given the user is logged in to the ESS application
    When the user navigates to the timesheet section
    Then the user should see their current timesheet

  Scenario: Apply Timesheet
    Given the user is on the timesheet page
    When the user selects a date range and enters work hours
    And clicks the apply button
    Then the timesheet should be updated with the new entries

  Scenario: Submit Timesheet
    Given the user has filled out their timesheet
    When the user clicks the submit button
    Then a confirmation message should be displayed indicating successful submission

  Scenario: Logout from ESS
    Given the user is logged in to the ESS application
    When the user clicks on the logout button
    Then the user should be redirected to the ESS login page
