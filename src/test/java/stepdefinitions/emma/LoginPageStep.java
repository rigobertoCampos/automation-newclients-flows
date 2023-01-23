package stepdefinitions.emma;

import net.thucydides.core.annotations.Step;
import pageStructures.emma.LoginPage;

public class LoginPageStep {
    LoginPage loginPage;

    @Step("Open browser on Emma web app")
    public void openEmma(){
        loginPage.openBrowser();
        loginPage.navigateToEmma();
        loginPage.clickLogin();
    }

    @Step("Login to Emma web app")
    public void loginEmma(){
        loginPage.setUserName();
        loginPage.sendCredentials();
        loginPage.setPassword();
        loginPage.sendCredentials();
    }

    @Step("Confirm session")
    public void confirmEmma(){
        loginPage.sendCredentials();
    }
}
