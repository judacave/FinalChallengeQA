Feature: Delete a Radar
  As an Operation Leader
  I want to be able to delete an existing radar

  Scenario Outline: Delete a radar
    Given that I am An Operation Leader
    When I make the request to delete an existing radar with <id>
    Then Should display a status message <status> depending on whether the id exists or not.
    Examples:
      | id              | status |
      | "BorrarDespues" | 200    |
      | "LM"            | 400    |
#  Scenario: Attempt to delete a non-existent radar
#    Given that i am an operation Leader
#    When I try to delete a radar with a non-existent id
#    Then I should receive a response with status code 400