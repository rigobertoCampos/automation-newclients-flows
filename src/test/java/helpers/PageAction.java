package helpers;

import constants.SystemConstants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PageAction extends PageObject {

    private String keys;
    private int actionTries = 1;

    private WebElement tempPath;

    public WebElementFacade findElement(String opt, String value){
        switch (opt){
            case SystemConstants.BY_ID:
                //WebElement e = getDriver().findElement(By.id("sd"));
               return $(By.id(value));
            case SystemConstants.BY_NAME:
                return $(By.name(value));
            case SystemConstants.BY_XPATH:
                return $(By.xpath(value));
            case SystemConstants.BY_LEFT_SELECTOR:
                return (WebElementFacade) getDriver().findElement(with(By.xpath(value)).toLeftOf(tempPath));
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
            //actionTries = 0;
        }catch (StaleElementReferenceException | ElementClickInterceptedException e){
            if(actionTries > 4){
                actionTries = 0;
                return;
            }else{
                //System.out.println("NO SALIMOS DEL COUNT");
                actionTries = actionTries + 1;
                doAction(opt,element);
            }
        }
    }

    public void doAction(String opt, WebElementFacade element, String keys){
        this.keys = keys;
        doAction(opt, element);
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

    public void waitForUrl(String url){
        try {
            waitForCondition().until(ExpectedConditions.urlContains(url));
        }catch (TimeoutException e){
            navigateTo(url);
        }

    }

    public void waitForElementVisibility(WebElementFacade element){
        try {
            element.waitUntilVisible();
        }catch (TimeoutException e){
            return;
        }
    }

    public boolean isElementOnScreen(WebElementFacade element){
        try {
            System.out.println("pilas ---------------------------------> " + element.isDisplayed());
            if(element.isDisplayed()){
                return isElementOnScreen(element);
            }
            else return false;
        }catch (StaleElementReferenceException | NoSuchElementException e){
            return false;
        }
    }

    public boolean waitElementOnScreen(WebElementFacade element){
        try {
            System.out.println(element.isDisplayed() + " ---------------------------------------");
            if(!element.isDisplayed()){
                waitElementOnScreen(element);
            }
            return true;
        }catch (StaleElementReferenceException | NoSuchElementException e){
            return waitElementOnScreen(element);
        }
    }

    public void setTempPath(WebElement tempPath) {
        this.tempPath = tempPath;
    }
}
