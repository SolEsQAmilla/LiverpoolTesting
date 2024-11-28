@LiverpoolScenarios
  Feature: Basic features for Liverpool website (Search, login and buy)

    ##We could use background here to do any necessary previous step for the scenarios

    @REGRESSION @Story1 @Positive @SearchBar @HappyPath
    Scenario: 1 Look for a product with specific characteristics
      Given I want the product "Smart TV"
      When I look for the product
      Then I get the information from the product
      But I look for the product with the following filters:
          | Price | $5000.0 -$10000.0 |
          | Brand |       GHIA        |
          | Size  |        50         |
      And I get the information from the product
      And I click on "product"
      And I click on "buy now"

    @REGRESSION @Story2 @Positive @Login @HappyPath
    Scenario: 2 Login to the liverpool page
      Given I click on "login home page"
      And I need credentials for an existing account:
          | Username | marisol.escamilla.mec@gmail.com |
          | Password |            Gn0m3$0rt            |
      When I click on "login"
      Then login was successful