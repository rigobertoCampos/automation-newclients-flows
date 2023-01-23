package testSuites.scenarios;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import stepdefinitions.emma.HomePageStep;
import stepdefinitions.emma.LoginPageStep;
import stepdefinitions.emma.NewClientPageStep;

public class NewClientScenarios {
    @Steps
    LoginPageStep loginPage;

    @Steps
    HomePageStep homePage;

    @Steps
    NewClientPageStep newClientPage;

    @When("Login in Emma")
    public void loginEmma(){
        loginPage.openEmma();
        loginPage.loginEmma();
        loginPage.confirmEmma();
    }

    @Then("Select {string} country")
    public void selectCountry(String country){
        homePage.selectCountry(country);
    }

    @Then("Create new client")
    public void newClient(){
        homePage.createNewClient();
    }

    @Then("Complete new client information")
    public void newClientInfo(){
        newClientPage.insertTRN();
        newClientPage.personalInfo();
        newClientPage.personalInfoPayment();
        newClientPage.personalWorkInfo();
        newClientPage.geographicInfo();
    }
}
