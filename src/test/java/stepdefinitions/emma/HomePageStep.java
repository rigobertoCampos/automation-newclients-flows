package stepdefinitions.emma;

import net.thucydides.core.annotations.Step;
import pageStructures.emma.HomePage;

public class HomePageStep {
    HomePage hp;

    @Step("Select a country")
    public void selectCountry(String country){
        hp.alertCountry();
        hp.selectCountry();
        hp.setCountry(country);
        hp.clickContinue();
    }

    @Step("Click to go new client page")
    public void createNewClient(){
        hp.createNewClient();
    }
}
