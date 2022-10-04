import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookATestDrivePage;
import pages.LexusHomePage;
import pages.RXModelPage;
public class VerifyBookATestProcessTest extends BaseTest {
    LexusHomePage lexusHomePage;
    RXModelPage rxModelPage;
    BookATestDrivePage bookATestDrivePage;

    @Test
    public void verifyBookATestProcess() {
        lexusHomePage = new LexusHomePage(getDriver());
        lexusHomePage = lexusHomePage.openPage("https://www.lexus.com.sg");
        lexusHomePage.acceptAllCookies();
        lexusHomePage.selectRXModel();
        rxModelPage = new RXModelPage(getDriver());
        rxModelPage.selectBookATestDrive();
        bookATestDrivePage = new BookATestDrivePage(getDriver());
        Assert.assertEquals(bookATestDrivePage.selectedPreferredModel(),"RX 300","Expected test Not match with actual text!");
        bookATestDrivePage.bookATestDrive("CPL", "Test", "qa@convertium.com","+65",
        "91234567","October 6, 2022","18:00", "lexus-test-drive-concierge");
        Assert.assertTrue(bookATestDrivePage.isBookATestDriveButtonIsEnable());
      }
}

