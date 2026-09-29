package br.com.aulaselenium.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

class RegisterUserTest extends BaseTest {

    @Test
    void registerUserAndDeleteAccount() {
        String name = "Selenium User";
        String email = "selenium." + UUID.randomUUID().toString().replace("-", "") + "@example.com";
        openHomePage();
        click(By.cssSelector("a[href='/login']"));

        assertTrue(visible(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
        click(By.cssSelector("button[data-qa='signup-button']"));

        assertTrue(visible(By.xpath("//*[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ENTER ACCOUNT INFORMATION')]")).isDisplayed());
        click(By.id("id_gender1"));
        driver.findElement(By.id("password")).sendKeys("StrongPass123!");
        new Select(driver.findElement(By.id("days"))).selectByValue("15");
        new Select(driver.findElement(By.id("months"))).selectByValue("6");
        new Select(driver.findElement(By.id("years"))).selectByValue("1995");
        click(By.id("newsletter"));
        click(By.id("optin"));

        driver.findElement(By.id("first_name")).sendKeys("Selenium");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("company")).sendKeys("QA Example");
        driver.findElement(By.id("address1")).sendKeys("123 Test Street");
        driver.findElement(By.id("address2")).sendKeys("Suite 5");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("5551234567");
        click(By.cssSelector("button[data-qa='create-account']"));

        assertTrue(visible(By.xpath("//h2[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ACCOUNT CREATED!')]")).isDisplayed());
        click(By.cssSelector("a[data-qa='continue-button']"));
        assertTrue(visible(By.xpath("//*[contains(normalize-space(.), 'Logged in as')]")).isDisplayed());

        click(By.cssSelector("a[href='/delete_account']"));
        assertTrue(visible(By.xpath("//h2[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ACCOUNT DELETED!')]")).isDisplayed());
        click(By.cssSelector("a[data-qa='continue-button']"));
    }
}