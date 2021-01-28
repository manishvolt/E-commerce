Feature: user journey
Background: userloggedin
Given user hits the url
Given user clicks on signin
Given user enters credential

@Journey
Scenario: user does activity
Given User goes in Tshirt
Given User selects product
Given user verifies the price of product
And user selects quanity
And user selects size 
When user clicks on add to cart
Then product is successfully added to cart 
Then proceed to checkout
Then complete order payment

