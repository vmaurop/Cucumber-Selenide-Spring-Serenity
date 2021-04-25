package com.vmaurop.bdd.questions.home;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.api.GoogleAPI;
import com.vmaurop.bdd.ui.home.MainMenu;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HomeQuestionsUI extends AbstractSerenityClass implements HomeQuestions {

    @Steps
    GoogleAPI googleAPI;


    public void verifyTittleGoogle() {
        Assert.assertTrue($(MainMenu.HEADER_GOOGLE).exists());
    }
}
