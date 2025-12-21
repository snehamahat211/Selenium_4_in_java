package relativelocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots  {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");

    }

    @Test
    public void takeWebElementScreenshot() {
        WebElement nextGenerationPlatform = driver.findElement
                (By.id("h-fast-scalable-reliable-deterministic-ai-tests-that-never-hallucinate"));
        File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
        File Destination = new File("Next Generation.png");
        try {
            FileHandler.copy(source, Destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
