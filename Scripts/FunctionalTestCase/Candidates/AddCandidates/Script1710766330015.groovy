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

import dataParser.DataParser
import internal.GlobalVariable
import locatorRepo.CandidateLocators
import techScore.BaseClass
import techScore.Home

import org.openqa.selenium.Keys as Keys
CandidateLocators locate = new CandidateLocators()
BaseClass commons = new BaseClass()
DataParser data = new DataParser()
String empty = ''
Map candidateData = data.candidateData(${candidateName})
WebUI.click(locate.btnAddCandidate())
WebUI.sendKeys(locate.inputFirstName(), candidateData.get('FirstName'))
WebUI.sendKeys(locate.inputLinkedProfile(), candidateData.get('LinkedProfile'))
WebUI.sendKeys(locate.inputLastName(), candidateData.get('LastName'))
WebUI.sendKeys(locate.inputPhoneNumber(), candidateData.get('PhoneNumber'))
WebUI.sendKeys(locate.inputEmail(), candidateData.get('EmailAddress'))
WebUI.sendKeys(locate.inputJobTitle(), candidateData.get('JobTitle'))
WebUI.click(locate.drpDegree())
commons.dropdown(locate.listDegree(), candidateData.get('Degree'))
WebUI.sendKeys(locate.inputYears(), candidateData.get('Experience'))
WebUI.sendKeys(locate.inputLocation(), candidateData.get('Location'))
if(candidateData.get('InternalNotes') != empty) {
	WebUI.sendKeys(locate.inputInternalNotes(), candidateData.get('InternalNotes'))
}else {
	KeywordUtil.logInfo('There is no internal Notes provided')
}
WebUI.click(locate.btnSaveCandidate())
if(commons.verifyText(locate.txtToastMsg(), 'New candidate added')) {
	KeywordUtil.markPassed('The new candidate is added successfully')
}else {
	KeywordUtil.markFailed('The candidate addition failed')
}