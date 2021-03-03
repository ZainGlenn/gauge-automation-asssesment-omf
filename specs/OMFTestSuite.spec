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

* Navigate to url "https://www.oldmutualfinance.co.za/" maximized
* Validate home page is open
* Navigate to "Personal Loans" page via navigation bar
* Validate personal loans page is open
* Validate Calculator tab is selected by default
* Select amount R"50 000" on calculator
* Validate "SELECT A LOAN TERM:" is displayed in calculator section
* Select loan term "84" months
* Validate "Your total deduction will be between:" is displayed on cost breakdown in calculator section
* Validate installment is between "R1,521.05" and "R1,600.42" per month is displayed in calculator section
* Select View Breakdown link in calculator section
* Validate Capital value is "R50,000.00" on calculator section
* Validate Term value is "84 months" on calculator section
___
* Shutdown browser