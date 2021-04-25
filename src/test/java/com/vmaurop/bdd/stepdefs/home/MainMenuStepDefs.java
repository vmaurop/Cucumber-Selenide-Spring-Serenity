package com.vmaurop.bdd.stepdefs.home;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.home.HomeActionsUI;
import com.vmaurop.bdd.questions.home.HomeQuestionsUI;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;


public class MainMenuStepDefs extends AbstractSerenityClass {

    @Steps
    private HomeActionsUI homeActionsUI;

    @Steps
    HomeQuestionsUI homeQuestionsUI;


    @Then("the user views google application")
    public void theUserViewsGoogleApplication() {
        homeQuestionsUI.verifyTittleGoogle();
    }


}
