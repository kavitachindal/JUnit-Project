package validationtest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationTest {
	WebDriver driver;

	Random rnd = new Random();
	int generatedNum = rnd.nextInt(9999);

	String inputName = "Kavita";

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/104/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {

//Test 1: Validate when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.

		driver.findElement(By.cssSelector("input[name='data']")).sendKeys(inputName + generatedNum);
		driver.findElement(By.cssSelector("input[value='Add']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[name='data']")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("input[name='data']")).isDisplayed());

		driver.findElement(By.xpath("/html/body/div[3]/input[3]")).click();
		

//Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.

		WebElement SINGLE_CHECKBOX_ELEMENT = driver.findElement(By.cssSelector("input[type='checkbox']"));
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOf(SINGLE_CHECKBOX_ELEMENT));
		SINGLE_CHECKBOX_ELEMENT.click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[name='data']")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("input[name='data']")).isDisplayed());

		driver.findElement(By.name("submit")).click();
		

//Test3:Validate that all list item could be removed using the remove button and when "Toggle All" functionality is on.

		driver.findElement(By.cssSelector("input[name='data']")).sendKeys(inputName + generatedNum);
		driver.findElement(By.cssSelector("input[value='Add']")).click();
		driver.findElement(By.name("allbox")).click();

		Assert.assertTrue(driver.findElement(By.name("allbox")).isDisplayed());
		System.out.println(driver.findElement(By.name("allbox")).isDisplayed());

		driver.findElement(By.name("submit")).click();

	}

	public void teardown() {
	 //driver.close();
	// driver.quit();
}
}
