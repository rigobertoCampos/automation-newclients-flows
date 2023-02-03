package stepdefinitions.workFlow;

import net.thucydides.core.annotations.Step;
import pageStructures.workFlow.HomePage;

public class HomePageStep {
    HomePage hp;

    @Step("Select country in Workflow web app")
    public void selectCountry(String country){
        hp.selectCountry(country);
    }

    @Step("Select language in Workflow web app")
    public void selectLanguage(){
        hp.selectLanguage();
    }

    @Step("Choose menu")
    public void selectMenu(String menu){
        hp.selectMenu(menu);
    }

}
