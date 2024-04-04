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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import dataParser.DataParser
import internal.GlobalVariable
import locatorRepo.HomePageLocators

public class Home extends BaseClass{

	HomePageLocators locate = new HomePageLocators()

	def loginTechScore(String Url,UserName,Password) {
		launchApplication(Url)
		WebUI.sendKeys(locate.inputUserEmail(),UserName)
		WebUI.sendKeys(locate.inputPassword(),Password)
		WebUI.click(locate.btnSubmit())
	}

	def navToTabs(String option) {
		dropdown(locate.listNavTabs(), option)
	}

	def logout() {
		WebUI.click(locate.btnPersonalProfile())
		dropdown(locate.listProfileOptions(), "Log out")
		WebUI.closeBrowser()
	}
}
