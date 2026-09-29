package br.com.aulaselenium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

class LoginTest extends BaseTest {
    private static final By EMAIL = By.cssSelector("input[data-qa='login-email']");
    private static final By PASSWORD = By.cssSelector("input[data-qa='login-password']");
    private static final By LOGIN_BUTTON = By.cssSelector("button[data-qa='login-button']");
    private static final By LOGIN_ERROR = By.cssSelector("form[action='/login'] p");

    @Test
    void loginWithIncorrectEmailAndPasswordShowsError() {
        openLoginPage();
        assertTrue(visible(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed());

        submitLogin("nao-cadastrado-" + UUID.randomUUID() + "@example.com", "SenhaErrada123!");

        assertEquals("Your email or password is incorrect!", visible(LOGIN_ERROR).getText());
    }

    @Test
    void malformedEmailIsRejectedByBrowserValidation() {
        openLoginPage();
        WebElement email = visible(EMAIL);
        email.sendKeys("usuario@");
        visible(PASSWORD).sendKeys("Senha123!");

        assertTrue(hasValidity(email, "typeMismatch"));
        click(LOGIN_BUTTON);
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    void emptyEmailIsRejectedAsRequired() {
        openLoginPage();
        WebElement email = visible(EMAIL);
        visible(PASSWORD).sendKeys("Senha123!");

        assertTrue(hasValidity(email, "valueMissing"));
        click(LOGIN_BUTTON);
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    void emptyPasswordIsRejectedAsRequired() {
        openLoginPage();
        WebElement email = visible(EMAIL);
        email.sendKeys("nao-cadastrado-" + UUID.randomUUID() + "@example.com");
        WebElement password = visible(PASSWORD);

        assertTrue(hasValidity(password, "valueMissing"));
        click(LOGIN_BUTTON);
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    void maximumLengthEmailReachesApplicationValidation() {
        openLoginPage();
        String emailAtBoundary = maximumLengthEmail();
        assertEquals(254, emailAtBoundary.length());
        submitLogin(emailAtBoundary, "SenhaErrada123!");

        assertEquals("Your email or password is incorrect!", visible(LOGIN_ERROR).getText());
    }

    @Test
    void oneCharacterPasswordReachesApplicationValidation() {
        openLoginPage();
        submitLogin("nao-cadastrado-" + UUID.randomUUID() + "@example.com", "x");

        assertEquals("Your email or password is incorrect!", visible(LOGIN_ERROR).getText());
    }

    private void submitLogin(String email, String password) {
        visible(EMAIL).sendKeys(email);
        visible(PASSWORD).sendKeys(password);
        click(LOGIN_BUTTON);
    }

    private boolean hasValidity(WebElement element, String validityProperty) {
        String script = "return arguments[0].validity." + validityProperty + ";";
        return Boolean.TRUE.equals(((JavascriptExecutor) driver).executeScript(script, element));
    }

    private String maximumLengthEmail() {
        String domain = repeat('d', 63) + "." + repeat('d', 63) + "." + repeat('d', 57) + ".com";
        return repeat('a', 64) + "@" + domain;
    }

    private String repeat(char character, int count) {
        StringBuilder value = new StringBuilder(count);
        for (int index = 0; index < count; index++) {
            value.append(character);
        }
        return value.toString();
    }
}