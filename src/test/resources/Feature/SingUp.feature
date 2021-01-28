Feature: SignUp
@SignUp
Scenario: check user is able to signup for the account
Given user hits the url
And user clicks on signin
When user fill up the form and register
|Manish|Nighut|volt@gmail.com|771baner|gridlogics|baner|kharadi|pune|00000|7507190724|
Then user is logged in





