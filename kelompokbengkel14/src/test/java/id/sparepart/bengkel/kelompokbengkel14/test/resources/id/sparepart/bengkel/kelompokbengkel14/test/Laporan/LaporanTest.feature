# language: en

Feature: Print Advisory
         Print Advisory

        @Normal
        Scenario:  Print Advisory
                   Given cashier choose the menu of "Report" on the system
                   When there are data reports
                   Then a successful response by displaying the report page

        