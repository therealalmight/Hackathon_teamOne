package Pages;

import java.time.Duration;

import org.openqa.selenium.By;

import Base.Base;

public class CarInsurance extends Base{
	
	By car=By.xpath("/html/body/main/div[2]/section/div[4]/a/div[1]/p");
	By proceed=By.xpath("//a[@class=\"btn-proceed\"]");
	By no = By.xpath("//*[@id=\'searchOthers\']");   // react-autosuggest__input
	By select=By.id("react-autowhatever-1");
	By comp=By.xpath("//input[@placeholder='Search car brand']");
	By fuel=By.id("Diesel");
	By variant=By.xpath("//*[text()='CRDI (1493 cc)']");
	By year=By.xpath("//*[text()='2018']");
	By name=By.id("name");
	By email=By.id("email");
	By phone=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/label");
	By view=By.xpath("//*[@id=\"btnLeadDetails\"]/span");
	By error1=By.xpath("//div[@class='msg-error show']");
	By error2=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[1]");
	
	public void car() throws InterruptedException {
	
		driver.findElement(car).click();
		driver.findElement(proceed).click();
		wait(Duration.ofSeconds(20), no);
		driver.findElement(no).click();
		wait(Duration.ofSeconds(20), select);
		driver.findElement(select).click();
		Thread.sleep(1000);
		driver.findElement(no).click();
		driver.findElement(comp).sendKeys("Accent");
		wait(Duration.ofSeconds(20), select);
		driver.findElement(select).click();
		Thread.sleep(1000);
		driver.findElement(fuel).click();
		driver.findElement(variant).click();
		driver.findElement(year).click();
		driver.findElement(name).sendKeys("Bala");
		driver.findElement(email).sendKeys("balasourvendra@gmail");
		System.out.println("********************************************");
		System.out.println("         The Error Message is: ");
		System.out.println("********************************************");
		System.out.println(driver.findElement(error1).getText());
		
		Thread.sleep(1000);
	}
}