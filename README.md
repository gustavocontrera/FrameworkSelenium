
# Tipos de Assertions con TestNG: Recurso

## 1. assertEquals

Verifica que dos valores sean iguales.

`Assert.assertEquals(actualTitle, expectedTitle, "El título de la página no es el esperado.");`

## 2. assertNotEquals

Verifica que dos valores no sean iguales.

    Assert.assertNotEquals(actualTitle, incorrectTitle, "El título de la página no debería ser este.");

## 3. assertTrue

Verifica que una condición sea verdadera.

    Assert.assertTrue(isElementPresent, "El elemento debería estar presente.");

## 4. assertFalse

Verifica que una condición sea falsa.

    Assert.assertFalse(isElementPresent, "El elemento no debería estar presente.");

````java
package pages;

import java.util.List;

public class PaginaRegistro extends BasePage {

    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public PaginaRegistro() {
        super(driver);
    }

    public List<String> returnPlanDropdownValues() {
        return getDropdownValues(planDropdown);
    }

}
````

