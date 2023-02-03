package stepdefinitions.workFlow;

import net.thucydides.core.annotations.Step;
import pageStructures.workFlow.TimeMonitoring;

public class TimeMonitoringStep {
    TimeMonitoring tm;

    @Step("All in")
    public void allin(){
        tm.searchByDocument();
        tm.selectDocument();
        tm.enterDocument();
        tm.clickSearch();
        tm.selectRequest();
        tm.assignRequest();
        tm.selectUser();
        tm.confirmBtn();
    }
}
