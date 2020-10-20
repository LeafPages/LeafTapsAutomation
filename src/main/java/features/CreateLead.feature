Feature: Create Lead in Leaftaps (Positive and Negative Scenario)

Scenario Outline: Create Lead with mandatory fields

Given CRM is clicked
And Click Leads Tab in My Home Page
And Click Create Lead Link in My Leads Page
When Type company name in Create Lead Page as <CName>
And Type first name in Create Lead Page as <FName>
And Type last name in Create Lead Page as <LName>
And Click Create Lead button in Create Lead Page

Examples:
|CName|FName|LName|
|TestLeaf|Babu|M|
|Google|Sundar|P|