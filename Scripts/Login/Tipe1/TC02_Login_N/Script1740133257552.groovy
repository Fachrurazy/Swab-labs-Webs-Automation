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

WebUI.callTestCase(findTestCase('Login/Tipe1/Flow_Login'), [('password') : findTestData('Testdata_login').getValue('password', 
            1), ('username') : ''], null)

WebUI.verifyElementPresent(findTestObject('Login_page/Page_Swag Labs/h3_Epic sadface Username is required'), 0)

WebUI.verifyElementText(findTestObject('Login_page/Page_Swag Labs/h3_Epic sadface Username is required'), findTestData('Testdata_login').getValue(
        'message_error', 1))

WebUI.takeAreaScreenshot('C:\\Users\\atija\\OneDrive\\Pictures\\Katalon\\Screenshots\\Login_username_missing.png')

WebUI.delay(2)

WebUI.closeBrowser()

