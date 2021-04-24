package com.vmaurop.bdd.questions.home;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.api.GoogleAPI;
import net.thucydides.core.annotations.Steps;

public class HomeQuestionsUI extends AbstractSerenityClass implements HomeQuestions {

    @Steps
    GoogleAPI googleAPI;

}
