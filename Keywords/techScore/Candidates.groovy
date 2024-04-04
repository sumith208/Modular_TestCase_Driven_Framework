package techScore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import dataParser.DataParser
import internal.GlobalVariable
import locatorRepo.CandidateLocators

public class Candidates extends BaseClass{
	CandidateLocators locate = new CandidateLocators()
	Home home = new Home()
	DataParser data = new DataParser()

	String empty = ''

	def addCandidates(Map candidateData) {
		WebUI.click(locate.btnAddCandidate())
		WebUI.sendKeys(locate.inputFirstName(), candidateData.get('FirstName'))
		WebUI.sendKeys(locate.inputLinkedProfile(), candidateData.get('LinkedProfile'))
		WebUI.sendKeys(locate.inputLastName(), candidateData.get('LastName'))
		WebUI.sendKeys(locate.inputPhoneNumber(), candidateData.get('PhoneNumber'))
		WebUI.sendKeys(locate.inputEmail(), candidateData.get('EmailAddress'))
		WebUI.sendKeys(locate.inputJobTitle(), candidateData.get('JobTitle'))
		WebUI.click(locate.drpDegree())
		dropdown(locate.listDegree(), candidateData.get('Degree'))
		WebUI.sendKeys(locate.inputYears(), candidateData.get('Experience'))
		WebUI.sendKeys(locate.inputLocation(), candidateData.get('Location'))
		if(candidateData.get('InternalNotes') != empty) {
			WebUI.sendKeys(locate.inputInternalNotes(), candidateData.get('InternalNotes'))
		}else {
			KeywordUtil.logInfo('There is no internal Notes provided')
		}
		WebUI.click(locate.btnSaveCandidate())
		if(verifyText(locate.txtToastMsg(), 'New candidate added')) {
			KeywordUtil.markPassed('The new candidate is added successfully')
		}else {
			KeywordUtil.markFailed('The candidate addition failed')
		}
	}
}
