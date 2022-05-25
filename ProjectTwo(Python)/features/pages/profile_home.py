from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By


class ProfileHomePage:

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def profile(self):
        return self.driver.find_element(by=By.ID, value="profile-page")
