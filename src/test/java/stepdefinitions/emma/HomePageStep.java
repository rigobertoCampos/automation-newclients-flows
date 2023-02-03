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

    @Step("Create new cashLoan")
    public void clickLoan(){
        hp.clickLoan();
        hp.searchTrnValidation();
    }

    @Step("Verify TRN is ready")
    public void verifyTrn(){
        hp.searchTrnValidation();
        hp.clickSearchTrn();
        hp.waitApproveBox();
    }

    @Step("Search client status")
    public void searchClientStatus(String country){
        hp.searchTrnValidation();
        hp.clickSearchTrn();
    }
}
