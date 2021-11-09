package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class automationKompas {

    private static WebDriver driver;
    public static void main (String[]args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium kompas\\src\\test\\java\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://kompas.id/");


        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Masuk"))));
        WebElement btnMasuk = driver.findElement(By.linkText("Masuk"));
        btnMasuk.click();
        System.out.println("Sukses ke link " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Halaman Masuk Akun Kompas.id - Harian Kompas");

        WebDriverWait tunggu = new WebDriverWait(driver,30);
        tunggu.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='url_daftar_sekarang']"))));
        WebElement btnRegister = driver.findElement(By.xpath("//a[@id='url_daftar_sekarang']"));
        btnRegister.click();

        WebElement inputNamadepan = driver.findElement(By.name("firstName"));
        inputNamadepan.sendKeys("Bambang Akbar");

        WebElement inputNamabelakang = driver.findElement(By.name("lastName"));
        inputNamabelakang.sendKeys("Sudibyo");

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("bambangakbarsudibyo@gmail.com");

        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("Adminqwerty123");

        Thread.sleep(5000);
        WebElement klikCaptcha = (WebElement) driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        klikCaptcha.click();

        WebElement btnSubmit =  driver.findElement(By.xpath("//button[@id='daftar']"));
        btnSubmit.submit();

        Thread.sleep(10000);
        driver.close();
    }
}
