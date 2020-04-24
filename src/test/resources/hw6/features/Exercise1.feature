Feature: Different elements page feature

  Scenario: Testing checkboxes on the Different Elements Page
    Given I am on the Home Page
    Then Page title equals to 'Home Page'
    And I login as 'Roman' and 'Jdi1234'
    Then I see User name 'ROMAN IOVLEV' on the right top side of the screen
    Then I go to the Header Menu 'Service'
    When I click the link 'DIFFERENT ELEMENTS' in Service Menu
    When I click checkbox 'Wind' on the Different Elements page
    Then I see log containing 'Wind: condition changed to true'
    When I click checkbox 'Water' on the Different Elements page
    Then I see log containing 'Water: condition changed to true'
    When I set radiobutton 'Selen' on the Different Elements page
    When I set 'Yellow' in colors dropdown
    Then I see log containing 'Colors: value changed to Yellow'