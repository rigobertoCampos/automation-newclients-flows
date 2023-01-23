Feature: Search by keyword

  @signup
  Scenario: Searching for a term
    When Login in Emma
    Then Select "Jamaica" country
    Then Create new client
    Then Complete new client information
