package amazon
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class SearchResultsPage {

	/**
	 * Amazon uses the product name as the page title. Based on this unique value i decided to use that as opposed to
	 * waiting for a specific element to become visible.
	 */
	@Keyword
	def confirmSearchResultsPageDisplayed(productName) {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		def windowTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

		productName = productName.toLowerCase()
		println('\n ** Window title is: '+windowTitle)
		println('\n ** windowTitle.toLowerCase().contains(productName) is: '+windowTitle.toLowerCase().contains(productName))

		if(windowTitle.toLowerCase().contains(productName)) {
			println('\n ** Product name confirmed')
		} else {
			assert false
		}
	}

	/**
	 * Found that clicking the checkbox was causing location based issues, so decided to scroll to the element then click.
	 */
	@Keyword
	def applySearchFilter(scrollToEl, clickEl) {
		WebUI.scrollToElement(findTestObject('Object Repository/searchResultsPage_pageObjects/'+scrollToEl+''), GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/searchResultsPage_pageObjects/'+clickEl+''), FailureHandling.STOP_ON_FAILURE)
	}


	/**
	 * I found that the '2020 Newest Dell Inspiron 15 3000 PC Laptop' text was the 1st result found. 
	 * Then this changed during test development.
	 * Based on this change, i added a loop to try the next 3 pages, if no result found then end the test.
	 * 
	 * Also found the result amount to change, so had to pick a more generic xpath query.
	 * 
	 */
	@Keyword
	def selectItemFromResultList(clickEl) {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)

		try {
			println('\n ** Trying to find item')
			for(int i=0; i < 3; i++) {
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/searchResultsPage_pageObjects/'+clickEl+''), GlobalVariable.timeToInteractWithElement) == true) {
					println("\n ** Element is visible. Now selecting product.")
					WebUI.click(findTestObject('Object Repository/searchResultsPage_pageObjects/'+clickEl+''), FailureHandling.STOP_ON_FAILURE)
					break
				} else {
					println("\n ** Text is not visible. Clicking next and waiting...")
					WebUI.click(findTestObject('Object Repository/searchResultsPage_pageObjects/click_nextInPagination'), FailureHandling.STOP_ON_FAILURE)
				}
			}
		} catch(e) {
			println('** \n Unable to find product. Exception thrown: '+e)
			assert false
		}
	}

	// End of class
}