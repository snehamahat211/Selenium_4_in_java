package relativelocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshots  {
    WebDriver driver;

    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");

    }

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
