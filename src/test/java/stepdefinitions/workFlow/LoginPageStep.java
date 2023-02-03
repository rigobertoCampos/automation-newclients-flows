package stepdefinitions.workFlow;

import net.thucydides.core.annotations.Step;
import pageStructures.workFlow.LoginPage;

public class LoginPageStep {
    LoginPage login;

    @Step("Navigate To WorkFlow webApp")
    public void navigateWF(){
        login.navigateToWorkFlow();
    }

    @Step("Set admin user credentials")
    public void setCredentials(){
        login.setUserName();
        login.setPassword();
        login.sendCredentials();
    }
}
