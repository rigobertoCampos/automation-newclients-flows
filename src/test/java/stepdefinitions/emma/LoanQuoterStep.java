package stepdefinitions.emma;

import net.thucydides.core.annotations.Step;
import pageStructures.emma.LoanQuoterPage;

public class LoanQuoterStep {
    LoanQuoterPage loan;

    @Step("Search TRN to check loan")
    public void validateLoan(){
        loan.clickToCheck();
    }

    @Step("cash Loan amount")
    public void calculateQuote(){
        loan.insertAmount();
        loan.noCpi();
        loan.generateLoan();
        loan.waitLoanAlert();
    }
}
