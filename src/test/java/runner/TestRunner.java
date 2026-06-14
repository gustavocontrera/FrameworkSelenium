package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos feature
        glue = "steps", // Paquete donde tenemos nuestras clases definiendo los steps
        plugin = { "pretty", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
        tags = "@Section")

public class TestRunner {
    @AfterClass
    public static void cleanDriver() {
        BasePage.closeBrowser();
        generateReport();
    }

    public static void generateReport() {
        try {
            System.out.println("Generando reporte HTML de Allure...");
            // Ejecución silenciosa del comando npx apuntando a las nuevas rutas en test-output/
            ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", 
                "npx -y allure-commandline generate test-output/allure-results --clean -o test-output/allure-report"
            );
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor();
            System.out.println("Reporte de Allure generado con éxito en la carpeta 'test-output/allure-report'.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al generar el reporte de Allure: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
