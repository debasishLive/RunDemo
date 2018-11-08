package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {

	public static final String uid="mahapatradebasish34"; 
	public static final String pwd="Debasish@12"; 
	
	@Test
	public void LunchTest() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		System.out.println("lunch a browser");
		
		System.out.println("Logging In");
		driver.findElement(By.id("identifierId")).sendKeys(uid);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		
		char rslt[]=driver.findElement(By.xpath("(//span[contains(text(),'of')])[1]")).getText().toCharArray();
		System.out.println("Total mails Are  ---->"+rslt[rslt.length-1]);
		driver.quit();
	}
}
