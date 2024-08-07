import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(String browserType) {
        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                return null;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "path/to/drivers/yandexdriver.exe");
//                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); // Укажите путь к исполняемому файлу Яндекс браузера
                return new ChromeDriver(options);
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
