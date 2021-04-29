package com.vmaurop.bdd.ui.home;


import org.openqa.selenium.By;

public final class MainMenu {

    private MainMenu() {
        throw new IllegalStateException("TopMenu class");
    }


    public static final By HEADER_GOOGLE = By.xpath("//title[text()='Google']");
    public static final By ACCEPT_PERSONAL_DATA = By.xpath("(//button//div[@role='nodddne'])[2]");

}