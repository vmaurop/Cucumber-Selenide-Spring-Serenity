package com.vmaurop.bdd.context;

import com.vmaurop.bdd.AbstractSerenityClass;

public class ScenariosContext extends AbstractSerenityClass {
    private boolean uiTest;

    public boolean isUiTest() {
        return uiTest;
    }

    public void setUiTest(boolean uiTest) {
        this.uiTest = uiTest;
    }


}
