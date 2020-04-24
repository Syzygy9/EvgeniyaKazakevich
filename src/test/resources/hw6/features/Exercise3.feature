Feature: VIP Users table

  Scenario: VIP users scenario
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header Menu
    And I click on 'USER TABLE' button in Service Menu
    When I set 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log component