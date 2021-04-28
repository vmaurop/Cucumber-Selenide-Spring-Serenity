package com.vmaurop.bdd.stepdefs.home;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.home.HomeActionsUI;
import com.vmaurop.bdd.api.GoogleAPI;
import com.vmaurop.bdd.questions.home.HomeQuestionsUI;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;


public class MainMenuStepDefs extends AbstractSerenityClass {

    @Steps
    private HomeActionsUI homeActionsUI;

    @Steps
    HomeQuestionsUI homeQuestionsUI;

    @Steps
    GoogleAPI googleAPI;


    @Then("the user views google application")
    public void theUserViewsGoogleApplication() {
        homeQuestionsUI.verifyTittleGoogle();
    }


    @And("make a fake call request")
    public void makeAFakeCallRequest() {
        googleAPI.fakeRequest();
    }

    @And("verify call request")
    public void verifyCallRequest() {
        googleAPI.verifyResponse();
    }
}
