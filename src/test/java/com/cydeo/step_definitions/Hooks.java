package com.cydeo.step_definitions;

/*
We'll be able to pass pre & post-conditions  to each senario and each step.
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    // import @Before from io.cucumber.java not from junit
   /* @Before(order = 0)// This method will be implemented to every scenario, because there is no specification.
   public void setupScenario() {
        // We can create methods like this
        System.out.println("==== Setting up browser using cucumber @Before");
    }

    */

   /* @Before(value = "@Login", order = 1) // This method will be implemented only to scenarios having @Login tag.
    public void setupScenarioForLogin() {
        // We can create methods like this
        System.out.println("==== This will only be applied to the scenarios having @Login tag----------  ");
    }

    */

   /* @Before(value = "@db", order = -1) // This method will be implemented only to scenarios having @db tag.// @student
    public void setupForDatabaseScenarios() {
        // We can create methods like this
        System.out.println("====***** This will only be applied to the scenarios having @db tag ******-------  ");
    }

    */


    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed(); if the test fails, this condition becomes true.
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After ");
        //System.out.println("====Scenario ended, take screen shots if failed!");
    }

  /*  @BeforeStep
    public void setupStep() {
        System.out.println("---------------Applying setup using @BeforeStep---------------");

    }

   // @AfterStep
    public void afterStep() {
        System.out.println("---------------Applying teardown using @AfterStep---------------");
    }

   */


}
