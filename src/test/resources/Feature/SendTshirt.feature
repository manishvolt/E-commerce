Feature: Sending Tshirt

@Testcase2
Scenario: Check user is able to Send friend a Tshirt
Given user hits the url
Given user clicks on signin
Given user enters credential
And User goes in Tshirt
And User selects product
And User chooses sendtofriend option
When Recipients info is entered and submitted
Then email is being sent