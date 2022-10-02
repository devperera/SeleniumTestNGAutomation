package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.utility.wait;

public class BasePage implements wait {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15000), this);
    }

    protected void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void setElementText(By locator, String textValue) {
        driver.findElement(locator).sendKeys(textValue);
    }

    public LexusHomePage openPage(String url) {
      driver.get(url);
      return new LexusHomePage(driver);
    }

    public void scrollToTheBottomOfThePage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void scrollToTheElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public boolean isElementExist(By locator) {
        if(driver.findElements(locator).size() > 0) {
            return true;
        }
        return false;
    }

    public void selectAValueFromList(String selectValue, String elementString1, By listLocator) {
        By selectLocator = By.cssSelector(elementString1 + selectValue + "']");
        clickOnElement(listLocator);
        waitForElementToBeVisible(driver, selectLocator);
        driver.findElement(selectLocator).click();
    }

    public boolean isElementEnable(By locator) {
        if(driver.findElement(locator).isEnabled()){
            return true;
        } else {
            return false;
        }
    }

}
