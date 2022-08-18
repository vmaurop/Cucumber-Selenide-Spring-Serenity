package com.vmaurop.bdd.actions.home;


import com.codeborne.selenide.Selenide;
import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.api.GoogleAPI;
import com.vmaurop.bdd.configuration.GoogleConfig;
import com.vmaurop.bdd.ui.home.MainMenu;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomeActionsUI extends AbstractSerenityClass implements HomeActions {

    @Steps
    GoogleAPI googleAPI;

    @Steps
    GoogleConfig googleConfig;


    @Steps
    HomeActionsUI homeActionsUI;


    public void openApp(String applicationName) {
        switch (applicationName) {
            case "Google":
                Selenide.open(googleConfig.getUrl());
                acceptAgreementPersonalData();
                break;
            default:
                throw new IllegalArgumentException("There is no app name:" + applicationName);
        }
        Serenity.takeScreenshot();
    }


    public void acceptAgreementPersonalData() {
        $(MainMenu.ACCEPT_PERSONAL_DATA).waitUntil(visible, 3000);
        $(MainMenu.ACCEPT_PERSONAL_DATA).click();
    }

}
