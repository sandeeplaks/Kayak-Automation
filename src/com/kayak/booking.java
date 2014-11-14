package com.kayak;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class booking {
	private WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get("http://www.kayak.co.in/?ispredir=true");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement form = driver.findElement(By.id("searchform"));
		List <WebElement> my_button = form.findElements(By.tagName("span"));
		WebElement my_radio_button = my_button.get(2);
		my_radio_button.click();
		System.out.println(my_radio_button.getText());
		
		//Inputs
		WebElement origin = driver.findElement(By.id("origin"));
		origin.sendKeys("Chennai (MAA)");
		System.out.println(origin.getAttribute("value") + "is the origin of this booking");
		WebElement destination = driver.findElement(By.id("destination"));
		destination.sendKeys("Richmond (RIC)");
		System.out.println(destination.getAttribute("value") + "is the destination of this booking");

		//Dates of the trip
		WebElement travel_date = driver.findElement(By.id("travel_dates-start-wrapper"));
		List <WebElement> travel = travel_date.findElements(By.tagName("span"));
		WebElement departure_date = travel.get(0);
		Thread.sleep(3000);
		departure_date.click();
		
		
		//Selecting the dates from the date picker
		
		WebElement date_widget = driver.findElement(By.id("datepicker"));
		WebElement date_days = date_widget.findElement(By.className("r9-datepicker-month-dates"));
		List <WebElement> days_rows = date_days.findElements(By.className("r9-datepicker-month-row"));
		WebElement days_row = days_rows.get(2);
		List <WebElement> day = days_row.findElements(By.tagName("span"));
		WebElement day_travel = day.get(9);
		System.out.println(day_travel.getText());
		day_travel.click();
		
		WebElement return_date = driver.findElement(By.id("travel_dates-end-wrapper"));
		List <WebElement> return_day = return_date.findElements(By.tagName("span"));
		WebElement return_day_month = return_day.get(0);
		Thread.sleep(3000);
		return_day_month.click();
		
		WebElement return_date_widget = driver.findElement(By.id("datepicker"));
		List <WebElement> return_date_December = return_date_widget.findElements(By.className("r9-datepicker-month-dates"));
		WebElement return_date_last = return_date_December.get(1);
		List <WebElement> return_date_row = return_date_last.findElements(By.className("r9-datepicker-month-row"));
		WebElement date_return_row = return_date_row.get(1);
		List <WebElement> date_return = date_return_row.findElements(By.tagName("span"));
		WebElement date = date_return.get(4);
		System.out.println(date.getText());
		date.click();
		
		WebElement travellers = driver.findElement(By.className("r9-dropdownDialog-label"));
		travellers.click();
		System.out.println(travellers.getText());
		/*WebElement travellers_dropDown = travellers.findElement(By.className("r9-dropdownDialog-icon"));
		travellers_dropDown.click();*/
		Thread.sleep(2000);
		WebElement Increase_Passengers = driver.findElement(By.cssSelector("#travelers > div > div.fieldInput.fieldInputSelect.fieldInputPTCType.ptcAdults > div.r9NumberBox.PTCNumberBox > button.ui-button.ui-button-gray.bags-button-right.incrementor"));
		Increase_Passengers.click();
		System.out.println("The number of passengers is " + Increase_Passengers.getText());
		WebElement travellers_now = driver.findElement(By.className("r9-dropdownDialog-label"));
		System.out.println(travellers_now.getText());
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	@After
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	

}
