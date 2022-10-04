package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utility.wait;

public class BookATestDrivePage extends BasePage implements wait {

    By firstName = By.cssSelector("#input_first_name");
    By lastName = By.cssSelector("#input_last_name");
    By emailAddress = By.cssSelector("#input_email_address");
    By phoneNumber = By.cssSelector("#input_phone_number");
    By preferredDate = By.cssSelector("#datepicker_preferred_date");
    By preferredTimeList = By.cssSelector("[data-id='select_preferred_time'] > :nth-child(1) > .choices > .choices__inner > .choices__list");
    By saleConsultantList = By.cssSelector("[data-id='select_preferred_sales_consultant'] > :nth-child(1) > .choices > .choices__inner > .choices__list");
    By saleConsultantValue = By.cssSelector("div[class='choices__list choices__list--dropdown is-active'] div[id='choices--select_preferred_sales_consultant-item-choice-3']");
    By paxList = By.cssSelector("[data-id='select_pax'] > :nth-child(1) > .choices > .choices__inner > .choices__list");
    By paxValue = By.cssSelector("div[class='choices__list choices__list--dropdown is-active'] div[id='choices--select_pax-item-choice-3']");
    By testDriveOption = By.cssSelector("div:nth-child(10) > div > div.choices > div.choices__inner > div > div");
    By drivingLicenseCheckBox = By.cssSelector("#checkbox_driving_license");
    By termsConditionCheckBox = By.cssSelector("#checkbox_terms_conditions");
    By privacyPolicyCheckBox = By.cssSelector("#checkbox_privacy_policy");
    By marketingInformationCheckBox = By.cssSelector("#checkbox_marketing");
    By submitButton = By.cssSelector("button[class='mdc-button mdc-button--unelevated cta__dialog_form']");

    By selectedPreferredModel = By.cssSelector("div[class='choices__list choices__list--multiple'] div[class='choices__item choices__item--selectable']");

    public BookATestDrivePage(WebDriver driver) {
        super(driver);
    }

    public void setCountryCode(String countryCode) {
        clickOnElement(By.cssSelector("div[class='iti__arrow']"));
        clickOnElement(By.xpath("//span[@class='iti__dial-code'][contains(text(), '" + countryCode + "')]"));

    }
    public void selectPreferredDate(String preferredDateValue) {
        String elementOne = "[aria-label='";
        selectAValueFromList(preferredDateValue, elementOne, preferredDate);
    }

    public void selectPreferredTime(String preferredTimeValue) {
        String elementOne = "div:nth-child(6) > div > div.choices > div.choices__list.choices__list--dropdown > div > div[data-value='";
         selectAValueFromList(preferredTimeValue, elementOne, preferredTimeList);
    }

    public void selectTestDriveOption(String testDriveValue) {
        String elementOne = "div:nth-child(10) > div > div.choices > div.choices__list.choices__list--dropdown > div > div[data-value='";
        selectAValueFromList(testDriveValue, elementOne, testDriveOption);
    }

    public void selectAValueFromList(By locator1, By locator2) {
        clickOnElement(locator1);
        waitForElementToBeVisible(driver, locator2);
        clickOnElement(locator2);
    }

    public void bookATestDrive(String firstNameValue,String lastNameValue, String emailAddressValue,
                               String countryCode, String phoneNumberValue, String preferredDateValue, String preferredTimeValue,
                               String testDriveOption) {
        waitForElementToBeVisible(driver, firstName);
        scrollToTheElement(firstName);
        setElementText(firstName, firstNameValue);
        setElementText(lastName, lastNameValue);
        setElementText(emailAddress, emailAddressValue);
        setCountryCode(countryCode);
        setElementText(phoneNumber, phoneNumberValue);

        selectPreferredDate(preferredDateValue);
        selectPreferredTime(preferredTimeValue);
        selectAValueFromList(saleConsultantList, saleConsultantValue);
        selectAValueFromList(paxList, paxValue);
        selectTestDriveOption(testDriveOption);
        if(testDriveOption.equalsIgnoreCase("lexus-test-drive-concierge")){
            clickOnElement(drivingLicenseCheckBox);
            clickOnElement(termsConditionCheckBox);
        }
        clickOnElement(privacyPolicyCheckBox);
        clickOnElement(marketingInformationCheckBox);
    }

    public boolean isBookATestDriveButtonIsEnable() {
        waitForElementToBeVisible(driver, submitButton);
        return isElementEnable(submitButton);
    }

    public String selectedPreferredModel() {
        String originalText = this.getElementText(selectedPreferredModel);
        return originalText.replace("Remove item", "");
    }

}
