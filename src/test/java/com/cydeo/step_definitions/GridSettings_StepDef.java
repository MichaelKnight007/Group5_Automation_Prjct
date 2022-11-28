package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.GridSettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class GridSettings_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();
    GridSettingsPage gridSettingsPage = new GridSettingsPage();
    @And("The user clicks on Grid Settings button from the top right menu")
    public void theUserClicksOnButtonFromTheTopRightMenu() {
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarsPage.clickGridSettings();
    }

    @Then("Grid Settings menu shows up")
    public void gridSettingsMenuShowsUp() {
        allCarsPage.verifyGridSettingsMenuDisplayed();
    }

    @Then("Grid Settings list options are as listed below")
    public void grid_settings_list_options_are_as_listed_below(List<String> expectedOptions) {
        List<String> actualOptions = gridSettingsPage.getAllGridSettingsOptions();
        System.out.println("actual options....: " + actualOptions);
        System.out.println("expected options..: " + expectedOptions);
        Assert.assertEquals(expectedOptions, actualOptions);
    }
    @When("The user types following column names into quick search field")
    public void the_user_types_following_column_names_into_quick_search_field(List<String> columns) {
        gridSettingsPage.findCollumn(columns);
    }
    @Then("The relevant column shows up in the grid settings")
    public void the_relevant_column_shows_up_in_the_grid_settings() {
        //there is nothing inside this method,
        //because the previous method also does assertion inside it
        //This situation is kind of limitation of Cucumber
        //Sometimes scenarios can not be divided
    }
    @When("The user clicks on the following columns from grid settings")
    public void the_user_clicks_on_the_following_columns_from_grid_settings(List<String> columns) {
        gridSettingsPage.deselectAllColumns();
        gridSettingsPage.clickColumn(columns);
    }
    @Then("The relevant column shows up in the fleet - vehicles table")
    public void the_relevant_column_shows_up_in_the_fleet_vehicles_table() {
        //there is nothing inside this method,
        //because the previous method also does assertion inside it
        //This situation is kind of limitation of Cucumber
        //Sometimes scenarios can not be divided
    }
    @When("The user can drag {string} column and drop to the index {int}")
    public void the_user_can_drag_column_and_drop_to_the_index(String column, Integer index) {
        gridSettingsPage.dragAndDrop(column,index);
    }
    @Then("{string} column is positioned at index {int}")
    public void column_is_positioned_at_index(String column, Integer index) {
        gridSettingsPage.verifyColumnPosition(column,index);
    }
}
