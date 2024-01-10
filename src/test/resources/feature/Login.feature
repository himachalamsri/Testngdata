Feature: verifying fb login Automation

  Scenario Outline: verifying login with valid credential
    Given user is on the login page
    When user login "<username>","<password>"
    Then user should verify success message after login "<welcome sri>"

    Examples: 
      | username                | password   |
      | Sriramulu3435@gmail.com | srilak@123 |

  Scenario Outline: verifying login with valid credential useing ENTER key
    Given user is on the login page
    When user login "<username>","<password>" using ENTER key
    Then user should verify success message after login "<welcome sri>"

    Examples: 
      | username                | password   |
      | Sriramulu3435@gmail.com | srilak@123 |

  Scenario Outline: verifying login with invalid credential
    Given user is on the login page
    When user login "<username>","<password>"
    Then user should verify error message after login "<Invalid login details>"

    Examples: 
      | username                | password |
      | Sriramulu3435@gmail.com | sri@123  |
