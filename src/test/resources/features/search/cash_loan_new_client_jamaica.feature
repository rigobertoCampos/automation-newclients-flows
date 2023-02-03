@Jamaica
Feature: New client cash loan Jamaica

  @signup
  Scenario: New credit application Jamaica Emma
    When Login into Emma
    Then Select "Jamaica" country
    Then Create new client
    Then Complete client personal information
    Then Complete client region information from "Jamaica" "Hanover" "Ramble"
    Then Search client status from "Jamaica"

  Scenario: Request tracking client in WorkFlow
    When Login into WorkFlow
    Then Select "Jamaica" country in WorkFlow
    Then Select "Time Monitoring" menu and assign request in WorkFlow
    Then Select "Request Tracking" menu in WorkFlow
    Then Approved client request

  Scenario: Create cash loan Emma
    When Login into Emma
    Then Select "Jamaica" country
    Then Verify client is approved
    Then Loan quoter with client TRN
