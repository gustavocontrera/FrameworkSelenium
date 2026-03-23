package varios.clase16.Test;

import varios.clase16.PageObject.SalesforceCRMPage;
import varios.clase16.PageObject.SalesforceLandingPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalesforceCRMTest extends BaseTest {

    @Test
    public void CRMTest() throws InterruptedException {
        //WebElement elementoCRM = driver.findElement(By.xpath("//*[@href='/mx/crm/']"));
        //elementoCRM.click();
        SalesforceCRMPage salesforceCRMPage = salesforceLandingPage.goToCRMPage();
        //WebElement QueEsUnCrmH1 = driver.findElement(By.id("que-es-crm"));
        //System.out.println("===> " + QueEsUnCrmH1.getText());
        String crmText = salesforceCRMPage.getQueEsCRMText();
        Assert.assertEquals(crmText, "¿Qué es CRM?", "Se esperaba otro texto!!");

        /*boolean encontreLinkPrivacidad = false;
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for (WebElement link : listaLinks) {
            if (link.getText().isEmpty() == false) {
                System.out.println(" ** link:  " + link.getText());
                if (link.getText().equals("Privacidad")){
                    encontreLinkPrivacidad = true;
                }
            }
        }*/
        boolean encontreLinkPrivacidad = salesforceCRMPage.buscarLink("Privacidad");
        Assert.assertTrue(encontreLinkPrivacidad);
    }




}
