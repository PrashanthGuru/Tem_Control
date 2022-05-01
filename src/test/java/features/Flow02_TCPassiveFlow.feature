@Flow02
Feature: Regression for TC Passive shipments

  Scenario: Test fo TC Passive shipments
    Given Login to Application and switch role for TCPassiveFlow
    When perform TC Booking for Passive in CAP018 screen for TCPassiveFlow
    And perform capture AWB in OPR026 screen for TCPassiveFlow
    Then goods acceptance works fine for TCPassiveFlow
    And capture TC details works fine for TCPassiveFlow
    