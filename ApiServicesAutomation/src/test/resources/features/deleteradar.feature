Feature: Delete a Radar
  As an Operation Leader
  I want to be able to delete an existing radar

  Scenario: Successfully delete a radar
    Given that I am An Operation Leader
    When I make the request to delete an existing radar
    Then the radar should no longer be present in the list of available radars

  Scenario: Attempt to delete a non-existent radar
    Given that i am an operation Leader
    When I try to delete a radar with a non-existent id
    Then I should receive a response with status code 400