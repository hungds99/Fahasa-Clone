package com.hunter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Iterables;

public class Main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HungDinh\\Desktop\\Fahasha Project\\testPy\\chrome\\chromedriver.exe");

		String url = "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver";

        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.get(url);
        
        // Test
        WebElement tableTest = driver.findElement(By.id("footer"));
        System.out.println(tableTest.getText());

        // Find the table element using xpath
        WebElement table = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/table"));
        
        // Go through each major version
        List<WebElement> mainVersions = table.findElements(By.tagName("tbody"));

        for(WebElement mver: mainVersions) {
            for(WebElement ver: mver.findElements(By.tagName("tr"))) {
                // Get all anchor tags
                List<WebElement> attributes = ver.findElements(By.tagName("a"));

                // Find each relevant web element that contains required information
                WebElement version = attributes.get(0);
                WebElement repository = attributes.get(1);
                WebElement usages = attributes.get(2);
                WebElement date = Iterables.getLast(ver.findElements(By.tagName("td")));

                System.out.println("Version    : " + version.getText());
                System.out.println("Repository : " + repository.getText());
                System.out.println("Usages     : " + usages.getText());
                System.out.println("Date       : " + date.getText());
                System.out.println("------------------------------");
            }

        }

        // Close driver
        driver.quit();
		
	}
	
}
