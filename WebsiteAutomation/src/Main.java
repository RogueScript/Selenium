import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    WebDriver driver;

    public void launchBrowser(){
        String password = "f1v1XzcsHC47";
        String username = "mahndore95375";
        String name = "Mahn";
        String surname = "Dorre";
        System.setProperty("webdriver.chrome.driver", "./chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/SignUp");
        driver.findElement(By.id("firstName")).sendKeys(name);
        driver.findElement(By.id("lastName")).sendKeys(surname);
        driver.findElement(By.id("collectNameNext")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));

        // month day year and gender
        Select monthSel =new Select(driver.findElement(By.id("month")));
        monthSel.selectByVisibleText("April");
        driver.findElement(By.id("day")).sendKeys("10");
        driver.findElement(By.id("year")).sendKeys("1990");
        Select genderSel =new Select(driver.findElement(By.id("gender")));
        genderSel.selectByVisibleText("Male");
        driver.findElement(By.id("birthdaygenderNext")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("selectionc2")));

        // select the custom email option
        driver.findElement((By.id("selectionc4"))).click();
        driver.findElement(By.name("Username")).sendKeys(username);
        driver.findElement(By.id("next")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));

        // add password
        driver.findElement(By.name("Passwd")).sendKeys(password);
        driver.findElement(By.name("PasswdAgain")).sendKeys(password);
        //driver.findElement(By.className("VfPpkd-LgbsSe")).click();
        //driver.findElement(By.id("createpasswordNext")).click();
        WebElement button = driver.findElement(By.id("createpasswordNext"));

        // This needs looking into, as for some reason normal .click did not work like before
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", button);



    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Main obj = new Main();
        obj.launchBrowser();

    }
}