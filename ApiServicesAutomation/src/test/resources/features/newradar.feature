Feature: Create a New Radar
  As an Operation Leader
  I want to be able to create a new radar

  Scenario: Successfully create a new radar
    Given that I am an Operation Leader
    When I create a new radar by providing a name and defining the evaluation criteria and level of appropriateness for each descriptor in the knowledge areas
    Then the new radar should be successfully created and added to the list of available radars.