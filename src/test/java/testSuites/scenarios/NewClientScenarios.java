package testSuites.scenarios;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import stepdefinitions.emma.HomePageStep;
import stepdefinitions.emma.LoanQuoterStep;
import stepdefinitions.emma.NewClientPageStep;
import stepdefinitions.workFlow.LoginPageStep;
import stepdefinitions.workFlow.RequestTrackingStep;
import stepdefinitions.workFlow.TimeMonitoringStep;

public class NewClientScenarios {
    @Steps
    stepdefinitions.emma.LoginPageStep loginPage;

    @Steps
    HomePageStep homePage;

    @Steps
    NewClientPageStep newClientPage;

    @Steps
    LoginPageStep loginWF;

    @Steps
    stepdefinitions.workFlow.HomePageStep homePageWF;

    @Steps
    RequestTrackingStep request;

    @Steps
    LoanQuoterStep loan;

    @Steps
    TimeMonitoringStep monitoring;

    @When("Login into Emma")
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

    @Then("Complete client personal information")
    public void newClientInfo(){
        newClientPage.insertTRN();
        newClientPage.personalInfo();
        newClientPage.personalInfoPayment();
        newClientPage.personalWorkInfo();
    }

    @Then("Complete client region information from {string} {string} {string}")
    public void regionInformation(String country, String region1, String region2){
        newClientPage.geographicInfo(region1, region2);
        newClientPage.contactInfo(country);
        newClientPage.filesInfo();
    }

    @When("Login into WorkFlow")
    public void loginWorkFlow(){
        loginWF.navigateWF();
        loginWF.setCredentials();
    }

    @Then("Select {string} country in WorkFlow")
    public void countryWorkFlow(String country){
        homePageWF.selectCountry(country);
        homePageWF.selectLanguage();
    }

    @Then("Select {string} menu in WorkFlow")
    public void menuWorkFlow(String menu){
        homePageWF.selectMenu(menu);
    }

    @Then("Select {string} menu and assign request in WorkFlow")
    public void assignRequest(String menu){
        homePageWF.selectMenu(menu);
        monitoring.allin();
    }

    @Then("Approved client request")
    public void searchRequest(){
        request.searchByTRN();
        request.dataValidationClient();
        request.confirmValidationClient();
        request.approvedClient();
    }

    @Then("Verify client is approved")
    public void verifyTrn(){
        homePage.verifyTrn();
    }

    @Then("Search client status from {string}")
    public void clientStatus(String country){
        homePage.searchClientStatus(country);
    }

    @Then("Loan quoter with client TRN")
    public void loanProcess(){
        homePage.clickLoan();
        loan.validateLoan();
        loan.calculateQuote();
    }

}
