
Feature: PDF Statement Verification Demo
  As an account holder
  I want to quickly verify my J.P. Morgan investment statement
  So that I can confirm key financial data is accurate

  Background:
    Given I have downloaded the daily statement PDF
    And the PDF file is named "Brokerage_March2021.pdf"

  Scenario: Verify header and account details
    When I open the PDF file
    Then the PDF should contain the text "J.P.Morgan"
    And the PDF should contain the text "Investment Statement"
    And the PDF should contain the text "Account Number 974-51910"
    And the PDF should contain the text "Statement Period February 27 - March 31, 2021"
    And the PDF should contain the text "RONALD PARKER TOD"

