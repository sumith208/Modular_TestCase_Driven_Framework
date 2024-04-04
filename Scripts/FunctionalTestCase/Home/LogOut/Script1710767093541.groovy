import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import locatorRepo.HomePageLocators
import techScore.BaseClass as BaseClass

HomePageLocators locate = new HomePageLocators()

BaseClass commons = new BaseClass()

WebUI.click(locate.btnPersonalProfile())

commons.dropdown(locate.listProfileOptions(), 'Log out')

WebUI.closeBrowser()