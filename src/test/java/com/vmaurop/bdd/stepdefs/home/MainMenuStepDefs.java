package com.vmaurop.bdd.stepdefs.home;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.home.HomeActionsUI;
import com.vmaurop.bdd.questions.home.HomeQuestionsUI;
import net.thucydides.core.annotations.Steps;


public class MainMenuStepDefs extends AbstractSerenityClass {

    @Steps
    private HomeActionsUI homeActionsUI;

    @Steps
    HomeQuestionsUI homeQuestionsUI;


}
