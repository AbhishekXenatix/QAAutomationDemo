Feature: E2E Test Scenario

  Scenario: Register for new account
    Given User Navigates to HomePage
    When  User Clicks on My Account Icon
    And   User Click on Register
    When  User Enters Credentials with random email "QA" , "Automation" , "012345" , "123456789"
    And   Successfully Creation should be displayed
    And   User Click On Continue Button to navigate To My Account Page


  Scenario: User Search For Any Product and assert searched for desired product
    When  User Enter Product in search "mac"
    Then  Assert Search Page Appearance of "mac"

  Scenario Outline: User Adds Item To Shopping Cart
    When   User Add Product to cart "<product>"
    Then   Confirmation Message Appears For Adding Product To Cart "<product>"

    Examples:
      | product     |
      | MacBook     |
      | iMac        |
      | MacBook Air |
      | MacBook Pro |

  Scenario: User removes Items From Shopping Cart page
    When User Click on Cart Icon
    And  User Click On View Cart To Navigate To Shopping Cart Page
    And  User Removes Specific Product From Shopping Cart Page "iMac"
    Then  Assert Product Removed From Shopping Cart Page "iMac"


  Scenario: User removes Items From Cart dropDown
    When User Click on Cart Icon
    And  User Removes Specific Product From Cart "MacBook Pro"
    And   User Click on Cart Icon
    Then  Assert Product Removed From Cart Icon "MacBook Pro"

  Scenario: Continue Shopping To add another products to cart
    When User Click On Continue Shopping Button
    Then Assert Directed To Home Page

  Scenario: User Search For Any Product and assert searched for desired product
    When  User Enter Product in search "ipod"
    Then  Assert Search Page Appearance of "ipod"

  Scenario Outline: User Adds Item To Shopping Cart
    When   User Add Product to cart "<product>"
    Then   Confirmation Message Appears For Adding Product To Cart "<product>"

    Examples:
      | product      |
      | iPod Classic |
      | iPod Nano    |

  Scenario: navigating to Shopping Cart Page
    Given User Click on Cart Icon
    When  User Click On View Cart To Navigate To Shopping Cart Page

  Scenario Outline: updating product quantities in shopping cart page
    When  User Change The Quantity of the product "<product>" "<quantity>"
    And   User Click on Update Icon for product "<product>"
    Then  The Quantity of the product Must Be Changed

    Examples:
      | product      | quantity |
      | MacBook Air  | 3        |
      | MacBook      | 5        |
      | iPod Classic | 1        |
      | iPod Nano    | 2        |

  Scenario: User removes Items From Cart dropDown
    When User Click on Cart Icon
    And  User Removes Specific Product From Cart "MacBook"
    And  User Removes Specific Product From Cart "iMac"
    And   User Click on Cart Icon
    Then  Assert Product Removed From Cart Icon "MacBook"

  Scenario: Test Checkout Details And Billing Details
    When User Click on Checkout Button To Navigate To Checkout Page
    And   User Enters Valid Credentials in Billing Details "Test","Lohas","cairo","giza","0002","Hong Kong","Eastern Hong Kong Island"
    And   User Confirm Billing Details
    And   User Confirm Delivery Details
    And   User Select Delivery Method
    And   User Select Payment Method

  Scenario Outline: check order Details And Placing Order
    Then  Assert order details "<product>" "<price>" "<quantity>"
    Examples:
      | product      | price     | quantity |
      | MacBook Air  | $1,000.00 | 3        |
      | iPod Classic | $100.00   | 1        |
      | iPod Nano    | $100.00   | 2        |


  Scenario: Confirm order and placing the order
    When  User Confirm Order Details
    Then  Order Confirmation message appear


  Scenario: review order history and Make a Return Request
    When  User click on order history
    And   User click on View Order Button
    And   User click on Return button for Specific Product "iPod Nano"
    And   User Fill Information For Return Request and submit "comment"
    Then  assert submitting your return request
    And   User Click On Continue Button to navigate To Home Page

  Scenario: Log out
    When    User Clicks on My Account Icon
    And     User Clicks on Logout
    Then    Account Logout Page Appears
