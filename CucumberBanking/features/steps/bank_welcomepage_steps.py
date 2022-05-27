import unittest

from behave import when, then

from features.pages.bank_home import BankHomePage


@when('The User types {word} in the search bar')
def types_into_searchbar(context, word):
    bank_home: BankHomePage = context.bank_home
    bank_home.searchbar().send_keys(word)


@when('The User clicks the search button')
def press_search_btn(context):
    bank_home: BankHomePage = context.bank_home
    bank_home.search_btn().click()


@then('The title should be {title}')
def verify_title_page(context, title):
    test: unittest.TestCase = context.unittest
    test.assertEquals(context.driver.title, title)
