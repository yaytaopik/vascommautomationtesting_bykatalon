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

WebUI.click(findTestObject('Object Repository/Applicant/Page_Admin Page/span_Applicants'))

WebUI.setText(findTestObject('Object Repository/Applicant/Page_Admin Page/input_Filter_search'), applicantName)

WebUI.click(findTestObject('Object Repository/Applicant/Page_Admin Page/button_Search'))

if (applicantName == 'kiki') {
    WebUI.verifyElementVisible(findTestObject('Applicant/Verify/Page_Admin Page/td_Kiki'))
	KeywordUtil.markPassed("Pass")
	WebUI.takeFullPageScreenshot()
} else if (applicantName == 'raka') {
	WebUI.verifyElementVisible(findTestObject('Applicant/Verify/Page_Admin Page/td_Raka'))
	KeywordUtil.markPassed("Pass")
	WebUI.takeFullPageScreenshot()
} else if (applicantName == 'suluh') {
	WebUI.verifyElementVisible(findTestObject('Applicant/Verify/Page_Admin Page/td_Suluh'))
	KeywordUtil.markPassed("Pass")
	WebUI.takeFullPageScreenshot()
} else {
	KeywordUtil.markFailed("Failed")
	WebUI.takeFullPageScreenshot()
}


WebUI.closeBrowser()

