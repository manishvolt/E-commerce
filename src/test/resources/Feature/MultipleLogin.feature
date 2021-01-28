@MultipleLogin
Feature: test login
Background: hit url
Given user hits the url
And user clicks on signin

Scenario Outline: user is able to login
When user enters email as "<email>" and password as "<password>"
Then user is logged in
Examples:
|email|password|
|mnighut@gmail.com|ilovecs1.6|
|volt@gmail.com|771baner|





