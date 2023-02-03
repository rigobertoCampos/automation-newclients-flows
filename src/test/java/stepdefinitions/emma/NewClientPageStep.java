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
        newClientPage.selectDateWork();
        newClientPage.employerName();
        newClientPage.workAddress();
        newClientPage.workNumber();
        newClientPage.selectPP();
        newClientPage.submitInfo();
    }

    @Step("Geographic info")
    public void geographicInfo(String region1, String region2){
        newClientPage.selectParish(region1);
        newClientPage.selectDistrict(region2);
        newClientPage.selectResidentStatus();
        newClientPage.currentAddress();
        newClientPage.submitInfo();
    }

    @Step("Contact info")
    public void contactInfo(String country){
        newClientPage.contactName();
        newClientPage.contactNumber();
        if(country.equals("Aruba")){
            newClientPage.contactNameAruba();
            newClientPage.contactNumberAruba();
        }
        newClientPage.submitInfo();
    }

    @Step("Upload files")
    public void filesInfo(){
        newClientPage.uploadFile("Front of your ID");
        newClientPage.uploadFile("Back of your ID");
        newClientPage.uploadFile("Most recent Utility Bill");
        newClientPage.uploadFile("Enter proof of your income");
        newClientPage.sendAllData();
        newClientPage.waitingResponse();
    }
}
