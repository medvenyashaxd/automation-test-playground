Feature: UI Test Automation Playground
  Background: Open the main page of the site
    Given Open url "http://uitestingplayground.com/"

    Scenario: Different automation test
      When Go to Dynamic ID test
      When Go to Class attribute test
      When Go to Hidden layers test
      When Go to Load delays test
      When Go to AJAX data test
      When Go to Client side delay test
