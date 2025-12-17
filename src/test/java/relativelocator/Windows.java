package relativelocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
    }
    @Test
    public void testWorkingInBothWindowsTabs() {

        String mainFirstWindow = driver.getWindowHandle();

        //Automatically Open and switch to the new windows or tab
        driver.switchTo().newWindow(WindowType.TAB).get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        System.out.println("Title:" + driver.getTitle());


        //Work in the new windows or tab
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.id("SubmitCreate")).click();

        //Switch and work in the main window or tab
        driver.switchTo().window(mainFirstWindow);
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title:" + driver.getTitle());

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
