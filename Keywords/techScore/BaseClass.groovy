package techScore

import java.text.SimpleDateFormat
import java.time.Clock
import java.time.temporal.ChronoUnit

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

/**
 * This Class consist of all the functional common keywords independent on locators. These keywords are not dependent on UI.
 * @author Srivachan A
 *
 */
public class BaseClass extends GlobalVariable {
	
	/**
	 * This Keyword is to launch a url and maximize the window
	 * @param url is application needs to be launched
	 * @return
	 */
	@Keyword
	def launchApplication(String url) {
		try {
			WebUI.navigateToUrl(url)
			WebUI.deleteAllCookies()
			KeywordUtil.logInfo('Application launched successfully in the existing driver')
			Mobile.takeScreenshot()
			return true
		} catch (BrowserNotOpenedException) {
			WebUI.openBrowser('')
			WebUI.deleteAllCookies()
			WebUI.navigateToUrl(url)
			WebUI.setViewPortSize(1294, 768)
			KeywordUtil.logInfo('Application launched successfully by creating new driver session')
			WebUI.takeScreenshot()
			return false
		}
	}

	/**
	 * This Keyword is select one option from the list of Options
	 * @param element is locator of the list of Options
	 * @param option is value which needs to be selected
	 * @return
	 */
	@Keyword
	def dropdown(TestObject element,String option) {
		List<WebElement> dropdown = WebUI.findWebElements(element,TIMEOUT_MEDIUM)
		Boolean dropdownStatus = false
		for (int i = 0; i<dropdown.size(); i++) {
			WebElement dropdownValue = dropdown.get(i)
			if (dropdownValue.getText().equalsIgnoreCase(option)) {
				WebUI.enhancedClick(WebUI.convertWebElementToTestObject(dropdownValue))
				dropdownStatus =  true
				break
			}
		}
		return dropdownStatus
	}

	/**
	 * This Keyword is to get the text from the web element and compare with provided value
	 * @param element is the locator of the text web element
	 * @param expected is the expected text
	 * @param expected is the expected text
	 * @return boolean
	 */
	@Keyword
	def verifyText(TestObject element, String expected ) {
		try {
			String messageText = WebUI.getText(element)
			boolean value = messageText.equals(expected)
			if (value) {
				KeywordUtil.logInfo("The Prompt is present as expected as "+messageText)
				return true
			} else if (messageText == null) {
				KeywordUtil.logInfo("Has no Error Prompt ")
				return false
			} else {
				KeywordUtil.logInfo("Expected prompt:- "+ expected +" Actual prompt:- "+ messageText)
				return false
			}
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.logInfo(e.message)
		}
	}

	/**
	 * This Keyword is to generate a random four digit number and convert that into a String value
	 * @return String
	 */
	def String generateRandomCode() {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(2000)
		String randomCode = (rand_int1).toString()
		return randomCode
	}

