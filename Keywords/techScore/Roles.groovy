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
import locatorRepo.RolesLocators

public class Roles extends BaseClass {
	RolesLocators locate = new RolesLocators()
	Home home = new Home()
	DataParser data = new DataParser()
	String empty = ''

	def addRoles(Map rolesData) {
		WebUI.click(locate.btnAddRoles())
		if(rolesData.get('RoleType')!= empty) {
			WebUI.click(locate.drpJobDescription())
			dropdown(locate.listJobDescriptions(), rolesData.get('RoleType'))
		}else {
			KeywordUtil.logInfo('Job Type is not provided')
		}
		if(rolesData.get('JobDescription')!= empty) {
			WebUI.setText(locate.inputJobDescription(),rolesData.get('JobDescription'))
		}else {
			KeywordUtil.logInfo('There is no job description provided')
		}
		WebUI.click(locate.btnGenerateProfile())
	}
}
