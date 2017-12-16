# language: en

Feature: Add New Items
            Stock keeper will add new data items that not included in the previous list 

          @Normal
          Scenario: Add New Items
                    Given stock keeper choose the menu of "Add New Items" on the system
                    And Stock keeper will input new data items such as "item's id", "item's name", "quantity of item"
                    When stock keeper choose the menu of "Input Item"
                    Then the successful response by displaying "Item Successfully Inputed"

          @ItemAvailable 
          Scenario: Add New Items
                    Given stock keeper choose the menu of "Add New Items" on the system
                    And Stock keeper will input new data items such as "item's id", "item's name", "quantity of item"
                    When stock keeper choose the menu of "Input Item"
                    And show the notification "Item Already Inputed"
                    Then the response failed by displaying "Data Is Available In List"