import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('FunctionalTestCase/Home/Login'), ["Url":GlobalVariable.TECHSCOREURL,"UserName":GlobalVariable.USERNAME, "Password":GlobalVariable.PASSWORD], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FunctionalTestCase/Home/NavigationToTabs'), [('option') : 'Candidates'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FunctionalTestCase/Candidates/AddCandidates'), [('candidateName') : 'TestUser1'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FunctionalTestCase/Home/LogOut'), [:], FailureHandling.STOP_ON_FAILURE)

