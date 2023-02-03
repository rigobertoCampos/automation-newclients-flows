package pageStructures.workFlow;

import constants.SystemConstants;
import helpers.PageAction;
import starter.IdCalculator;

public class RequestTracking extends PageAction {

    public void searchByTRN(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@test-id='searchWorking-txt']"), IdCalculator.getInstance().getTRN());
    }

    public void clickSearch(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//button[@test-id='searchWorking-Btn']"));
    }

    public void clickOnRequest(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//button[@test-id='requestNumber-Btn']"));
    }

    public void saveData(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
        System.out.println("NUMERO DE VECES QUE ENTRAMOS A SAVE");
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//button[@test-id='saveVerified-btn']"));
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
    }

    public void generalInfo(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//*[@test-id='menu-dwpn']"));
    }

    public void selectResolve(String opt){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),' "+opt+" ')]"));
    }

    public void clickStatus(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//mat-select[@test-id='newStatus-dpw']"));
    }

    public void dataVerification(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),' Data verification ')]"));
    }

    public void subStatus(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//*[@test-id='subStatus-dpw']"));
    }

    public void dataValidation(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),' Data validation process ')]"));
    }

    public void selectApproved(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),' Approved ')]"));
    }

    public void saveChange(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//button[@test-id='saveNewStatus-btn']"));
    }

}
