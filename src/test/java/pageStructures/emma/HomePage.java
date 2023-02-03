package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import starter.IdCalculator;

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
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
    }

    public void alertCountry(){
        waitForElementVisibility(findElement(SystemConstants.BY_ID,
                "cdk-overlay-0"));

    }

    public void createNewClient(){
        btnNC = findElement(SystemConstants.BY_XPATH, "(//span[contains(text(),'NEW CREDIT APP')])[2]");
        waitForUrl("https://credits-uat.unicomer.com/#/");
        doAction(SystemConstants.PA_CLICK, btnNC);
        //navigateTo("https://credits-uat.unicomer.com/#/product-credit-qualification");
    }

    public void clickLoan(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "(//span[contains(text(),' Loan quoter ')])[2]"));
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
    }

    public void searchTrnValidation(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@id='inputDoc']"), IdCalculator.getInstance().getTRN());
    }

    public void clickSearchTrn(){
        try {
            doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                    "//span[contains(text(),' Search ')]"));
        }catch(NoSuchElementException e){
            doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                    "//span[contains(text(),'CHECK')]"));
        }

    }

    public void waitApproveBox(){
        try {
            //waitForElementVisibility(findElement(SystemConstants.BY_XPATH, "//*[contains(text(),'Cancel')]"));
            doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                    "//*[contains(text(),'Cancel')]"));
        }catch(NoSuchElementException e){

        }
    }

}
