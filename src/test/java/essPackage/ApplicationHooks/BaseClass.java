package essPackage.ApplicationHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import essPackage.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	ExcelUtils excel;
    public static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

	public void setup() throws IOException {
String browserName = prop.getProperty("browserName");
String Url = prop.getProperty("URL");
		if (browserName.equalsIgnoreCase("Microsoft Edge") || browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Invalid browser name in the Excel Sheet" + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
	}
}
