package com.vmaurop.bdd.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/features/"},
        monochrome = true,
        tags = {"(not @security) and (@UI or (not @UI and not @API))"},
        glue = {"com.vmaurop.bdd.stepdefs"})
public class TestRunner { }