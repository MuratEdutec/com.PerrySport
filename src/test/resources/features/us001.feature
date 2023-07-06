Feature: US001_The price must be properly sorted


    Scenario: US001.TC01_The price sorting from low to high must be proper

        Given Go to perry
        Then click cokie
        Then click SALE
        #Then scroll down to see products
        Then click Sorteer Op_Prijs: Laag naar Hoog
        Then verify that the low-to-high sorting is true
        Then terminate test

    Scenario: US001.TC02_The price sorting from high to low must be proper

        Given Go to perry
        Then click cokie
        Then click SALE
        #Then scroll down to see products
        Then click Sorteer Op_Prijs: Hoog naar Laag
        Then verify that the high-to-low sorting is true
        Then terminate test

