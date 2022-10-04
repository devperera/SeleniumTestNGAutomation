package pages.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface wait {

    public default void waitForElementToBeVisible(WebDriver driver, By locator){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(15000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
