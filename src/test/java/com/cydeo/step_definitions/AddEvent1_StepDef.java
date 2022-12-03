package com.cydeo.step_definitions;

import com.cydeo.pages.AddEvent2Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AddEvent1_StepDef {
    AddEvent2Page addEvent2Page = new AddEvent2Page();

    @Then("Verify that compulsory fields are shown as below:")
    public void verifyThatCompulsoryFieldsAreShownAsBelow(List<String> fields) {
        Assert.assertEquals(fields, addEvent2Page.getCompulsoryFields());
    }

    @And("Verify that user shouldn't be able to add an event without filling the compulsory fields")
    public void verifyThatUserShouldnTBeAbleToAddAnEventWithoutFillingTheCompulsoryFields() {

    }

    @And("Verify that user shouldn't be able to add an event without filling the {string} fields")
    public void verifyThatUserShouldnTBeAbleToAddAnEventWithoutFillingTheFields(String fields) {
        addEvent2Page.fillField(fields);
        addEvent2Page.waitUntilLoaderScreenDisappear();

    }

    @Then("Verify that {string} message is displayed")
    public void verifyThatMessageIsDisplayed(String message) {
        Assert.assertEquals(message, addEvent2Page.errorMessage.getText());
    }
}
