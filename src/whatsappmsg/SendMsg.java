package whatsappmsg;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SendMsg {

	static WebDriverWait wait;
	static String csvFile = "F:\\Selenium Scripts\\lib\\Detail.csv";
	static String line = " ";
	static String cvsSplitBy = ",";
	public  static String[] ContactInfo = null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Scripts\\Chrome_Test_Profile\\chromedriver.exe"); 	
		 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress","localhost:9014");
		 
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		//driver.findElement(By.cssSelector("#side > header > div._3yZPA > div > span > div:nth-child(2)")).click();
		//for(int k=0 ; k<=5 ; k++) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		 {
			
		 	while ((line = br.readLine()) != null) 
			{
		    	ContactInfo = line.split(cvsSplitBy);
		    	
		   	   	int i = 0;
		   	   	int j = 1;
		   	   	
		   	   	String str = ContactInfo[i];
		   	   	str= str.replaceAll("\\s{2,}", " ").trim();
		   	
		   	 System.out.println(str);
		   	 System.out.println(ContactInfo[j]);
				driver.findElement(By.cssSelector("div._1UWac > div._13NKt")).sendKeys(str);
				Thread.sleep(1000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).build().perform();
				driver.findElement(By.cssSelector("div._1UWac._1LbR4 > div._13NKt.copyable-text.selectable-text")).sendKeys(ContactInfo[j]);
				Thread.sleep(1000);
				action.sendKeys(Keys.ENTER).build().perform();
				//driver.findElement(By.cssSelector("#side > header > div.sbcXq > div > span > div:nth-child(2)")).click();
				Thread.sleep(1000);
		        i++;
		        j++;	            	
			}
			
		 } 
		
		catch (IOException e) 
		{
		       e.printStackTrace();
		}
		//}
	}

}
