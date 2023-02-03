@Aruba
Feature: New client cash loan Aruba

  @signup
  @passport
  Scenario: New credit application Aruba Emma
    When Login into Emma
    Then Select "Aruba" country
    Then Create new client
    Then Complete client personal information
    Then Complete client region information from "Aruba" "Savaneta" "Cura Cabai"
    Then Search client status from "Aruba"
