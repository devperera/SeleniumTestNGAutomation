package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RXModelPage extends BasePage {

    By rXModelGalary = By.cssSelector(".swiper-slide-active > .link_lightbox > .slider__gallery_ar > .lazy");
    By bookATestDriveButton = By.cssSelector(":nth-child(4) > :nth-child(1) > .mdc-button");
    public RXModelPage(WebDriver driver){
        super(driver);
    }

    public boolean isRXModelGalleryExist() {
        scrollToTheElement(rXModelGalary);
        return isElementExist(rXModelGalary);
    }

    public void selectBookATestDrive() {
        scrollToTheElement(bookATestDriveButton);
        clickOnElement(bookATestDriveButton);
    }

}
