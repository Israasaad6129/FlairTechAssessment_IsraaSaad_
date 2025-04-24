Feature: login to add and delete new user

  Scenario: login with valid credentials and add and remove user
    Given open OrangeHRM login page
    When enter "Admin" as username and "admin123" as password
    Then click on login button
    And click on "Admin" tab
    And get the number of records found
    And click on "Add" button
    And enter "Admin" as User Role and "Arthur thi Ghamboyan" as Employee Name and "Enabled" as Status and "Israa" as Username
    And click on login button
    Then the Record found should be increased by 1
    When search with Username "Israa"
    And delete the found record
    Then the Record found should be decreased by 1

    When