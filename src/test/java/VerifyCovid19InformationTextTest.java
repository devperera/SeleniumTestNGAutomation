import org.testng.Assert;
import org.testng.annotations.*;
import pages.LexusHomePage;
public class VerifyCovid19InformationTextTest extends BaseTest {
    LexusHomePage lexusHomePage;

    @Test
    public void verifyCovid19InformationText() {
        lexusHomePage = new LexusHomePage(getDriver());
        lexusHomePage = lexusHomePage.openPage("https://www.lexus.com.sg");
        lexusHomePage.acceptAllCookies();
        lexusHomePage.scrollToTheBottomOfThePage();
        lexusHomePage.selectCovidInforLInk();
        Assert.assertEquals(lexusHomePage.getElementTextOfCovidText(), "IMPORTANT COVID-19 INFORMATION");
    }

}
