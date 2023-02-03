package stepdefinitions.workFlow;

import net.thucydides.core.annotations.Step;
import pageStructures.workFlow.RequestTracking;

public class RequestTrackingStep {
    RequestTracking requestTracking;

    @Step("Search client request by TRN")
    public void searchByTRN(){
        requestTracking.searchByTRN();
        requestTracking.clickSearch();
        requestTracking.clickOnRequest();
    }

    @Step("data Validation client")
    public void dataValidationClient(){
        requestTracking.saveData();
        requestTracking.generalInfo();
        requestTracking.selectResolve("Identifications");
        requestTracking.saveData();
        requestTracking.generalInfo();
        requestTracking.selectResolve("Addresses");
        requestTracking.saveData();
        requestTracking.generalInfo();
        requestTracking.selectResolve("Phones");
        requestTracking.saveData();
        requestTracking.generalInfo();
        requestTracking.selectResolve("Financial information");
        requestTracking.saveData();
        requestTracking.generalInfo();
        requestTracking.selectResolve("References");

    }

    @Step("Validation client")
    public void confirmValidationClient(){
        requestTracking.generalInfo();
        requestTracking.selectResolve("Resolve");
        requestTracking.clickStatus();
        requestTracking.dataVerification();
        requestTracking.subStatus();
        requestTracking.dataValidation();
        requestTracking.saveChange();
    }

    @Step("Approved client")
    public void approvedClient(){
        requestTracking.clickStatus();
        requestTracking.selectApproved();
        requestTracking.saveChange();
    }
}
