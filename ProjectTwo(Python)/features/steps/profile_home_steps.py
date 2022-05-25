import unittest
from behave import given, when, then
from selenium.webdriver.chrome.webdriver import WebDriver
from features.pages.profile_home import ProfileHomePage


@given('The User is on the Profile Page')
def get_to_profile(context):
    pass


@when('The User fills out the fields and clicks on the Create Account button')
def user_creates_account(context):
    pass


@then('The User shall have a new account created and returned in the table below')
def verify_table_return(context):
    pass


@when('The User clicks the Delete Account button')
def user_deletes_account(context):
    pass


@then('The webpage will notify the User that the account has been deleted')
def verify_account_deletion(context):
    pass


@when('The User selects an account and the amount they wish to withdraw, then clicks the Withdraw button')
def withdraw_funds(context):
    pass


@then('The account will update and return the new information to the User reflecting the changes')
def update_funds(context):
    pass


@when('The User selects an account and the amount they wish to deposit, then clicks the Deposit button')
def deposit_funds(context):
    pass


@when('The User selects the accounts they wish to transfer money between and the desired amount,'
      'then clicks the Transfer button')
def transfer_funds(context):
    pass


@then('Then the accounts will update and return the new information to the User reflecting the changes')
def update_both_funds(context):
    pass

