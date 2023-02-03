package pageStructures.emma;

import constants.SystemConstants;
import helpers.PageAction;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.InvalidElementStateException;
import starter.IdCalculator;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class NewClientPage extends PageAction {

    WebElementFacade inputTrn, inputName;

    public void insertTRN(){
        inputTrn = findElement(SystemConstants.BY_ID, "inputDoc");
        waitForElementVisibility(inputTrn);
        doAction(SystemConstants.PA_SEND_KEYS, inputTrn, IdCalculator.getInstance().getTRN());
    }

    public void sendTRN(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "button-form-credit-validation"));
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
    }

    public void waitToLoad(){
        inputName = findElement(SystemConstants.BY_XPATH, "//input[@formcontrolname='firstName']");
        waitForElementVisibility(inputName);
    }

    public void firsName(){
        inputName = findElement(SystemConstants.BY_XPATH, "//input[@formcontrolname='firstName']");
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
        doAction(SystemConstants.PA_SEND_KEYS, inputName,"Rigoberto");
        System.out.println();
        if(!inputName.getAttribute("value").contains("Rigoberto")){
            firsName();
        }
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
                "//input[@formcontrolname='email']"),"m"+IdCalculator.getInstance().getTRN() + "@mail.com");
    }

    public void birthDate(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//input[@formcontrolname='dateOfBirth']"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//*[contains(@aria-describedby,'mat-calendar-button-')])[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//div[text()=' 1990 '])[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//div[contains(text(),' JAN')])[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//div[text()=' 1 '])[1]"));

    }

    public void sendData(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID,"button-form-credit-evaluate"));
    }

    public void successFully(){
        isElementOnScreen(findElement(SystemConstants.BY_XPATH,
                "//*[contains(text(),'Loading...')]"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "preApprovedOk"));
    }

    public void selectGender(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Male')]"));
    }
    public void selectCountryOrigin(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Jamaica')]"));
    }
    public void selectMarriedStatus(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Married')]"));
    }
    public void selectPaymentFreq(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[4]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"(//*[contains(text(),' Monthly ')])[2]"));
    }

    public void numberDependents(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH, "(//input)[1]"), "2");
    }

    public void netIncome(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH, "(//input)[2]"), "1200000");
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
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Business O')]"));
    }

    public void monthsWorkIn(){
        try {
            doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[4]"),"120");
        }catch (InvalidElementStateException e){
            doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[1]"),"120");
        }

    }

    public void selectEconomyAct(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Salary')]"));
    }

    public void selectDateWork(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//input[@aria-haspopup='dialog']"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,
                "//span[contains(@id,'mat-calendar-button-')]"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,"//div[contains(text(),'2010')]"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,"//div[contains(text(),'JAN')]"));
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,"//div[contains(text(),' 1 ')]"));
    }

    public void selectPP(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[text()=' No ']"));
    }

    public void selectParish(String region){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[1]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'"+region+"')]"));
    }

    public void  employerName(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                        "(//input)[2]"),
                    "Rigo Berto Cam");
    }

    public void workAddress(){
        doAction(SystemConstants.PA_SEND_KEYS,
                findElement(SystemConstants.BY_XPATH,
                        "(//textarea)[1]"),
                IdCalculator.getInstance().getTRN());
    }

    public void  workNumber(){
        doAction(SystemConstants.PA_SEND_KEYS, findElement(SystemConstants.BY_XPATH,
                        "(//input)[3]"),
                IdCalculator.getInstance().getTRN());
    }

    public void selectDistrict(String region){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[2]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'"+region+"')]"));
    }

    public void selectResidentStatus(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH, "(//mat-select)[3]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//*[contains(text(),'Owner')]"));
    }

    public void currentAddress(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[1]"),"122");
    }

    public void contactName(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[1]"),"Rigoberto Campos");
    }

    public void contactNameAruba(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[3]"),"Rigoberto Campos V");
    }

    public void contactNumber(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[2]"),"8122334");
    }

    public void contactNumberAruba(){
        doAction(SystemConstants.PA_SEND_KEYS,findElement(SystemConstants.BY_XPATH,"(//input)[4]"),"7122334");
    }

    public void uploadFile(String optFile){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_XPATH,"//span[contains(text(),'"+optFile+"')]"));
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//span[contains(text(),'Upload Document')]"));
        StringSelection str = new StringSelection("C:\\Users\\rigoberto_campos\\OneDrive - Grupo Unicomer Unicomer Group\\Imágenes\\dni.PNG");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }catch(AWTException e){

        }

    }

    public void sendAllData(){
        doAction(SystemConstants.PA_CLICK,findElement(SystemConstants.BY_XPATH,"//span[contains(text(),'NEXT')]"));
    }

    public void waitingResponse(){
        doAction(SystemConstants.PA_CLICK, findElement(SystemConstants.BY_ID, "button-credit-app-waiting-response"));
    }

}
