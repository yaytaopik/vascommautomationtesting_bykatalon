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

WebUI.click(findTestObject('Object Repository/Placement/Page_Admin Page/span_Master Data'))

WebUI.click(findTestObject('Object Repository/Placement/Page_Admin Page/a_Placements'))

WebUI.setText(findTestObject('Object Repository/Placement/Page_Admin Page/input_Add New Placement_search'), placement)

WebUI.click(findTestObject('Object Repository/Placement/Page_Admin Page/button_Search'))

if (placement == 'jakarta') {
    WebUI.verifyElementVisible(findTestObject('Placement/VerifyObject/Page_Admin Page/td_On Site Jakarta'))

    KeywordUtil.markPassed('Pass')

    WebUI.takeFullPageScreenshot()
} else if (placement == 'waru') {
    WebUI.verifyElementVisible(findTestObject('Placement/VerifyObject/Page_Admin Page/td_On Site Waru'))

    KeywordUtil.markPassed('Pass')

    WebUI.takeFullPageScreenshot()
} else if (placement == 'malang') {
    WebUI.verifyElementVisible(findTestObject('Placement/VerifyObject/Page_Admin Page/td_On Site Malang'))

    KeywordUtil.markPassed('Pass')

    WebUI.takeFullPageScreenshot()
} else {
    KeywordUtil.markFailed('Failed')

    WebUI.takeFullPageScreenshot()
}

WebUI.closeBrowser()

