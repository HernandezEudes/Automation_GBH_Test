package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Open_WebPAge_Test {

	WebDriver driver;
	String ChromeWebDriverPath = "C:/Users/FRANCISCA SALCEDO/Documents/Eudes/chromedriver_win32/chromedriver.exe";

	@BeforeTest
	public void driverDefinition() {
		System.setProperty("webdriver.chrome.driver", ChromeWebDriverPath);
		driver = new ChromeDriver();
		System.out.println("This test is to click all the linsks in main meno from GBH main page"
				+ "We will be interacting with a video inside 'Conocenos' tab");
		// Entering web page
		driver.get("http://www.gbh.com.do");
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	public void portafolio_tab() {
		WebElement portfolio_Button = driver.findElement(By.xpath("//a[text()='Portafolio']"));
		portfolio_Button.click();
		System.out.println("'Portafolio page'");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}

	@Test(priority=2)
	public void empleos_tab() {
		WebElement empleos_Button = driver.findElement(By.xpath("//a[text()='Empleos']"));
		empleos_Button.click();
		System.out.println("'Empleos page'");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=3)
	public void blog_tab() {
		WebElement blog_Button = driver.findElement(By.xpath("//a[text()='Blog']"));
		blog_Button.click();
		System.out.println("'Blog page'");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=4)
	public void conocenos_tab() {
		System.out.println("'Conocenos page'");
		// entering to "conocenos tab"
		WebElement busqueda = driver.findElement(By.xpath("//a[contains(text(),'Conócenos')]"));
		busqueda.click();
		// wait till page downloads its content
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement paragraph = driver.findElement(By.xpath("//p[contains(text(),'cualquier tamaño')]"));
		// Scrolling down to the video
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", paragraph);
		// Switching to the video frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ytplayer']")));
		driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));
		WebElement video_player = driver.findElement(By.xpath(
				"//div[@class='html5-video-player unstarted-mode ytp-hide-controls ytp-hide-info-bar ytp-large-width-mode']"));
		video_player.click();
		// 100000- is the equal values to 1:40, the time that video's duration
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		driver.close();
	}
}
