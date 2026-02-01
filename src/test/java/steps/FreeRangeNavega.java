package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

import java.util.Arrays;
import java.util.List;

public class FreeRangeNavega {

    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("^(?:I|The user|The client) selects? Elegir Plan$")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }

    @And("^(?:I|The user|The client) selects? Introducción al Testing$")
    public void navigateToIntro() {
        cursosPage.clickIntroduccionTestingLink();

    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 14 productos",
                "Academia: $176 / año • 14 productos", "Free: Gratis • 2 productos");

        Assert.assertEquals(lista, listaEsperada);
    }

    //Y así se ven (exactamente como las assertions comunes, pero con el potente assertAll(); al final!
//    public void Ejemplulis() {
//        String palabraEsperada = "Pepe";
//        String palabraEncontrada = "Papa";

        // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar muchas cosas pequeñas a la vez.
//        soft.assertEquals(palabraEsperada, palabraEncontrada);
//        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
//        soft.assertNotEquals(palabraEncontrada,palabraEsperada);
//
//        soft.assertAll();
    //}

}
