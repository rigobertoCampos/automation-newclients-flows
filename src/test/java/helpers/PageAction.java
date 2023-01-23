package helpers;

import constants.SystemConstants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageAction extends PageObject {

    private String keys;
    private int actionTries = 1;

    public WebElementFacade findElement(String opt, String value){
        switch (opt){
            case SystemConstants.BY_ID:
               return $(By.id(value));
            case SystemConstants.BY_NAME:
                return $(By.name(value));
            case SystemConstants.BY_XPATH:
                return $(By.xpath(value));
            default:
                return null;
        }
    }

    public void doAction(String opt, WebElementFacade element){
        try{
            centerElement(element);
            switch (opt){
                case SystemConstants.PA_CLICK:
                    clickElement(waitForClick(element));
                    break;
                case SystemConstants.PA_SEND_KEYS:
                    setText(element, this.keys);
                    break;
            }
            actionTries = 0;
        }catch (StaleElementReferenceException e){
            if(actionTries > 5){
                actionTries = 0;
                return;
            }else{
                actionTries = actionTries + 1;
                doAction(opt,element);
            }
        }
    }

    public void doAction(String opt, WebElementFacade element, String keys){
        this.keys = keys;
        doAction(opt, element);
    }



    public void openBrowser(){
        getDriver().manage().window().maximize();
    }

    public void navigateTo(String url){
        getDriver().navigate().to(url);
    }

    private void setText(WebElementFacade element, String text){
        element.type(text);
    }

    private void clickElement(WebElementFacade element){
        element.click();
    }

    private void centerElement(WebElementFacade element){
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);
    }

    private WebElementFacade waitForClick(WebElementFacade element){
        return (WebElementFacade)waitForCondition().until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    public void waitForElementVisibility(WebElementFacade element){
        try {
            waitForTextToAppear("Loading...");
            waitForCondition().until(
                    ExpectedConditions.visibilityOf(element)
            ).isDisplayed();
            waitForTextToDisappear("Loading...");
        }catch (TimeoutException e){
            return;
        }
    }
}
