import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**
 * 
 * task
 * 
UI Automation Testing Practical
Please also, with an automation tool of your choice, build an automated test usingamazon.com:
1.     Search for a “Dell Laptop”
2.     Refine your search by clicking on 4GB in the left filter panel
3.     Pick a “2020 Newest Dell Inspiron 15 3000 PC Laptop”
4.     Check the price is $373.00
5.     Add the laptop to your basket
6.     Find a monitor and add to your basket

During your interview, you will be expected to talk us through your test and the logic behind your choices


Logic behind approach
============================

- Used the Page Object Model design pattern
	- Created reusable functions which can be reused in different test cases.

- Object repository
 	- I have used the Object Repository to hold per-page xpath queries.
 	- Folders are named after the class name so to easily find.
 	- Xpath queries are designed to be relatively robust, ie, not too many segments within the query, and use unique html attributes
 	
- Test case uses variables specific to the implementation
	- Reusing the page methods in a different test should only necessitate changes to variables
	- Methods needing a specific value take the Object Repository name as a parameter, giving a simple pattern to rely on and use
	
- Keywords
	- Custom functions use 'wait' Katalon functions to ensure  we are safe to operate on elements
	- General 10 second timeout in Execution Profile 






classes
================

* navigate to amazon home page
    * page webelements
        - verify amazon logo [x]
        - verify saerch field [x]       
        - click search button [x]

    * page methods
    	- navigte to amazon.com [x]
        - verify amazon logo [x]
        - maximise window [x]
        - verify search bar clickable [x]
        - enter product name [x]
        - click search button [x]       

* search results page
    * page webelements
        - select ram capacity
        - selected ram capacity
        - select product

    * page methods
        - verify page title [x]
        - scroll to element [x]
        - select ram capacity [x]
        - verify selected ram capacity
        - select product [x]

* product page
    * page webelements
        - verify element visible [x]
        - get product price [x]
        - add to basket [x]

    * page methods
        - verify element visible [x]     
        - verify product price [x]              
        - add to basket [x]       

* added to cart page
    * page webelements 
        - verify added to cart text [x]

    * page methods
        - verify added to cart text [x]

the test (implementation)
================================================
       
* test case
    * navigate to amazon.com
    * search for dell laptop
    * refine search to 4GB laptops
    * select a "2020 Newest Dell Inspiron 15 3000 PC Laptop"
    * verify the price is 254.86
    * Add the laptop to your basket
   
    // Find a monitor and add to your basket
    * search for monitor
    * select a monitor
    * Add the laptop to your basket




*/