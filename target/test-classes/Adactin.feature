Feature: verifying the adactin details
Scenario Outline: verifying adactin hotel search
Given User is on adactin page
When User should enter "<username>" , "<password>"
Then User should verify "Hello Selvafrench123!"
And User should verify login with enter key "Hello Selvafrench123!"