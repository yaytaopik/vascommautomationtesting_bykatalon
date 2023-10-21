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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Vacancies/Page_Admin Page/a_Vacancies'))

WebUI.setText(findTestObject('Object Repository/Vacancies/Page_Admin Page/input_Filter_search'), vacancy)

WebUI.click(findTestObject('Object Repository/Vacancies/Page_Admin Page/button_Search'))

if (vacancy == 'purchasing') {
    WebUI.verifyElementVisible(findTestObject('Vacancies/VerifyObject/Page_Admin Page/td_Staf Purchasing'))
    KeywordUtil.markPassed('Pass')
    WebUI.takeFullPageScreenshot()
} else if (vacancy == 'accounting') {
    WebUI.verifyElementVisible(findTestObject('Vacancies/VerifyObject/Page_Admin Page/td_Accounting Staf'))
    KeywordUtil.markPassed('Pass')
    WebUI.takeFullPageScreenshot()
} else {
    KeywordUtil.markFailed('Failed')

    WebUI.takeFullPageScreenshot()
}

WebUI.closeBrowser()

