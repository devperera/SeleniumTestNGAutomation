import org.testng.Assert;
import org.testng.annotations.*;
import pages.LexusHomePage;
import pages.RXModelPage;
public class VerifyRXModelGalleryTest extends BaseTest {
    LexusHomePage lexusHomePage;
    RXModelPage rxModelPage;
    @Test
    public void verifyRXModelGalleryExistsTest() {
        lexusHomePage = new LexusHomePage(getDriver());
        lexusHomePage = lexusHomePage.openPage("https://www.lexus.com.sg");
        lexusHomePage.acceptAllCookies();
        lexusHomePage.selectRXModel();
        rxModelPage = new RXModelPage(getDriver());
        Assert.assertTrue(rxModelPage.isRXModelGalleryExist(), "RX Model Gallery Not Exsiste!");

    }
}
