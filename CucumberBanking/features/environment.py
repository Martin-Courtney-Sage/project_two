import unittest
from selenium import webdriver
from selenium.webdriver.chrome.webdriver import WebDriver

from features.pages.bank_home import BankHomePage


def before_all(context):
    driver: WebDriver = webdriver.Chrome(
        "C:/Users/Gabriel Charles/Desktop/Revature/Training/SileniumExample/chromedriver.exe")
    bank_home_page = BankHomePage(driver)

    test = unittest.TestCase()

    context.driver = driver
    context.bank_home = bank_home_page
    context.unittest = test
    print("started")


def after_all(context):
    context.driver.quit()
    print("ended")
