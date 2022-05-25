import unittest
from behave import given, when, then
from selenium.webdriver.chrome.webdriver import WebDriver
from features.pages.profile_home import ProfileHomePage


@given('The users are on the Home Page')
def get_to_home(context):
    pass


@when('The users navigate using the Nav Bar and click on the Customer Center button/link')
def nav_to_customer_center(context):
    pass


@then('The users will be directed to the Customer Center Page')
def verify_on_customer_center(context):
    pass
