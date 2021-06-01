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

/**
 * Class description:
 * 
 * This sits outside the POM pattern as these methods are available to all webpages.
 * Any component of a webpage that appears in more than one webpage should be added to this class.
 *
 */

class CommonPageObjects {

	@Keyword
	def searchForProductUsingMainSearchBar(productName) {
		WebUI.verifyElementClickable(findTestObject('amazonHomePage_pageObjects/mainSearchBar'), FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject('amazonHomePage_pageObjects/mainSearchBar'), productName, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementClickable(findTestObject('amazonHomePage_pageObjects/mainSearchBar_searchForProduct'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('amazonHomePage_pageObjects/mainSearchBar_searchForProduct'), FailureHandling.STOP_ON_FAILURE)
	}

	// End of class
}