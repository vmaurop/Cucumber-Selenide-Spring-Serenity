package com.vmaurop.bdd.stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.home.HomeActionsUI;
import com.vmaurop.bdd.configuration.GoogleConfig;
import com.vmaurop.bdd.configuration.GoogleConfig.Users;
import com.vmaurop.bdd.configuration.ResourcesConfig;
import com.vmaurop.bdd.context.ScenariosContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import java.io.File;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import utils.Files;

import java.io.IOException;
import java.util.Properties;


public class GeneralStepDefs extends AbstractSerenityClass {

    @Steps
    HomeActionsUI homeActionsUI;

    @Shared
    ScenariosContext scenariosContext;

    @Steps
    ResourcesConfig resourcesConfig;

    @Steps
    GoogleConfig googleConfig;

    @Before
    public void beforeAll() throws IOException {
        File file = new File(resourcesConfig.getEnvironmentProperties());
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        GoogleConfig configObject = objectMapper.readValue(file, GoogleConfig.class);
        setConfigProperties(configObject);
    }

    private void setConfigProperties(GoogleConfig config){
        googleConfig.setUrl(config.getUrl());
        googleConfig.setUrlAPI(config.getUrlAPI());
        googleConfig.setUsers(config.getUsers());
    }

    @Before("@UI")
    public void setupUI() throws IOException {
        Properties properties =  Files.readProperties("serenity.properties");
        Configuration.browser = properties.getProperty("webdriver.driver");
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
        Selenide.closeWebDriver();
    }



}
