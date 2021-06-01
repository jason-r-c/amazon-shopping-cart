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


class ProductPage {

	/**
	 * Price changed a few times but kept to a standard variable.
	 * What i could have done was create an array of 'acceptable' prices, then iterate over the acceptable list.
	 */
	@Keyword
	def verifyPrice(expectedPrice) {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/productPage_pageOjbects/productTitle'), GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)

		def actualPrice = WebUI.getText(findTestObject('Object Repository/productPage_pageOjbects/productPrice'), FailureHandling.STOP_ON_FAILURE)
		if(actualPrice == expectedPrice)  {
			println('\n ** Actual Price of product is as expected')
		} else {
			println('\n ** Price of product is NOT what we expect')
			assert false
		}
	}


	@Keyword
	def otherSellersAddToCartButton(otherSellerButton) {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		println('\n ** Attempting to click add to cart wtihin Other Sellers section.')
		WebUI.waitForElementClickable(findTestObject('productPage_pageOjbects/'+otherSellerButton+''), GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('productPage_pageOjbects/'+otherSellerButton+''))
	}

	@Keyword
	def primaryAddToCartButton() {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		println('\n ** Attempting to click primary add to cart button')
		WebUI.waitForElementClickable(findTestObject('productPage_pageOjbects/primary_addToCartButton'), GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('productPage_pageOjbects/primary_addToCartButton'))
	}

	@Keyword
	def verifyProductInSidesheetCart() {
		WebUI.waitForPageLoad(GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		def isVisible = WebUI.waitForElementVisible(findTestObject('productPage_pageOjbects/verifyProductInSidesheetCart'), GlobalVariable.defaultPageTimeout, FailureHandling.STOP_ON_FAILURE)
		if(!isVisible) {
			assert false
		}
	}


	// End of class
}