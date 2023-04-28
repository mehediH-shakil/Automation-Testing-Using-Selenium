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

public class RegistrationPage_TestCase {
	ReadConfig config = new ReadConfig();
	String URL = config.getApplicationURL();
	String email = config.getEmail();
	String password = config.getPassword();
	String name = "Mehedi Hasan";

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.xpath("/html/body/section/div/form/span[3]/span/p[1]/span/a")).click();
    }
    
    @Test(priority = 1)
    public void AccessRegistrationPage() {
        String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    
    @Test(priority = 2)
	public void Registration_with_invalid_Name() {
		driver.findElement(By.name("name")).sendKeys("1234 #^$%#^");
		driver.findElement(By.name("email")).sendKeys("mehedi@gmail.com");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
    @Test(priority = 3)
	public void Registration_with_empty_Name() {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
    @Test(priority = 4)
	public void Registration_with_invalid_Email() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys("mehedi11081@gmail.com.123");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
    @Test(priority = 5)
	public void Registration_with_empty_Email() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
    @Test(priority = 6)
	public void Registration_with_empty_password() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
    
	@Test(priority = 7)
	public void Registration_With_Valid_information() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Login Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 8)
	public void Registration_With_exist_Email() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 9)
	public void Registration_With_exist_empty_confirm_password() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 10)
	public void Registration_With_exist_unmacth_confirm_password() {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirm-password")).sendKeys("1234568754");
		driver.findElement(By.name("submit")).click();
		
		String actualTitle = "Tourism Point - Registration Page";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
	}

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
}
