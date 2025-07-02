package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import io.cucumber.java.en.*;
import java.time.Duration;

import static org.junit.Assert.*;




public class GoogleSearchSteps {

    WebDriver driver = Hooks.driver;

    @Given("I open Google homepage")
    public void i_open_google_homepage() {
        driver.get("https://www.google.com");
        
    }

    @When("I search for {string}")
    public void i_search_for(String searchText) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchText);
        searchBox.submit();
        
        
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String searchText) {
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(searchText));
    	 
    	assertTrue(driver.getTitle().toLowerCase().contains(searchText.toLowerCase()));
    	// Wait for 30 seconds before closing the browser
        try {
            Thread.sleep(30000); // 30,000 milliseconds = 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}