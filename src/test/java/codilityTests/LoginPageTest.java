package codilityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    //locators
    //e-mail = //input[@id='email-input']
    //password = //input[@id='password-input']
    //login button = //input[@id='password-input']
    //success msg = //div[@Class='message success']
    //error msg = //div[@Class='message error']
    //email validation msg = /div[@class='validation error' and contains(text(), 'Enter a valid email')]
    //password required msg =//div[@class='validation error' and contains(text(), 'Password is required')]
    //email required msg = /div[@class='validation error' and contains(text(), 'Email is required')]



    @Test
    public void verifyEmailPasswFields() {
        WebElement emailField = driver.findElement(By.id("email-input"));
        WebElement passwordField = driver.findElement(By.id("password-input"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        Assert.assertTrue(emailField.isDisplayed(), "Email field is displayed");
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is displayed");
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is present");
        /* if(emailField.isDisplayed()){
             System.out.println("OK");
         }*/

    }


    @Test
    public void verifyLoginSuccess() {
        WebElement emailField = driver.findElement(By.id("email-input"));
        WebElement passwordField = driver.findElement(By.id("password-input"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        emailField.sendKeys("login@codility.com");
        passwordField.sendKeys("password");
        loginBtn.click();

        WebElement successMsg = driver.findElement(By.xpath("//div[@Class='message success']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Succes Message is displayed");
        System.out.println(successMsg.isDisplayed());

    }


    @Test
    public void verifyInvalidCredentials() {
        WebElement emailField = driver.findElement(By.id("email-input"));
        WebElement passwordField = driver.findElement(By.id("password-input"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        emailField.sendKeys("unknown@codility.com");
        passwordField.sendKeys("password");
        loginBtn.click();

        WebElement invalidCredentialMsg = driver.findElement(By.xpath("//div[@class='message error' and contains(text(), 'You shall not pass! Arr!')]"));

        Assert.assertTrue(invalidCredentialMsg.isDisplayed(), "You shall not pass! Arr! Message is displayed");
        System.out.println(invalidCredentialMsg.isDisplayed());
    }

    @Test
    public void verifyEmailValidation() {
        WebElement emailField = driver.findElement(By.id("email-input"));
        WebElement passwordField = driver.findElement(By.id("password-input"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        emailField.sendKeys("dasa");
        passwordField.sendKeys("password");
        loginBtn.click();

        WebElement invalidEmailMsg = driver.findElement(By.xpath("//div[@class='validation error' and contains(text(), 'Enter a valid email')]"));

        Assert.assertTrue(invalidEmailMsg.isDisplayed(), "Enter a valid email Message is displayed");
        System.out.println(invalidEmailMsg.isDisplayed());
    }

    @Test
    public void verifyEmptyCredential() {

        WebElement loginBtn = driver.findElement(By.id("login-button"));

        loginBtn.click();

        WebElement emailReqMsg = driver.findElement(By.xpath("//div[@class='validation error' and contains(text(), 'Email is required')]"));
        WebElement pswReqMsg = driver.findElement(By.xpath("//div[@class='validation error' and contains(text(), 'Password is required')]"));

        Assert.assertTrue(emailReqMsg.isDisplayed(), "Email is required Message is displayed");
        Assert.assertTrue(pswReqMsg.isDisplayed(), "Password is required Message is displayed");


    }
}