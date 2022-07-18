package com.interviewP;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
public static void main(String[] args) throws IOException {
	
WebDriverManager.chromedriver().setup();
WebDriver	driver=new ChromeDriver();
	driver.get("https://twitter.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	int broken=0;
	int valid=0;
	List<WebElement> linkTag = driver.findElements(By.tagName("a"));
	for (int i = 0; i < linkTag.size(); i++) {
		WebElement allLink = linkTag.get(i);
		String links = allLink.getAttribute("href");
		//System.out.println(links);
	if(links!=null) {
		if (links.contains("https")) {
			URL url= new URL(links);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection connection =(HttpURLConnection)openConnection;
			
			int responseCode = connection.getResponseCode();
			if (responseCode!=200) {
				
				System.out.println("broken  = "+links);
				broken++;
			}else {
				System.out.println("success  = "+links);
				valid++;
			}
		}
	}
	}
	System.out.println("valid ="+valid);
	System.out.println("broken = "+broken);
	
	driver.quit();
  
	}
}
