Feature: Calculator App performs basic addition operation
  As a user of the Calculator App
  I want to be able to add two integer values and receive the correct result

  Background: I am on the calculator screen
    Given : User is on the calculator screen

  Scenario 1: Addition of two positive integers
    Given the user enters the first value as 3
    And the user enters the second value as 4
    And I tap on the "Add" button
    Then the result should be displayed as 7

  Scenario 2: Addition of two negative integers
    Given the user enters the first value as -3
    And the user enters the second value as -4
    And I tap on the "Add" button
    Then the result should be displayed as -7

  Scenario 3: Addition of positive and negative integers
    Given the user enters the first value as 3
    And the user enters the second value as -4
    And I tap on the "Add" button
    Then the result should be displayed as -1

  Scenario 4: Add a valid integer and a decimal number
    Given I am on the calculator screen
    When the user enters the first value as 2
    And the user enters the second value as 3.1
    And I tap on the "Add" button
    Then I should see an error message "Only Integers are allowed" in the result text field

  Scenario 6: Add two decimal numbers
    Given I am on the calculator screen
    When the user enters the first value as 2.1
    And the user enters the second value as 3.1
    And I tap on the "Add" button
    Then I should see an error message "Only Integers are allowed" in the result text field

  Scenario 7: User only enters integer in second text field
    Given I am on the calculator screen
    And the user enters the second value as 3.1
    And I tap on the "Add" button
    Then I should see an error message "One or more fields are empty" in the result text field