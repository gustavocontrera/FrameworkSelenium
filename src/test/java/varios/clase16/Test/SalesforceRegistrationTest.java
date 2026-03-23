package varios.clase16.Test;

import varios.clase16.PageObject.SalesforceLandingPage;
import varios.clase16.PageObject.SalesforceRegistrationPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesforceRegistrationTest extends BaseTest{

    @Test
    public void registrationTest(){
        SalesforceRegistrationPage salesforceRegistrationPage = salesforceLandingPage.goToRegistrationPage();
        salesforceRegistrationPage.fillRegistrationFields();

        //driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");

        /*
        Faker faker = new Faker();

        driver.findElement(By.name("UserFirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("UserTitle")).sendKeys(faker.job().title());
        driver.findElement(By.name("UserEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("UserPhone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.name("CompanyName")).sendKeys("Salesforce");

        WebElement industryElement = driver.findElement(By.name("Lead.Industry"));
        Select industrySelect = new Select(industryElement);
        industrySelect.selectByValue("Manufacturing");*/

    }



}
