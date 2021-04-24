package com.vmaurop.bdd.stepdefs.login;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.actions.login.LoginActionsUI;
import com.vmaurop.bdd.configuration.GoogleConfig;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginStepDefs extends AbstractSerenityClass {

    @Autowired
    private GoogleConfig googleConfig;

    @Steps
    private LoginActionsUI loginActionsUI;



}
