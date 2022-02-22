import java.nio.IntBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Perform_Scroll {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		JavascriptExecutor JS= (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,500)");
		JS.executeScript("document.querySelector('.tableFixHead').scrollTo(0,500)");
		List<WebElement> Values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<Values.size();i++) {
			int u=Integer.parseInt(Values.get(i).getText());
			sum=sum+u;
			
		}
		
		int Number=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, Number);
	}

}
