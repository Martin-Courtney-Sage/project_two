import unittest

from behave import given, when, then
from selenium.webdriver.chrome.webdriver import WebDriver

from features.pages.bank_home import BankHomePage


@given('The User is on our project Home Page')
def get_to_bank_home(context):
    driver: WebDriver = context.driver
    driver.get('C:\Users\Gabriel Charles\Desktop\Revature\Training\Classwork\VisualStudioCode\HTMLCSS\BankWelcomePage.html')


@when('The User clicks on Login/Signup')
def nav_to_login(context):
    bank_home: BankHomePage = context.bank_home
    bank_home.login().click()


@then('The User should be on the Login/Register Home Page')
def verify_on_login(context):
    driver: WebDriver = context.driver
    # assert driver.title == "Bank, the bank of the future"
    context.unittest.assertEquals(driver.title, "Revature Bank, Bank of the future")