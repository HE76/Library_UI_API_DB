package com.library.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Us02StepDef {
    @Given("Path param is {string}")
    public void path_param_is(String string) {

    }
    @Then("{string} field should be same with path param")
    public void field_should_be_same_with_path_param(String string) {

    }
    @Then("following fields should not be null")
    public void following_fields_should_not_be_null(io.cucumber.datatable.DataTable dataTable) {

    }

}
