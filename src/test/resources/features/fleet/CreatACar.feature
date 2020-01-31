Feature: Create a new car

  @create_new_car
  Scenario: Verify column names
    Given user is on the login page
    And user logs in as store manager
    Then user navigates to "Fleet" then to "Vehicles"
    And user clicks on "Create Car" button
    Then user adds new car information:
      | License Plate | Driver       | Location        | Model Year | Color  |
      | TestPlates    | Test Driver  | Washington D.C. | 2020       | Black  |
      | SuperMan      | Cool Driver  | Texas           | 2019       | Red    |
      | FAM           | SQUAD-Driver | VA              | 2016       | Grey   |
      | Regular man   | Fire Fighter | Maryland        | 2000       | Silver |