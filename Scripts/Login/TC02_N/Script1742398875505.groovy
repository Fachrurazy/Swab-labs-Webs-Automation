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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Openbrowser dan get link url menggunakan globalvariable
WebUI.openBrowser(GlobalVariable.url, FailureHandling.STOP_ON_FAILURE)

// Maximizewindow
WebUI.maximizeWindow(FailureHandling.OPTIONAL)

// Memanggil custom keyword package login features - keyword login - method login process
CustomKeywords.'loginFeatures.login.loginProcess'('', '')

// TestObject element error message Username is required
TestObject error_msg = findTestObject('Object Repository/Login_page/Page_Swag Labs/error_message username or password invalid')

// TestObject element icon error input text Username
TestObject icon_errorUsername = findTestObject('Object Repository/Login_page/Page_Swag Labs/icon_error Username')

// TestObject element icon error input text Username
TestObject icon_errorPassword = findTestObject('Object Repository/Login_page/Page_Swag Labs/icon_error Password')

CustomKeywords.'loginFeatures.login.isElementVisible'(error_msg, "Error Message")

CustomKeywords.'loginFeatures.login.isElementVisible'(icon_errorUsername, "Icon Error Username")

CustomKeywords.'loginFeatures.login.isElementVisible'(icon_errorPassword, "Icon Error Password")

CustomKeywords.'loginFeatures.login.isElementTextMatch'(error_msg, 
	CustomKeywords.'loginFeatures.login.getTestDataValue'(GlobalVariable.testDataLogin, 3, 1))


WebUI.closeBrowser()



