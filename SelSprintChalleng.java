package problem1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;


public class SelSprintChalleng {
WebDriver driver;
WebDriverWait wait;

@BeforeMethod
public void setUp() {
	driver = WebDriverManager.chromedriver().create();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/");
	wait= new WebDriverWait(driver,Duration.ofSeconds(10));
}
@Test
public void testFormsAndBasicElements() {
	driver.findElement(By.cssSelector(".card.mt-4.top-card.nth-child(1)")).click();
	driver.findElement(By.id("item-0")).click();
	
	driver.findElement(By.id("userName")).sendKeys("Nikhil Damale");
	driver.findElement(By.id("userEmail")).sendKeys("nikhildamale@gmail.com");
	driver.findElement(By.id("currenAddress")).sendKeys("pune");
	driver.findElement(By.id("permanentAddress")).sendKeys("Nagar");
	driver.findElement(By.id("submit")).click();
	
	driver.findElement(By.id("item-2")).click();
	driver.findElement(By.cssSelector("lable[for='impressiveRadio")).click();
	
	String result= driver.findElement(By.className("text-success")).getText();
	
	Assert.assertEquals(result, "Impressive");
}
public void testDynamicWidgets() {
	driver.findElement(By.cssSelector(".card.mt-4.top-card.nth-child(4)")).click();
	driver.findElement(By.id("item-8")).click();
	
	Select seletcTitle= new Select(driver.findElement(By.id("oldSelectMenu")));
	seletcTitle.selectByVisibleText("White");
	
	WebElement dynamicDropdown= driver.findElement(By.id("react-select-2-input"));
	dynamicDropdown.sendKeys("Group 1, option 1");
	dynamicDropdown.sendKeys(Keys.ENTER);
	driver.findElement(By.id("item-2")).click();
	driver.findElement(By.id("datePickerMonthYearInput")).click();
	
	Select monthSelect = new Select(driver.findElement(By.id("react-datepicker_month-select")));
	monthSelect.selectByIndex((java.time.LocalDate.now().getMonthValue()%12));
	driver.findElement(By.cssSelector(".react-datepicker_day--015:not(react-fatepicker_day--outside-month)")).click();
}


}
