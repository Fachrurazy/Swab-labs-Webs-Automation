package loginFeatures

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil


import com.kms.katalon.core.webui.exception.WebElementNotFoundException

public class login {
	// Method untuk cek apakah elemen visible
	@Keyword
	def boolean isElementVisible(TestObject element, String elementName) {
		try {
			if (element != null && WebUI.verifyElementVisible(element, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo("${elementName} is visible")
				return true
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("${elementName} is NOT visible : " + e.message)
			return false
		}
	}

	// Method untuk cek apakah elemen actual dan expected match
	@Keyword
	def boolean isElementMatch(String actual, String expected) {
		try {
			if (WebUI.verifyMatch(actual, expected, false)) {
				KeywordUtil.logInfo("Actual text and expected text of test object are Match")
				return true
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Actual text and expected text of test object are not Match" + e.message)
			return false
		}
	}

	// Method untuk cek apakah text di elemen actual dan expected match
	@Keyword
	def boolean isElementTextMatch(TestObject element, String expected) {
		try {
			if (element != null && WebUI.verifyElementText(element, expected)) {
				KeywordUtil.logInfo("Text of an element ${element} & Text of a expected ${expected} are Match")
				return true
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Text of an element ${element} & Text of a expected ${expected} are not Match" + e.message)
			return false
		}
	}

	//  Method untuk set text ke input field (dengan pengecekan visibility)
	@Keyword
	def void setInputText(TestObject element, String value, String elementName) {
		try {
			if (isElementVisible(element, elementName)) {
				WebUI.findWebElement(element, 5)
				KeywordUtil.logInfo("${elementName} is Founded")
				WebUI.clearText(element)
				KeywordUtil.logInfo("${elementName} is Cleared")
				WebUI.setText(element, value)
				KeywordUtil.logInfo("Successfully set text for ${elementName}")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Unable to set text for ${elementName}" + e.message)
		}
	}

	//  Method untuk set text ke input field dengan EncryptedText (dengan pengecekan visibility)
	@Keyword
	def void setInputEncryptedText(TestObject element, String value, String elementName) {
		try {
			if (isElementVisible(element, elementName)) {
				WebUI.findWebElement(element, 5)
				KeywordUtil.logInfo("${elementName} is Founded")
				WebUI.clearText(element)
				KeywordUtil.logInfo("${elementName} is Cleared")
				WebUI.setEncryptedText(element, value)
				KeywordUtil.logInfo("Successfully set text for ${elementName}")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Unable to set text for ${elementName}" + e.message)
		}
	}

	//  Method untuk klik tombol (dengan pengecekan visibility)
	@Keyword
	def void clickButton(TestObject button, String buttonName) {
		try {
			if (isElementVisible(button, buttonName)) {
				WebUI.click(button)
				KeywordUtil.logInfo("Clicked ${buttonName}")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Button ${buttonName} is NOT visible" + e.message)
		}
	}

	//  Method utama untuk login
	@Keyword
	def void loginProcess(String username, String password) {
		try {
			KeywordUtil.logInfo("=== Starting Login Process ===")

			TestObject inputUsername = findTestObject('Object Repository/Login_page/Page_Swag Labs/input_Swag Labs_user-name')
			TestObject inputPassword = findTestObject('Object Repository/Login_page/Page_Swag Labs/input_Swag Labs_password')
			TestObject btnLogin = findTestObject('Object Repository/Login_page/Page_Swag Labs/input_Swag Labs_login-button')

			// Input username & password
			setInputText(inputUsername, username, "Username Input Field")
			setInputEncryptedText(inputPassword, password, "Password Input Field")

			// Klik tombol login
			clickButton(btnLogin, "Login Button")
		} catch (Exception e) {
			KeywordUtil.markFailed("Login Process encountered an error: " + e.message)
		}
	}

	//  Method untuk verifikasi positive case login
	@Keyword
	def void verifyLoginSuccess(String expected) {
		try {
			KeywordUtil.logInfo("=== Verifying Positive Case Login ===")

			TestObject spanProduct = findTestObject('Object Repository/Dasboard_page/Page_Swag Labs/span_Products')
			String getUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)

			if (isElementVisible(spanProduct, "Dashboard Page")) {
				isElementMatch(getUrl, expected)
				KeywordUtil.markPassed("Login Successful - Dashboard is visible")
			} else {
				KeywordUtil.markFailed("Login Failed - Dashboard is NOT visible")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Verification encountered an error: " + e.message)
		}
	}
	
	//  Method untuk verifikasi positive case login
	@Keyword
	def String getTestDataValue(String filepath, int row, int coloumn) {
		findTestData(filepath).getValue(row, coloumn)
	}
	
}
