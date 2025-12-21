package relativelocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Geolocation
{
    ChromeDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void GeolocationTest() {
        Map coordinates = new HashMap();
        {
            {
                put("lat", 51.0);
                put("lng", 2.0);
                put("accuracy", 1);
            }
        }

        {
            driver.executeCdpCommand("Emulatuion.setGeolocationOverride",coordinates );

        }
    }
}
