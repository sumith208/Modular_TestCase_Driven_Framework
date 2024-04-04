package locatorRepo

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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CandidateLocators {
	def btnRefreshList(){
		return findTestObject('Object Repository/Page_Candidates/CandidatesOptions/btnRefreshList')
	}
	def inputSearchCandidate(){
		return findTestObject('Object Repository/Page_Candidates/CandidatesOptions/inputSearchCandidate')
	}
	def btnAddCandidate(){
		return findTestObject('Object Repository/Page_Candidates/CandidatesOptions/btnAddCandidate')
	}
	def btnSaveCandidate(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/btnSaveCandidate')
	}
	def drpDegree(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/drpDegree')
	}
	def inputEmail(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputEmail')
	}
	def inputFirstName(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputFirstName')
	}
	def inputInternalNotes(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputInternalNotes')
	}
	def inputJobTitle(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputJobTitle')
	}
	def inputLastName(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputLastName')
	}
	def inputLinkedProfile(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputLinkedProfile')
	}
	def inputLocation(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputLocation')
	}
	def inputPhoneNumber(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputPhoneNumber')
	}
	def inputResume(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputResume')
	}
	def inputYears(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/inputYears')
	}
	def listDegree(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/listDegree')
	}
	def txtToastMsg(){
		return findTestObject('Object Repository/Page_Candidates/Page_AddCandidates/txtToastMsg')
	}
}
