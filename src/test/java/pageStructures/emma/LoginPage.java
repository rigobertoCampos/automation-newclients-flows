package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;
import starter.ConstantReader;

public class LoginPage extends PageAction {

    WebElementFacade btnLogin, btnUser, btnSubmit, btnConfirm;
    WebElementFacade userName, password;

    public void navigateToEmma(){
        navigateTo(ConstantReader.getInstance().getProperties().get(SystemConstants.EMMA_URL));
    }
    public void clickLogin(){
        btnLogin = findElement(SystemConstants.BY_ID, "social-ad");
        doAction(SystemConstants.PA_CLICK, btnLogin);
    }

    public void setUserName(){
        userName = findElement(SystemConstants.BY_NAME, "loginfmt");
        doAction(SystemConstants.PA_SEND_KEYS, userName,
                ConstantReader.getInstance().getProperties().get(SystemConstants.EMMA_USERNAME));
    }

    public void setPassword(){
        password = findElement(SystemConstants.BY_XPATH, "//input[@name='passwd' and @aria-required='true']");
        doAction(SystemConstants.PA_SEND_KEYS, password,
                ConstantReader.getInstance().getProperties().get(SystemConstants.EMMA_PASSWORD));
    }

    public void sendCredentials(){
        btnSubmit = findElement(SystemConstants.BY_ID, "idSIButton9");
        doAction(SystemConstants.PA_CLICK, btnSubmit);
    }

}
