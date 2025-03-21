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
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global as Global
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()



WebUI.verifyElementVisible(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_user-name'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_password'))

WebUI.verifyElementVisible(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_login-button'))

WebUI.click(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_user-name'))

WebUI.setText(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_user-name'), username)

WebUI.click(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_password'))

WebUI.setText(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_password'), password)

WebUI.takeScreenshot('C:\\Users\\atija\\OneDrive\\Pictures\\Katalon\\Screenshots\\Login_page.png')

WebUI.delay(2)

WebUI.click(findTestObject('Login_page/Page_Swag Labs/input_Swag Labs_login-button'))

