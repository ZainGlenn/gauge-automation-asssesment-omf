# OMF Test Suite
Tags: web, omf_suite
Created by zainglenn on 2021/03/03
     
## As a possible loanee I would like to use the calculator to determine what installment I need for a specified ammout
Tags: calculator_test

GIVEN I open old mutual finance
WHEN I open persnal loans
AND I complete a my loan amout
AND I complete my duration
Then I should see a possible installment range
Whne I view breakdown
Then I should see my Capitial and term values

* Navigate to url "https://www.oldmutualfinance.co.za/"
* Validate home page is open
* Navigate to "Personal Loans" page via menu bar
* Validate personal loans page is open
* Validate Calculator tab is selected by default
* Select ammout "R50 000"
* Validate "Select a loan term: " is displayed in calculator section
* Select loan term "84" months
* Validate "Your total deduction will be between :" is displayed in calculator section
* Validate monthly installment is "R,1521.05 and R1600.42" is displayed in calclator section
* Select View Breakdown link in calculator section
* Validate Capital value is "R50,000.00" on calculator section
* Validate Term value is "84 months" on calculator section
___
* Shutdown browser