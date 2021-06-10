package com.vmaurop.bdd.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/features/"},
        monochrome = true,
        tags = {"@TC-UI-EXAMPLE-001"},
        glue = {"com.vmaurop.bdd.stepdefs"})
public class TestRunner { }