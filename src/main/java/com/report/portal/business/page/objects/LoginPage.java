package com.report.portal.business.page.objects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage setLogin(String login) {
        $(By.name("login")).setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(By.name("password")).setValue(password);
        return this;
    }

    public BasePage submit() {
        $(By.cssSelector("button")).click();
        return new BasePage();
    }

}