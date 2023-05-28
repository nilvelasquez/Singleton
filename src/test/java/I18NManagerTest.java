import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import edu.upc.eetac.dsa.I18NManager;
import java.util.MissingResourceException;

public class I18NManagerTest {

    I18NManager i18n;

    @Before
    public void setUp() throws Exception {

        this.i18n = I18NManager.getInstance();
    }

    @After
    public void tearDown() {

            this.i18n.getInstance().clear();
        }

    @Test
    public void testGetText() throws Exception {

        String msg1 = I18NManager.getInstance().getText("ca", "l1");
        Assert.assertEquals("hola", msg1);

        String msg1Bis = I18NManager.getInstance().getText("ca", "l1");
        Assert.assertEquals("hola", msg1Bis);

        String msg2 = I18NManager.getInstance().getText("ca", "l2");
        Assert.assertEquals("adeu", msg2);

        String msg3 = I18NManager.getInstance().getText("es", "l2");
        Assert.assertEquals("adios", msg3);

        String msg4 = I18NManager.getInstance().getText("pt", "l1");
        Assert.assertEquals("obrigado", msg4);
    }

    @Test
    public void testIt() {

        String msgIt = I18NManager.getInstance().getText("it", "l1");
        Assert.assertEquals("ciao", msgIt);
    }

    @Test(expected = MissingResourceException.class)
    public void testGetTextBundleNotFound() throws Exception {

        String msg1 = I18NManager.getInstance().getText("ca", "l1");
        Assert.assertEquals("hola", msg1);

        String msg2 = I18NManager.getInstance().getText("ca", "l2");
        Assert.assertEquals("adeu", msg2);

        String msg3 = I18NManager.getInstance().getText("XX", "l2");
    }
}