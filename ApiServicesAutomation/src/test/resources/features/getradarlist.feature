Feature: List Radars
  As an Operation Leader
  I want to be able to view a list of available radars

  Scenario: Successfully list available radars
    Given I am an Operation leader
    When I request the list of available radars
    Then the system should return a list of radars.