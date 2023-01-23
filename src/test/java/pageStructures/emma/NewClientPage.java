package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewClientPage extends PageAction {

    WebElementFacade inputTrn, inputName;

    public void insertTRN(){
        inputTrn = findElement(SystemConstants.BY_ID, "inputDoc");
        doAction(SystemConstants.PA_SEND_KEYS, inputTrn, "100056789");
    }

    public void sendTRN(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "button-form-credit-validation"));
    }

    public void waitToLoad(){
        inputName = findElement(SystemConstants.BY_XPATH, "//input[@formcontrolname='firstName']");
        waitForElementVisibility(inputName);
    }

    public void firsName(){
        inputName = findElement(SystemConstants.BY_XPATH, "//input[@formcontrolname='firstName']");
        waitForElementVisibility(inputName);
        doAction(SystemConstants.PA_SEND_KEYS, inputName,"Rigoberto");
    }

    public void middleName(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='middleName']"),"Berto");
    }

    public void lastName(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='lastName']"),"Campos");
    }

    public void secondLastName(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='secondLastName']"),"Vega");
    }

    public void phoneNumber(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='phone']"),"112233444");
    }

    public void email(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='email']"),"c12233444@mail.com");
    }

    public void birthDate(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='dateOfBirth']"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//div[text()=' 1 '])[1]"));

    }

    public void sendData(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID,"button-form-credit-evaluate"));
    }

    public void successFully(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "preApprovedOk"));
    }

    public void selectGender(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Male')]"));
    }
    public void selectCountryOrigin(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Bahamas')]"));
    }
    public void selectMarriedStatus(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Common Law')]"));
    }
    public void selectPaymentFreq(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[4]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Weekly')]"));
    }

    public void numberDependents(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH, "(//input)[1]"), "2");
    }

    public void netIncome(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH, "(//input)[2]"), "900000");
    }

    public void homeAddress(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH, "//textarea"),
                "Address Address Address Address Address 10");
    }

    public void submitInfo(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "button-form-credit-qualification"));
    }

    public void confirmAll(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(text(),'CONFIRM INCOME')]"));
    }

    public void selectOccupation(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Fisherman')]"));
    }

    public void monthsWorkIn(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[4]"),"20");
    }

    public void selectEconomyAct(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Familiar H')]"));
    }

    public void selectPP(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[text()=' No ']"));
    }

    public void selectParish(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Hanover')]"));
    }

    public void selectDistrict(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Ramble')]"));
    }

    public void selectResidentStatus(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Rent')]"));
    }

    public void currentAddress(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[1]"),"22");
    }
}
