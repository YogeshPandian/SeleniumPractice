package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertTargetLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        /*
        * Generally there are Three types of alert
        * 1. Simple alert
        * 2. Confirmation alert
        * 3. Prompt alert
        * We must attend these alerts or else we cannot perform any other actions.(We cannot inspect alert)
        * Four methods in alert
        * 1. accept();
        * 2. dismiss();
        * 3. getText();// returns string(String text = driver.switchTo.getText())// If you want to read or get something do not use input argument and declare the data type outside. this is for method, refer getText() method from Alert interface
        * 4. sendKeys("text")// If you want to pass or write something use input argument and declare the data type inside input argument. this is for method, refer sendKeys(String KeysToSend) method from Alert interface(Use return keyword her refer RemoteWebDriver class)
        * */
        WebElement clickAlertButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        clickAlertButton.click();
        Alert alertFeatures = driver.switchTo().alert();// Alert is an interface have four methods which implements from the class RemoteAlert
        String alertText = alertFeatures.getText();
        System.out.println(alertText);
        if(alertText.equals("I am an alert box!")){
            System.out.println("Correct Alert Box");
        }else {
            System.out.println("Wrong Alert Box");
        }
        //alertFeatures.sendKeys("Test alert prompt text field");//clear() method is not required in alert by default it will clear the text field
        alertFeatures.accept();
        //alertFeatures.dismiss();
        /*
        * Exception in Alert:
        * UnhandledAlertException - When an alert is present in the application but not handled in our code, it will throw an UnhandledAlertException.
        * NoAlertPresentException - When alert is not present in the application but you wrote a code
        *
        * Selenium webdriver cannot take screenshot of alert. if u try it will throw UnhandledAlertException
        * Sweet alert: It looks like an alert but not. we can inspect sweet alert
        * Notifications are different from Alert
        * To handle notification
        * */
    }
}
