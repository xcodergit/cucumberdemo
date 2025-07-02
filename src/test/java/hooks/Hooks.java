package hooks;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {
	
	public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        
        
        driver.manage().window().maximize();
      
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
