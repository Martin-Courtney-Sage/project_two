from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By


# Page Object Model - POM
class BankHomePage:

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def login(self):
        return self.driver.find_element(by=By.ID, value="login-page")

    def searchbar(self):
        return self.driver.find_element(by=By.ID, value="recherchegoogle")

    def search_btn(self):
        return self.driver.find_element(by=By.XPATH, value='/html/body/div[2]/form/input/text')