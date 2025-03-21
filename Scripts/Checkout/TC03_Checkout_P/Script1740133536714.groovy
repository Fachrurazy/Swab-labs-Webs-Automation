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
            1), ('username') : findTestData('Testdata_login').getValue('username', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Dasboard_page/Page_Swag Labs/button_Add to cart'))

WebUI.click(findTestObject('Dasboard_page/Page_Swag Labs/a_Swag Labs_shopping_cart_link'))

WebUI.verifyElementVisible(findTestObject('Cart_page/Page_Swag Labs/button_Checkout'))

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/button_Checkout'))

WebUI.verifyElementVisible(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_firstName'))

WebUI.verifyElementVisible(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_lastName'))

WebUI.verifyElementVisible(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_postalCode'))

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_firstName'))

WebUI.setText(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_firstName'), findTestData('Testdata_checkout').getValue(
        'firstname', 1))

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_lastName'))

WebUI.setText(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_lastName'), findTestData('Testdata_checkout').getValue(
        'lastname', 1))

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_postalCode'))

WebUI.setText(findTestObject('Cart_page/Page_Swag Labs/input_Checkout Your Information_postalCode'), findTestData('Testdata_checkout').getValue(
        'zip', 1))

WebUI.takeScreenshot('C:\\Users\\atija\\OneDrive\\Pictures\\Katalon\\Screenshots\\Checkout.png')

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/input_Cancel_continue'))

WebUI.click(findTestObject('Cart_page/Page_Swag Labs/button_Finish'))

WebUI.verifyElementPresent(findTestObject('Cart_page/Page_Swag Labs/img_Checkout Complete_pony_express'), 0)

WebUI.takeScreenshot('C:\\Users\\atija\\OneDrive\\Pictures\\Katalon\\Screenshots\\Checkout_success.png')

WebUI.delay(2)

WebUI.closeBrowser()

