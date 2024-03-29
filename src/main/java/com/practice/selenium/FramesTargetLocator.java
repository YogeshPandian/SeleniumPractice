package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTargetLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/checkboxradio/");
        driver.manage().window().maximize();
        /*
        * When you find frame in dom and want to perform action inside the frame follow the below rules
        * 1. switch to the frame //driver.switchTo().frame()
        *    frame() method is like a polymorphism(method overloading)which has same signature (frame) but different input arguments
        *       1. Index - frame(0) returns integer
        *       2. Id or name - frame("name") returns string
        *       3. WebElement - frame(frameElement) find the element of the frame and useit as input argument
        * 2. Perform Action //driver.findElement(By.id("UserName")).sendKeys("Yogi");
        * 3. Come out from the frame // driver.switchTo().defaultContent()
         * */
        /*
        * How do I know my elements are inside frame
        * Right click on the page and you will see options like View Frame Source and Reload Frame or
        * Right click inspect and the parent will be <iframe
        * */
        /*WebElement frameButtonClick = driver.findElement(By.xpath("((//label[text()='New York'])/span[1]"));
        frameButtonClick.click();
        boolean isSelected = frameButtonClick.isSelected();
        System.out.println(isSelected);*/
        Thread.sleep(5000);
        driver.switchTo().frame("demo-frame");
        WebElement frameButtonClick = driver.findElement(By.xpath("//label[text()='New York']"));
        frameButtonClick.click();
        boolean isSelected = frameButtonClick.isSelected();
        System.out.println(isSelected);
        driver.switchTo().defaultContent();
    }
}
