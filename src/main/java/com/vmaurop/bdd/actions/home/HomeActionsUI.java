package com.vmaurop.bdd.actions.home;


import com.codeborne.selenide.Selenide;
import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.api.GoogleAPI;
import com.vmaurop.bdd.configuration.GoogleConfig;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeActionsUI extends AbstractSerenityClass implements HomeActions {

    @Steps
    GoogleAPI googleAPI;

    @Autowired
    GoogleConfig googleConfig;


    @Steps
    private HomeActionsUI homeActionsUI;


    @Step
    public void openApp(String applicationName) {
        switch (applicationName) {
            case "Google":
                Selenide.open("https://www.google.com/");
                break;
            default:
                throw new IllegalArgumentException("There is no app name:" + applicationName);
        }
        Serenity.takeScreenshot();
    }

}
