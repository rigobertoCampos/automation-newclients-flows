package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.concurrent.TimeoutException;

public class HomePage extends PageAction {
    WebElementFacade selectCountry, btnContinue;
    WebElementFacade btnNC;

    public void selectCountry(){
        selectCountry = findElement(SystemConstants.BY_ID, "mat-select-0");
        doAction(SystemConstants.PA_CLICK,selectCountry);
    }

    public void setCountry(String country){
         try {
             doAction(SystemConstants.PA_CLICK,
                     findElement(SystemConstants.BY_XPATH,
                             "//span[contains(text(),'"+country+"') and @class='mat-option-text']"));
         }catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException toe){
             selectCountry();
             setCountry(country);
         }
    }

    public void clickContinue(){
        btnContinue = findElement(SystemConstants.BY_XPATH, "//span[contains(text(),'CONTINU')]");
        doAction(SystemConstants.PA_CLICK, btnContinue);
    }

    public void alertCountry(){
        waitForElementVisibility(findElement(SystemConstants.BY_ID,
                "cdk-overlay-0"));

    }

    public void createNewClient(){
        btnNC = findElement(SystemConstants.BY_XPATH, "(//span[contains(text(),'NEW CREDIT APP')])[2]");
        waitForElementVisibility(btnNC);
        //doAction(SystemConstants.PA_CLICK, btnNC);
        navigateTo("https://credits-uat.unicomer.com/#/product-credit-qualification");
    }

}
