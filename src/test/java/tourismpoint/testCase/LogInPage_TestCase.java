package tourismpoint.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tourismpoint.utilities.ReadConfig;

public class LogInPage_TestCase {
	ReadConfig config = new ReadConfig();
	String URL = config.getApplicationURL();
	String email = config.getEmail();
	String password = config.getPassword();

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.linkText("Log In")).click();
    }
    
    @Test(priority = 1)
    public void AccessLoginPage() {
        String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    
    @Test(priority = 2)
	public void Login_with_empty_Email() {
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
    @Test(priority = 3)
	public void Login_with_empty_password() {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 4)
	public void Login_With_incorrect_Email() {
		driver.findElement(By.name("email")).sendKeys("mehedi1234@gmail.com");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 5)
	public void Login_With_incorrect_Password() {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
}
