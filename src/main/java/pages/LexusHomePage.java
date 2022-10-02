package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LexusHomePage extends BasePage {

    By acceptAllCookies = By.cssSelector("#consent_prompt_submit");
    By covidInfor = By.xpath("//a[text()='COVID-19 Information']");
    By covidInforText = By.cssSelector("header[class='layout_grid_cell_10']");
    By selectRXModel = By.cssSelector(".sec__index_explore > :nth-child(1) > .tab__panels_main > .panel--active > .tab__panels_sub > .subpanel--active > .tab__item_models > .is_wider > .tab__item_model > .tab__item_txt");

    public LexusHomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptAllCookies() {
        clickOnElement(acceptAllCookies);
    }

    public void selectCovidInforLInk() {
        clickOnElement(covidInfor);
    }

    public String getElementTextOfCovidText() {
        return getElementText(covidInforText);
    }

    public void selectRXModel() {
        clickOnElement(selectRXModel);
    }

}
