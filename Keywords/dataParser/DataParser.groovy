package dataParser

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
import techScore.BaseClass

public class DataParser extends BaseClass{
	TestData candidateData = findTestData(CANDIDATEDATA)
	TestData roleData = findTestData(ROLESDATA)
	def getTestData (TestData data,String refColumn,String refKey) {
		List<String> columns = data.getColumnNames()
		Map<String,String> dataMap = new HashMap<String,String>()
		for(int rowNo=1; rowNo<=data.getRowNumbers(); rowNo++) {
			if(data.getValue(refColumn,rowNo).equalsIgnoreCase(refKey)) {
				for(String column : columns) {
					dataMap.put(column, data.getValue(column,rowNo))
				}
				break
			}
		}
		return dataMap
	}

	def candidateData(String candidateName) {
		return getTestData(candidateData,'Name',candidateName)
	}

	def rolesData(String roleName) {
		return getTestData(roleData, 'RoleName', roleName)
	}
}
