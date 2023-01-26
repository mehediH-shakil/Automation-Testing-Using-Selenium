package com.automationtesting.eCommerceTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.automationtesting.utilities.ReadConfig;

public class loginPage {
	public static void main(String[] args) throws InterruptedException {
		ReadConfig config = new ReadConfig();
		String baseURL = config.getApplicationURL();
		String username = config.getUsername();
		String pass = config.getPassword();
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL+"my-account/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		
		String PasswordFieldType = driver.findElement(By.id("password")).getAttribute("type");
		Assert.assertEquals("password", PasswordFieldType);
		System.out.println("Password Type is matched.");
		
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();

		try {
			String DashbordMassage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]")).getText();
			String expectedDashbordMassage = String.format("Hello %s (not %s? Sign out)", username, username);
			Assert.assertEquals(expectedDashbordMassage, DashbordMassage);
			System.out.println("Test case is passed.");
		}catch (Exception e) {
			System.out.println("Test case is failed.");
		}
		
		driver.close();
	}

}
