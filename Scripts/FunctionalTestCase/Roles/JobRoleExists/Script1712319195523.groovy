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
import internal.GlobalVariable
import locatorRepo.RolesLocators
import techScore.BaseClass
import com.kms.katalon.core.util.KeywordUtil

import org.openqa.selenium.Keys as Keys

RolesLocators locators = new RolesLocators()
BaseClass commons = new BaseClass()
String Role = "$RoleName"
String ErrorMessage = "$ErrorMessage"
WebUI.click(locators.btnCreateRole())
WebUI.click(locators.drpJobDescription())
commons.dropdown(locators.listJobDescriptions(), Role)
WebUI.click(locators.btnGenerateProfile())
String errMessage = WebUI.getText(locators.txtErrorMessage())

if(errMessage.equals(ErrorMessage)) {
	KeywordUtil.markPassed("Job Role Already Exists")
}
else {
	KeywordUtil.markPassed("Job Role Not Exists")
}