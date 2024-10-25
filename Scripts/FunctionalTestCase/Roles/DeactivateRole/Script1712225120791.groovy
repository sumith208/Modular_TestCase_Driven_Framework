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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import locatorRepo.RolesLocators

import org.openqa.selenium.Keys as Keys

String roleName = "${RoleName}"
String reason = "${Reason}"
String StatusVar = "${Status}"


RolesLocators locators = new RolesLocators()
WebUI.click(locators.btnRoles())
WebUI.click(locators.rowRoleName(roleName))
WebUI.switchToWindowIndex(1);
String role = WebUI.getText(locators.txtRoleName())

if(role.contains(roleName)) {
	KeywordUtil.markPassed("Navigated Succesfully to Role Page")
}
else {
	KeywordUtil.markFailed("Not Navigated Succesfully to Role Page")
}
WebUI.enhancedClick(locators.btnDeactivateRole())
WebUI.setText(locators.inputDeactivationReason(), reason)
WebUI.click(locators.btnReasonDeactivation())
String Status = WebUI.getText(locators.txtStatus())

if(Status.equals(StatusVar)) {
	KeywordUtil.markPassed("Deactivated Sucessfully")
}
else {
	KeywordUtil.markFailed("Not Deactivated Sucessfully")
	
}

