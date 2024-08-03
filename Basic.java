package assignment;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Basic {
	public static void main(String[] args) throws InterruptedException {
		//creating an instance for browser on which browser user need's use.
		//here currently using chrome browser 
		WebDriver driver=new ChromeDriver();
		//here maximizing the browser window
	    driver.manage().window().maximize();
	    //here using the url where we need to land using get method 
		driver.get("https://www.fitpeo.com/");
		//need's to navigate to home we can use get(String url) or navigate.to(url) or just need to click on the particular element 
		//here i'm using navigate method
		//navigating to home
		driver.navigate().to("https://www.fitpeo.com/home");
		//here need to validate the url of the  particular web-page
		if(driver.getCurrentUrl().equals("https://www.fitpeo.com/home")) {
			System.out.println("test case-1 passed");
			  //here need to navigate to Revenue Calculator
			     driver.navigate().to("https://fitpeo.com/revenue-calculator");
			       if(driver.getCurrentUrl().equals("https://fitpeo.com/revenue-calculator")) {
			    	   System.out.println("test case-2 passed ");
			    	     //need to scroll down until calculator slider is visible by using action class.
                  			    Actions action=new Actions(driver);
                  			    //when ever using actions class need to make sure at the end need to use build and perform methods.
                  			    action.scrollToElement(driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-caption inter css-43plts']"))).build().perform();
                  			    WebElement slider= driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']"));
                  			    action.dragAndDropBy(slider,108, 0).build().perform(); // here the result is 823 if we set the position of 107 the result is 816
                  			    System.out.println("slider 820 is failed ");
                  	 		  WebElement textfield=driver.findElement(By.id(":R57alklff9da:"));
                  	 		action.sendKeys(textfield, Keys.BACK_SPACE).sendKeys(textfield, Keys.BACK_SPACE).sendKeys(textfield, Keys.BACK_SPACE).build().perform();
                  	 		  System.out.println("text field working fine as expected ");
                  	 		 action.sendKeys(textfield, "560").build().perform();
                  	 		action.sendKeys(textfield, Keys.BACK_SPACE).sendKeys(textfield, Keys.BACK_SPACE).sendKeys(textfield, Keys.BACK_SPACE).build().perform();
                  	 		action.sendKeys(textfield, "820").build().perform();
                  	 		  //selection part of cpt codes
                  	 		// CPT-99091, CPT-99453, CPT-99454, and CPT-99474.
                  	 		 //scrolling down
                  	 		 action.scrollToElement(driver.findElement(By.xpath("//span[text()='19.19']")));
                            WebElement CPT1= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div[1]/label[1]"));
                            CPT1.click();
                            Thread.sleep(2000);
                            WebElement CPT2= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div[2]/label[1]"));
                  	 		CPT2.click();
                  	 	    WebElement CPT3= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div[3]/label[1]"));
               	 		   CPT3.click();
                  	 		action.scrollToElement(driver.findElement(By.xpath("//span[text()='15']")));
                  	 		WebElement CPT4= driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div[8]/label[1]"));
                  	 		Thread.sleep(2000);
                  	 		CPT4.click();
                  	 		WebElement finalresult=driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']/p[4]/p"));
                  	 		if(finalresult.getText().equals("$110700")) {
                  	 			System.out.println("final validation is passed ");
                  	 			driver.quit();
                  	 		}
                  	 		else {
								System.out.println("final validation is failed ");
							}
			       }
			       else {
					System.out.println("test case -2 failed ");
				}
		}else {
	      System.out.println("test case -1 failed");
		}
	
		driver.quit();
	}

}
