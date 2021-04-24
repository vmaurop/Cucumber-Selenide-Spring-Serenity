package com.vmaurop.bdd.stepdefs;

import com.codeborne.selenide.Configuration;
import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.home.HomeActionsUI;
import com.vmaurop.bdd.context.ScenariosContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;


public class GeneralStepDefs extends AbstractSerenityClass {
    @Managed
    WebDriver driver;

    @Steps
    private HomeActionsUI homeActionsUI;

    @Shared
    private ScenariosContext scenariosContext;

    @Before("@UI")
    public void setupUI() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = true;
    }

    @Before("@API")
    public void setupAPI() {

    }

    @Given("the user opens the (.+) application")
    public void theUserOpensApplication(String applicationName) {
        homeActionsUI.openApp(applicationName);
    }

    @After("@UI")
    public void tearDownUI() {

    }



}
