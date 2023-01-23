package stepdefinitions.emma;

import net.thucydides.core.annotations.Step;
import pageStructures.emma.NewClientPage;

public class NewClientPageStep {

    NewClientPage newClientPage;

    @Step("Send TRN Number")
    public void insertTRN(){
        newClientPage.insertTRN();
        newClientPage.sendTRN();
    }

    @Step("Personal info")
    public void personalInfo(){
        newClientPage.waitToLoad();
        newClientPage.firsName();
        newClientPage.middleName();
        newClientPage.lastName();
        newClientPage.secondLastName();
        newClientPage.phoneNumber();
        newClientPage.email();
        newClientPage.birthDate();
        newClientPage.sendData();
        newClientPage.successFully();
    }

    @Step("Personal info payment")
    public void personalInfoPayment(){
        newClientPage.selectGender();
        newClientPage.selectCountryOrigin();
        newClientPage.numberDependents();
        newClientPage.selectMarriedStatus();
        newClientPage.selectPaymentFreq();
        newClientPage.netIncome();
        newClientPage.homeAddress();
        newClientPage.submitInfo();
        newClientPage.confirmAll();
    }

    @Step("Personal work info")
    public void personalWorkInfo(){
        newClientPage.selectOccupation();
        newClientPage.monthsWorkIn();
        newClientPage.selectEconomyAct();
        newClientPage.selectPP();
        newClientPage.submitInfo();
    }

    @Step("Geographic info")
    public void geographicInfo(){
        newClientPage.selectParish();
        newClientPage.selectDistrict();
        newClientPage.selectResidentStatus();
        newClientPage.currentAddress();
        newClientPage.submitInfo();
    }
}
