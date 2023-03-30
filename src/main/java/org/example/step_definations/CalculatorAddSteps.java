package org.example.step_definations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorSteps {

    WebDriver driver;

    @Given("User is on the calculator screen")
    public void i_am_on_the_calculator_screen() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.calculator.com/");
    }

    @Given("the user enters the first value as {int}")
    public void the_user_enters_the_first_value_as(Integer firstValue) {
        WebElement firstValueField = driver.findElement(By.id("firstNumber"));
        firstValueField.clear();
        firstValueField.sendKeys(String.valueOf(firstValue));
    }

    @Given("the user enters the second value as {int}")
    public void the_user_enters_the_second_value_as(Integer secondValue) {
        WebElement secondValueField = driver.findElement(By.id("secondNumber"));
        secondValueField.clear();
        secondValueField.sendKeys(String.valueOf(secondValue));
    }

    @Given("the user enters the second value as {double}")
    public void the_user_enters_the_second_value_as(Double secondValue) {
        WebElement secondValueField = driver.findElement(By.id("secondNumber"));
        secondValueField.clear();
        secondValueField.sendKeys(String.valueOf(secondValue));
    }

    @When("I tap on the \"Add\" button")
    public void i_tap_on_the_add_button() {
        WebElement addButton = driver.findElement(By.id("cta"));
        addButton.click();
    }

    @Then("the result should be displayed as {int}")
    public void the_result_should_be_displayed_as(Integer expectedResult) {
        WebElement resultField = driver.findElement(By.id("result"));
        Integer actualResult = Integer.parseInt(resultField.getAttribute("value"));
        assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Then("I should see an error message \"Only Integers are allowed\" in the result text field")
    public void i_should_see_an_error_message_only_integers_are_allowed_in_the_result_text_field() {
        WebElement resultField = driver.findElement(By.id("error"));
        String errorMessage = resultField.getAttribute("value");
        assertTrue(errorMessage.contains("Only Integers are allowed"));
        driver.quit();
    }

    @Then("I should see an error message \"One or more fields are empty\" in the result text field")
    public void i_should_see_an_error_message_one_or_more_fields_are_empty_in_the_result_text_field() {
        WebElement resultField = driver.findElement(By.id("error"));
        String errorMessage = resultField.getAttribute("value");
        assertTrue(errorMessage.contains("One or more fields are empty"));
        driver.quit();
    }

}
