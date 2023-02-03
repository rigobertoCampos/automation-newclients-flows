package pageStructures.workFlow;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import starter.ConstantReader;

public class LoginPage extends PageAction {

    WebElementFacade btnLogin, btnSubmit;
    WebElementFacade userName, password;

    public void navigateToWorkFlow(){
        navigateTo(ConstantReader.getInstance().getProperties().get(SystemConstants.WORKF_URL));
    }

    public void setUserName(){
        try {
            userName = findElement(SystemConstants.BY_ID, "username");
            doAction(SystemConstants.PA_SEND_KEYS, userName,
                    ConstantReader.getInstance().getProperties().get(SystemConstants.WORKF_USERNAME));
        }catch (org.openqa.selenium.NoSuchElementException e){
            navigateToWorkFlow();
        }

    }

    public void setPassword(){
        password = findElement(SystemConstants.BY_ID, "password");
        doAction(SystemConstants.PA_SEND_KEYS, password,
                ConstantReader.getInstance().getProperties().get(SystemConstants.WORKF_PASSWORD));
    }

    public void sendCredentials(){
        btnSubmit = findElement(SystemConstants.BY_ID, "kc-login");
        doAction(SystemConstants.PA_CLICK, btnSubmit);
    }


}
