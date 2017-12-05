package webTest;

import java.util.List;

import org.junit.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SimpleTestCase {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Projects\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void checkTitle() {
		driver.get("https://www.facebook.com");
		String expected = "Facebook - Log In or Sign Up";
		Assert.assertEquals(expected, driver.getTitle());
	}
	
	@Test
	public void checkBtnById() {
		driver.get("https://www.facebook.com");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("u_0_2"))));
	}
	
	@Test 
	public void checkPageContainsElementByTagAndParent()
	{
		String parent = "Register Now!";
		driver.get("http://www.classicalnext.com/participate/registration");
		Assert.assertEquals(parent, driver.findElement(By.xpath("//div[@class='category_button_headline']")).getText());
		WebElement table = driver.findElement(By.id("content"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Assert.assertEquals(8, rows.size());
	}	
	
	@Test
	public void checkByClassName() {
		String text = "Register Now!";
		driver.get("http://www.classicalnext.com/participate/registration");
		Assert.assertEquals(text, driver.findElement(By.className("category_button_headline")).getText());
	}
	
	@Test
	public void searchForAppleWatch()
	{
		driver.get("https://www.cel.ro");
		driver.findElement(By.id("keyword")).sendKeys("apple smart watch");
		driver.findElement(By.xpath("//button[@type='submit' and text()='Cauta']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@pid_prod='453782']"))));
	}
	
	@Test
	public void fillLoginForm() {
		String expectedErrorMessage = "Eroare: Nu s-a gasit nici o inregistrare pentru adresa E-Mail si/sau Parola introduse.";
		driver.get("https://www.cel.ro/index.php?main_page=login");
		driver.findElement(By.xpath("//input[@name='email_addressx' and @id='email_address']")).sendKeys("Iisus");;
		driver.findElement(By.xpath("//input[@type='password' and @name='passwordx']")).sendKeys("Hristos");
		driver.findElement(By.xpath("//button[@class='btn btn-special']")).click();
		Assert.assertEquals(expectedErrorMessage, driver.findElement(By.xpath("//span[@class='eroareafis']")).getText());
	}
	
	@Test
	public void addTwoProducts()
	{
		driver.get("https://www.cel.ro");
		driver.findElement(By.id("keyword")).sendKeys("apple smart watch");
		driver.findElement(By.xpath("//button[@type='submit' and text()='Cauta']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@pid_prod='453782']"))));
		driver.findElement(By.xpath("//a[@href='http://www.cel.ro/smartwatch/smartwatch-apple-watch-3-gps-38mm-space-grey-aluminium-case-with-black-sport-band-pNScwMz0s-l/']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-buy']")).click();
		WebElement continuatiCumparaturile = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
		wait.until(ExpectedConditions.visibilityOf(continuatiCumparaturile));
		continuatiCumparaturile.click();
		driver.findElement(By.id("keyword")).sendKeys("topor");
		driver.findElement(By.xpath("//button[@type='submit' and text()='Cauta']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='http://www.cel.ro/scule-de-gradina/topor-pentru-despicat-fiskars-x21-_-l-_32_--775-mm-_32_--1600-g-pNSc2MDwr-l/']"))));
		driver.findElement(By.xpath("//a[@href='http://www.cel.ro/scule-de-gradina/topor-pentru-despicat-fiskars-x21-_-l-_32_--775-mm-_32_--1600-g-pNSc2MDwr-l/']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-buy']")).click();
		WebElement veziDetaliiCos = driver.findElement(By.xpath("//a[@class='btn btn-orange pull-right']"));
		wait.until(ExpectedConditions.visibilityOf(veziDetaliiCos));
		veziDetaliiCos.click();
	}	
	@AfterClass
	public static void tearDown() {
		//driver.quit();
	}
}
