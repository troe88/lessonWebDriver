Feature: Contact Form submitting
  Scenario: Scenario_test1
    Given Login as "admin"
      And Open Contact Form page
#    When Fill form with "entity_1"
    When Fill Contact Form with data below
      | name        | dima |
      | lastName    | lebedev |
      | description | text |
      And Submit Contact Form
    Then Result contains "entity_1"