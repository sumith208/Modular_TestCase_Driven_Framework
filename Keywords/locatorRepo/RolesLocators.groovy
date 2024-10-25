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

public class RolesLocators {
	def btnAddRoles(){
		return findTestObject('Object Repository/Page_Roles/btnAddRoles')
	}
	def btnGenerateProfile(){
		return findTestObject('Object Repository/Page_Roles/btnGenerateProfile')
	}
	def drpJobDescription(){
		return findTestObject('Object Repository/Page_Roles/drpJobDescription')
	}
	def inputJobDescription(){
		return findTestObject('Object Repository/Page_Roles/inputJobDescription')
	}
	def listJobDescriptions(){
		return findTestObject('Object Repository/Page_Roles/listJobDescriptions')
	}
	def btnRoles(){
		return findTestObject('Object Repository/Page_Roles/btnRoles')
	}
	def rowRoleName(String RoleName){
		return findTestObject('Object Repository/Page_Roles/rowRoleName',[roleName:RoleName])
	}
	def txtRoleName(){
		return findTestObject('Object Repository/Page_Roles/txtRoleName')
	}
	def btnDeactivateRole(){
		return findTestObject('Object Repository/Page_Roles/btnDeactivateRole')
	}
	def inputDeactivationReason(){
		return findTestObject('Object Repository/Page_Roles/inputDeactivationReason')
	}
	def btnReasonDeactivation(){
		return findTestObject('Object Repository/Page_Roles/btnReasonDeactivation')
	}
	def txtStatus(){
		return findTestObject('Object Repository/Page_Roles/txtStatus')
	}
	def inputSearchBox(){
		return findTestObject('Object Repository/Page_Roles/inputSearchBox')
	}
	def btnCreateRole(){
		return findTestObject('Object Repository/Page_Roles/btnCreateRole')
	}
	def txtErrorMessage(){
		return findTestObject('Object Repository/Page_Roles/txtErrorMessage')
	}
}