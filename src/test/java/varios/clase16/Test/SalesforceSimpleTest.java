package varios.clase16.Test;

import varios.clase16.PageObject.SalesforceLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SalesforceSimpleTest extends BaseTest {

    @Test
    public void salesforceFirstTest(){

        Assert.assertEquals(salesforceLandingPage.getPageTitle(), "Salesforce: CRM, Ventas, Marketing, Servicios y más", "Se esperaba otro titulo");
        Assert.assertEquals(salesforceLandingPage.getPageUrl(), "https://www.salesforce.com/mx/?ir=1", "Se esperaba otra URL");
        //WebElement elementoH1 = driver.findElement(By.tagName("h1"));

        Assert.assertEquals(salesforceLandingPage.getH1Text(),"Construye relaciones con los clientes que impulsen tu negocio", "Se esperaba otro h1" );

        boolean encontreTextoBuscado = salesforceLandingPage.searchText("¿Qué hay de nuevo en Salesforce?");
        /*List<WebElement> listaTextos = driver.findElements(By.className("header-text"));
        Assert.assertFalse(listaTextos.isEmpty());

        boolean encontreTextoBuscado = false;
        for (WebElement texto : listaTextos) {
            System.out.println("===> " + texto.getText());
            if (texto.getText().equals("¿Qué hay de nuevo en Salesforce?")){
                encontreTextoBuscado = true;
            }
        }*/
        Assert.assertTrue(encontreTextoBuscado);
    }

}
