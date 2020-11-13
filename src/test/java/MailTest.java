import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MailTest {
    private ChromeDriver driver;
    private static final String META_URL = "https://meta.ua";
    private static final String EMAIL = "artem.rud.softserve@meta.ua";
    private static final String CHECK_EMAIL = "\"Rud Artem\" <artem.rud.softserve@meta.ua>";
    private static final String CHECK_THEME = "Study Hard";
    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testMail() {
        driver.get(META_URL);
        WebElement enterToMail = driver.findElement(By.xpath("//*[text()='Вхід до пошти']"));
        enterToMail.click();
        WebElement loginMail = driver.findElement(By.xpath("//input[@name=\"login\"]"));
        loginMail.sendKeys(EMAIL);
        WebElement passwordMail = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordMail.sendKeys("gepard20");
        WebElement passwordNext = driver.findElement(By.xpath("//button[text()='Увійти']"));
        passwordNext.click();

        WebElement buttonWriteMail = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id=\"id_send_email\"]")));
        buttonWriteMail.click();

        WebElement whoGetMail = driver.findElement(By.xpath("//*[@id=\"send_to\"]"));
        whoGetMail.sendKeys(EMAIL);

        WebElement themeMail = driver.findElement(By.xpath("//input[@id=\"subject\"]"));
        themeMail.sendKeys("Study Hard");
        WebElement bodyMail = driver.findElement(By.xpath("//textarea[@id=\"body\"]"));
        bodyMail.sendKeys("Some message");
        WebElement send = driver.findElement(By.xpath("//*[@id=\"hc_b3\"]/div[1]/div[1]/input[2]"));
        send.click();
        driver.navigate().refresh();

        WebElement message = driver.findElement(By.xpath("//*[text()='Study Hard']"));
        message.click();
        WebElement checkMail = driver.findElement(By.xpath("//*[@id='from_line']/table/tbody/tr[1]/td[2]/span"));
        WebElement checkTheme = driver.findElement(By.xpath("//*[@id=\"add_link\"]/div[1]/h1"));
        Assert.assertEquals(checkTheme.getText(),CHECK_THEME);
        Assert.assertEquals(checkMail.getText(), CHECK_EMAIL);

    }
}
