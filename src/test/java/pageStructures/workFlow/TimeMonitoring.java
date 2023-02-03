package pageStructures.workFlow;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import starter.IdCalculator;

public class TimeMonitoring extends PageAction {
    
    //901121037
    public void searchByDocument(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
        doAction(SystemConstants.PA_CLICK,
                findElement(SystemConstants.BY_XPATH,
                        "//mat-select[@test-id='search-by-dwpn']"));
    }

    public void selectDocument(){
        try {
            doAction(SystemConstants.PA_CLICK,
                    findElement(SystemConstants.BY_XPATH,
                            "//span[contains(text(),'Document')]"));
        }catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException toe){
            searchByDocument();
            selectDocument();
        }

    }

    public void enterDocument(){
        doAction(SystemConstants.PA_SEND_KEYS,
                findElement(SystemConstants.BY_XPATH,
                        "//input[@test-id='search-txt']"),
                IdCalculator.getInstance().getTRN());
    }

    public void clickSearch(){
        doAction(SystemConstants.PA_CLICK,
                findElement(SystemConstants.BY_XPATH,
                        "//button[@test-id='search-btn']"));

        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
    }

    public void selectRequest(){
        doAction(SystemConstants.PA_CLICK,
                findElement(SystemConstants.BY_XPATH,
                        "(//*[@test-id='reassign-all-checkbox'])[2]"));
    }

    public void assignRequest(){
        doAction(SystemConstants.PA_CLICK,
                findElement(SystemConstants.BY_XPATH,
                        "//button[@test-id='reassign-btn']"));
    }

    public void selectUser(){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();",
                (WebElement) findElement(SystemConstants.BY_XPATH,
                        "//table[@test-id='assing-tbl']//input[@value='application.admin@unicomer.com']"));

    }

    public void confirmBtn(){
        doAction(SystemConstants.PA_CLICK,
                findElement(SystemConstants.BY_XPATH,
                        "//button[@test-id='modal-action-btn']"));
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
    }

}
