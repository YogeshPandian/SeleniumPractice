package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//WebDriverManager is static class which calls the browser methods chromedriver(method) and setup(method)
        ChromeDriver driver = new ChromeDriver();//Create object reference(instance) for ChromeDriver class
        driver.get("http://leaftaps.com/opentaps/control/main");//Use the instance of ChromeDriver to get(method) the URL
        driver.manage().window().maximize();//To maximize use the driver instance and call the following methods manage(),window(),maximize()
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");//findElement is a common method available in all Driver class(RemoteWebDriver which is extended by chromium driver which is extended by chrome driver) and By is the class which have all selenium locators in method format
        driver.findElement(By.id("password")).sendKeys("crmsfa");//sendKeys is a method from WebElement interface. WebElement is an interface in Selenium WebDriver that represents an HTML element on a web page. It's a generic type that can represent any kind of HTML element such as text boxes, buttons, links, etc.
        driver.findElement(By.className("decorativeSubmit")).click();//click is a method from WebElement interface.
        String title = driver.getTitle();//getTitle method used to get the title page. Store it in a variable by using shortcut ctrl + Alt + V
        System.out.println(title);// It will print the title in console
        driver.findElement(By.linkText("CRM/SFA")).click();
    }
}
