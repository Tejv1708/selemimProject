package mavenProject.mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForStackManipulation.Writable;


public class App 
{
	static WebDriver driver = new ChromeDriver();
	
	
	
	@BeforeTest
	public void openApplication() throws Exception, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	       WebDriverManager.chromedriver().setup();
	          
	     
	     File file =    new File("C:\\Users\\asus\\OneDrive\\Desktop\\Excels Files\\FyndProject.xls");
	     FileInputStream inputStream = new FileInputStream(file);
	     
	     Workbook wb = Workbook.getWorkbook(inputStream) ;
	      
	     Sheet s = wb.getSheet("Sheet1");
	 
	    
	     driver.get(s.getCell(0,2).getContents());
	}
	
	// This is for check the Home is displayed or not 
	@AfterTest
	public void closeApplication() {
		driver.close() ;
	}
	
	@Test 
	public void m1() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
		WebElement  Home = driver.findElement(By.xpath("//a[text() = 'Home']")) ;
		
		Assert.assertEquals("Home" ,Home.getText() );
	}
	
	// This is for check the Football is displayed or not 
	@Test 
	public void m2() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
		WebElement  Football = driver.findElement(By.xpath("//a[text() = 'Football']")) ;
		
		Assert.assertEquals("Football",Football.getText() );
	}
	
	// This is for check the Busketball is displayed or not 
	@Test
	public void m3() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
		WebElement  Busketball = driver.findElement(By.xpath("//a[text() = 'Busketball']")) ;
		
		Assert.assertEquals("Basketball" ,Busketball.getText() );
	}

	// This is for check the kriket is displayed or not 
	@Test
	public void m4() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
		WebElement  Kriket = driver.findElement(By.xpath("//a[text() = 'Kriket']")) ;
		
		Assert.assertEquals( "Cricket" , Kriket.isDisplayed());
	}
	
	// This is for check the Cibersport is displayed or not 
	@Test
	public void m5() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
		WebElement  Cibersport = driver.findElement(By.xpath("//a[text() = 'Cibersport']")) ;
		
		Assert.assertEquals( Cibersport.getText() ,"Cybersport"  );
	}
	
	
//	@Test public void m1() {
//		
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		List<WebElement> links = driver.findElements(By.tagName("a")) ;
//		
//		List<String> tagNames = new ArrayList<>() ;
//		 tagNames.add("Cricket") ;
//		 tagNames.add("BasketBall") ;
//		 tagNames.add("Football") ;
//		 tagNames.add("Games") ;
//		for(WebElement tej : links) {
//			
//		    for(String name : tagNames) {
//		    	if(tej.getText().contains(name)) {
//		    		System.out.println("Pass -> "+tej.getText()  ) ;
//		    	}
//		    	
//		    }
//		}
//	
//	}
	
	// 	Verify URL of each tab contains the tab name 
	@Test 
	public void m6() {
		 WebElement clickable = driver.findElement(By.xpath("//a[text()= 'Football']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        new Actions(driver)
	                .moveToElement(clickable)
	                .pause(Duration.ofSeconds(1))
	                .click()
	                .perform() ;
	        Assert.assertEquals(driver.getCurrentUrl().contains("football"), true) ;
	                
	}
	
	@Test
	public void m7() {
		WebElement clickable = driver.findElement(By.xpath("//a[text() = 'Busketball']")) ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Actions(driver)
		.moveToElement(clickable)
		.click()
		.perform() ;
		

		Assert.assertEquals(driver.getCurrentUrl().contains("busketball"), true) ;
	}
	
	@Test
	public void m8() {
		WebElement clickable = driver.findElement(By.xpath("//a[text()='Kriket']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Actions(driver)
		.moveToElement(clickable)
		.click()
		.perform() ;

		Assert.assertEquals(driver.getCurrentUrl().contains("kriket"), true) ;
	}
	
	
	@Test
	public void m9() {
		WebElement clickable = driver.findElement(By.xpath("//a[text() ='Cibersport']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Actions(driver)
		.moveToElement(clickable)
		.click()
		.perform() ;
		

		
		driver.getCurrentUrl().contains("cibersport") ;
	}
	
	@Test
	public void m10() throws Exception {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		FileOutputStream fo = new FileOutputStream("C:\\Users\\asus\\OneDrive\\Desktop\\Excels Files\\Output.xls") ;
		WritableWorkbook wb = Workbook.createWorkbook(fo) ;
		WritableSheet ws = wb.createSheet("Url", 1 ) ;
		
		
WebElement clickable = driver.findElement(By.xpath("//a[text() ='Home']"));
		
		new Actions(driver)
		.moveToElement(clickable)
		.click()
		.perform() ;
		
		Label url1 = new Label(0 ,0 , driver.getCurrentUrl()) ;
		
		ws.addCell(url1) ;
		
		
WebElement clickable1 = driver.findElement(By.xpath("//a[text() ='Football']"));
		
		new Actions(driver)
		.moveToElement(clickable1)
		.click()
		.perform() ;

		Thread.sleep(2000) ;
		System.out.println( driver.getCurrentUrl()) ;
Label url2 = new Label(1 ,0 , driver.getCurrentUrl()) ;

		ws.addCell(url2) ;
		
WebElement clickable2 = driver.findElement(By.xpath("//a[text() ='Cibersport']"));
		
		new Actions(driver)
		.moveToElement(clickable2)
		.click()
		.perform() ;
	
		Thread.sleep(2000) ;
		System.out.println( driver.getCurrentUrl()) ;
Label url3 = new Label(2 ,0 , driver.getCurrentUrl()) ;

		ws.addCell(url3) ;
		
		
WebElement clickable3 = driver.findElement(By.xpath("//a[text() ='Kriket']"));
		
		new Actions(driver)
		.moveToElement(clickable3)
		.click()
		.perform() ;	
	
		Thread.sleep(2000) ;
		System.out.println( driver.getCurrentUrl()) ;
Label url4 = new Label(3 ,0 , driver.getCurrentUrl()) ;

		ws.addCell(url4) ;
		
		
		
WebElement clickable4 = driver.findElement(By.xpath("//a[text() ='Busketball']"));
		
		new Actions(driver)
		.moveToElement(clickable4)
		.click()
		.perform() ;
	
		
		Thread.sleep(2000) ;
Label url5 = new Label(4 ,0 , driver.getCurrentUrl()) ;

		ws.addCell(url5) ;
		
		wb.write() ;
		wb.write() ;
		wb.write() ;
		wb.write() ;
		wb.write() ;
		wb.close(); 
		
	}
	
}
