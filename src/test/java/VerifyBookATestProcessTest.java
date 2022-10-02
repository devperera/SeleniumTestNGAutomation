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
        bookATestDrivePage.bookATestDrive("Dev", "Perera", "dev@dev.com",
        "778896658","October 6, 2022","10:00");
        Assert.assertTrue(bookATestDrivePage.isBookATestDriveButtonIsEnable());
      }
}
