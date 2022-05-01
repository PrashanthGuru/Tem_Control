@Flow01
Feature: Regression for TC Active shipments

  Scenario: Test fo TC Active shipments
    Given Login to Application and switch role for TCActiveFow
    When perform TC Booking for Active in CAP018 screen for TCActiveFow
    #And perform capture AWB in OPR026 screen for TCActiveFow
#	  Then goods acceptance works fine for TCActiveFow
#	  And capture TC details works fine for TCActiveFow