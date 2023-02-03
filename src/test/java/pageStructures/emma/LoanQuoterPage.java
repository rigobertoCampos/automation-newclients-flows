package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoanQuoterPage extends PageAction {

    public void insertAmount(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_ID,
                "amount"), "12000");
    }

    public void noCpi(){
        //doAction(SystemConstants.PA_CLICK, );
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();",
                (WebElement) findElement(SystemConstants.BY_XPATH,
                        "(//input[@type='radio'])[2]"));
    }

    public void clickToCheck(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),'CHECK CLIENT')]"));
    }

    public void generateLoan(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "button-calculate-loan"));
    }

    public void waitLoanAlert(){
        waitElementOnScreen(findElement(SystemConstants.BY_XPATH,"//app-alert-credit-status"));
    }

}
