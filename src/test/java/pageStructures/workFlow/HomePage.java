package pageStructures.workFlow;

import constants.SystemConstants;
import helpers.PageAction;

public class HomePage extends PageAction {

    public void selectCountry(String country){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID
                ,"mat-select-0"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH
                ,"//span[contains(text(),' "+country+" ')]"));
    }

    public void selectLanguage(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID
                ,"mat-select-2"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH
                ,"//span[contains(text(),' English ')]"));
    }

    public void selectMenu(String menu){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH
                ,"(//div[contains(text(),'"+menu+"')])[1]"));
        isElementOnScreen(findElement(SystemConstants.BY_XPATH, "//*[@test-id='spinner-component']"));
    }

}
