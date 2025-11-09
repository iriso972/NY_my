import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PervyClass {
//открыть браузер
//зайти на сайт
    @Test
    public void zipCode() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        //browser.findElement(By.cssSelector("input[name='zip_code']")); локатор cssSelector
        //browser.findElement(By.name("zip_code"));  локатор name
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("123456");
        //browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys(Keys.CONTROL + "A");  выделили текст
        //browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys(Keys.BACK_SPACE); удалили текст
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean registerBtnPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        assertTrue(registerBtnPresent, "Ожидается кнопка 'Зарегистрироваться'");
        browser.quit();
    }

    @Test
    public void zipDigitalCode() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("16");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        String errorText = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorText, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}