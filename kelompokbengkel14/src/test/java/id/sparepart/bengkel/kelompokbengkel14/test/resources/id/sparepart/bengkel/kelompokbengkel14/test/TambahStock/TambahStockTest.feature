# language : en

Feature: Add Stock
            Stock keeper will add data items that have been out of stock to full again


         @Normal
         Scenario: Add Stock
                   Given stock keeper will choose the menu of "Ganti Status"
                   And stock keeper change item's status to be "Available"
                   And stock keeper input quantity of item
                   And stock keeper will get the notification 
                   When stock keeper choose "Yes" in the notification
                   Then successful response by displaying item's list

        @NoInput
         Scenario: Add Stock
                   Given stock keeper will choose the menu of "Ganti Status"
                   And stock keeper change item's status to be "Available"
                   And stock keeper input quantity of item
                   And stock keeper will get the notification 
                   When stock keeper choose "No" in the notification
                   Then failed response by displaying the home page
