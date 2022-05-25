from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By


class WelcomePage:

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def home(self):
        return self.driver.find_element(by=By.ID, value="home-page")