	/**
	 * This Keyword is to get the text from disabled input field or some embedded text field
	 * @param text is locator of the webElement of the field.
	 * @return String
	 */
	def String getEmbeddedText(TestObject text) {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor)driver
		WebElement textElement = WebUI.findWebElement(text,5)
		String value = (String)js.executeScript("return arguments[0].value", textElement)
		KeywordUtil.markPassed('Embedded text is '+ value)
		return value
	}

	/**
	 * This Keyword is to export a data from the scripts to the Excel file
	 * @param fileName is the name of the excel file where the data has to be exported
	 * @param sheetName is the name of the sheet from the excel file where the data has to be exported
	 * @param rowNum is the int value of row where the data has to be exported
	 * @param column is the name of the column where the data has to be exported
	 * @param output is value that needs to be exported
	 */
	def exportData(String fileName,String sheetName,int rowNum,String column,String output) {
		FileInputStream fis = new FileInputStream(RunConfiguration.getProjectDir()+'/Resources/TestData/'+fileName+'.xlsx')
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		int lastCell = workbook.getSheet(sheetName).getRow(0).getLastCellNum()
		int colIndex = 0
		for (int colNum = 0;colNum<lastCell;colNum++) {
			String header = workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue()
			if (header.equalsIgnoreCase(column)) {
				colIndex = colNum
				break
			}
		}
		workbook.getSheet(sheetName).getRow(rowNum).createCell(colIndex).setCellValue(output)
		FileOutputStream fos = new FileOutputStream(RunConfiguration.getProjectDir()+'/Resources/TestData/'+fileName+'.xlsx')
		workbook.write(fos)
		workbook.close()
	}

	/**
	 * This Keyword is to get the exported data from the scripts to the Excel file
	 * @param fileName is the name of the excel file where the data has exported
	 * @param sheetName is the name of the sheet from the excel file where the data has exported
	 * @param rowNum is the int value of row where the data has exported
	 * @param column is the name of the column where the data has exported
	 * @return String
	 */
	@Keyword
	public String getExportedData(String fileName,String sheetName,int rowNum,String column) {
		FileInputStream fis = new FileInputStream(RunConfiguration.getProjectDir()+'/Resources/TestData/'+fileName+'.xlsx')
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		int lastCell = workbook.getSheet(sheetName).getRow(0).getLastCellNum()
		int colIndex =0
		for(int colNum=0;colNum<lastCell;colNum++) {
			String header = workbook.getSheet(sheetName).getRow(0).getCell(colNum).getStringCellValue()
			if(header.equalsIgnoreCase(column)) {
				colIndex = colNum
				break
			}
		}
		String exportedData =workbook.getSheet(sheetName).getRow(rowNum).getCell(colIndex).getStringCellValue()
		workbook.close()
		return exportedData
	}

	/**
	 * This Keyword is to verify the text is presented in the list of elements
	 * @param element is the locator of list of the text element
	 * @param expected is the text that needs to be verified
	 * @return boolean
	 */
	@Keyword
	def multiTextVerification(TestObject element, String expected ) {
		List<WebElement> texts = WebUI.findWebElements(element,TIMEOUT_MEDIUM)
		for(int i=0;i<texts.size();i++) {
			WebElement text=texts.get(i);
			if(expected.equalsIgnoreCase(text.getText())) {
				if (expected.equals(text.getText())) {
					KeywordUtil.markPassed(expected +' is enabled')
					return true
				} else {
					KeywordUtil.markFailed(expected +' is disabled')
					return false
				}
			}
		}
	}

	/**
	 * This method split the string as per ;
	 * @param value: String which needs to be split.
	 * @param noOfValue: Number of values needs to be split.
	 * @return String
	 */
	@Keyword
	def getSplitValue(String value, int noOfValue) {
		try {
			List<String> values = value.split(';')
			return values.get(noOfValue-1)
		} catch (IllegalArgumentException e) {
			e.printStackTrace()
		}
	}

	/**
	 * This Keyword is to get the selection status of the checkbox or radiobutton.
	 * @param locator is web element's locator.
	 * @return boolean
	 */
	@Keyword
	def verifySelection(TestObject locator) {
		WebElement webElement = WebUI.findWebElement(locator,5)
		WebDriver driver = new DriverFactory().getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String content = (String) js.executeScript("return window.getComputedStyle(arguments[0],'::after').getPropertyValue('content')", webElement)
		boolean status = content.equals('none')
		if(status == true) {
			return false
		}else if (status == false) {
			return true
		}
	}

	/**
	 * This Keyword is to get the text value of the input field.
	 * @param field is the locator of webelement of the field.
	 * @return String
	 */
	def getInputFieldValue(TestObject field) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement fields = WebUI.findWebElement(field,TIMEOUT_SHORT)
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String valueFromId = js.executeScript("return arguments[0].value",fields)
			return valueFromId
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * This keyword is used to verify the expected option present in the dropdown or not.
	 * @param dropdown is the locator of the dropdown from the UI.
	 * @param text is the expected option which needs to be verify.
	 * @return boolean
	 */
	@Keyword
	def verifyMessagesInDropDown(TestObject dropdown,String text) {
		try {
			WebElement element = WebUI.findWebElement(dropdown,TIMEOUT_MEDIUM)
			List<String> optionText = new ArrayList<String>()
			Select se = new Select(element)
			List<WebElement>options=se.getOptions()
			for(WebElement option : options) {
				optionText.add(option.getText())
			}
			if (optionText.contains(text)) {
				return true
			}
		} catch  (Exception e) {
			e.printStackTrace()
			KeywordUtil.logInfo(e.message)
		}
	}

	/**
	 * This keyword is to get the status of radio button whether it's toggle or not
	 * @param locator is web element's locator.
	 * @return boolean
	 */
	def verifyToggle(TestObject locator) {
		WebElement webElement = WebUI.findWebElement(locator,5)
		WebDriver driver = new DriverFactory().getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String content = (String) js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')", webElement)
		boolean status = content.equals('none')
		if (status) {
			return false
		} else{
			return true
		}
	}


	/**
	 * This keyword is use to format date
	 * @param format
	 * @param dateAndTime
	 * @return boolean
	 */
	def simpleDateFormat(String format, String dateAndTime) {
		try {
			SimpleDateFormat timeformat = new SimpleDateFormat(format)
			Date javaDate = timeformat.parse(dateAndTime)
			return true
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.logInfo(e.message)
			return false
		}
	}
	
	/**
	 * To get index of row from sheet data
	 * @param input
	 * @return integer
	 */
	def indexParser(def input) {
		if(input != null) {
			return input
		}else {
			return 1
		}
	}
	
	/**
	 * This method automates navigating to current tab.
	 * @return boolean
	 */
	def navigateToCurrentTab() {
		try {
			def currentWindow =  WebUI.getWindowIndex()
			WebUI.switchToWindowIndex(0)
		} catch (Exception e) {
			e.printStackTrace()
			KeywordUtil.logInfo(e.message)
			return false
		}
	}

	/**
	 * This Keyword is to click on the element using javascript
	 * @param locator is the testobject needs to be clicked
	 * @return null
	 */
	@Keyword
	def click(TestObject locator) {
		try {
			WebElement webElement = WebUI.findWebElement(locator,5)
			WebDriver driver = new DriverFactory().getWebDriver()
			JavascriptExecutor js = (JavascriptExecutor)driver
			js.executeScript("arguments[0].click();", webElement)
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * This keyword is to clear text of the field
	 * @param locator of the element needs cleared
	 * @return
	 */
	@Keyword
	def clearText(TestObject locator) {
		try {
			WebElement element = WebUiCommonHelper.findWebElement(locator,5)
			element.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE))
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * This Keyword is to click on the element using actions class
	 * @param locator is the test object needs to be clicked
	 * @return null
	 */
	@Keyword
	def mouseClick(TestObject locator) {
		try {
			WebElement webElement = WebUI.findWebElement(locator,5)
			WebDriver driver = new DriverFactory().getWebDriver()
			Actions act = new Actions(driver)
			act.moveToElement(webElement).click(webElement).build().perform()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * This Keyword is to pick the from current UTC time to Future or Past
	 * @param unit if the unit of time like seconds,minutes...
	 * @param numberOfUnit is counts of the unit needs to be add
	 * @return String
	 */
	@Keyword
	def dataAndTimePickerUTC(String unit,int numberOfUnit ) {
		try {
			if(unit.equalsIgnoreCase('Now')) {
				return Clock.systemUTC().instant().toString()
			}else if(unit.equalsIgnoreCase('Minutes')){
				return Clock.systemUTC().instant().plus(numberOfUnit,ChronoUnit.MINUTES).toString()
			}else if(unit.equalsIgnoreCase('Seconds')) {
				return Clock.systemUTC().instant().plus(numberOfUnit,ChronoUnit.SECONDS).toString()
			}else if(unit.equalsIgnoreCase('Hours')) {
				return Clock.systemUTC().instant().plus(numberOfUnit, ChronoUnit.HOURS).toString()
			}else if(unit.equalsIgnoreCase('Days')) {
				return Clock.systemUTC().instant().plus(numberOfUnit, ChronoUnit.DAYS).toString()
			}else if(unit.equalsIgnoreCase('Past')){
				return Clock.systemUTC().instant().minus(numberOfUnit,ChronoUnit.MINUTES).toString()
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
}
