Feature: As an Automation Tester,
I want to search for bookings under hotels

Scenario Outline: Validate The Search for Hotel Bookings
  Given SignUp as a user "<RowNumber>"
  And Search For Bookings for Hotels "<RowNumber>"


  Examples:
    | RowNumber |
    |  1 |



