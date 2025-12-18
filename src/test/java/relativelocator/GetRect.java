package relativelocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetRect {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/");

    }

    @Test
    public void getPositionDimension(){
        WebElement logoTAU =driver.findElement(
                By.xpath("//div[@id='app']//header/a/img"));
        logoTAU.getRect();
        Rectangle rectTAU = logoTAU.getRect();
        System.out.println("x:"+rectTAU.getX());
        System.out.println("y:"+rectTAU.getY());
        System.out.println("width:"+rectTAU.getWidth());
        System.out.println("height:"+rectTAU.getHeight());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
