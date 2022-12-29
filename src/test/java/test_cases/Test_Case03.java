package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class Test_Case03 {

    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    // 3. Verify that home page is visible successfully
    // 4. Click on 'Signup / Login' button
    // 5. Verify 'Login to your account' is visible
    // 6. Enter incorrect email address and password
    // 7. Click 'login' button
    // 8. Verify error 'Your email or password is incorrect!' is visible

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement account = driver.findElement(By.xpath("//*[@id='slider']"));
        Assert.assertTrue(account.isDisplayed());

        // 4. Click on 'Signup / Login' button
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("ogin")).click();

        // 5. Verify 'Login to your account' is visible
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());

        // 6. Enter incorrect email address and password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("merhaba@gmail.com", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("merhaba@gmail.com");


        // 7. Click 'login' button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();


        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(errorMessage.isDisplayed());







    }

}
