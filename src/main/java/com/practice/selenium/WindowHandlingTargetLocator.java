package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandlingTargetLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/checkboxradio/");
        driver.manage().window().maximize();
        /*
        * Each tab is called a window and each window has some unique alpha numeric value.
        * Selenium WebDriver uses three methods to handle these windows.
        * 1.driver.getWindowHandle() - It returns string(String windowHandle = driver.getWindowHandle();) and as mentioned earlier it generates the unique alpha numeric value of current window along with the driver we use.
        * 2.driver.getWindowHandles() - It returns Set(Set<String> windowHandles = driver.getWindowHandles();). which holds the unique value of all the opened windows.
        * 3.driver.switchTo.Window(newWindowStringUniqueValue) - To get some value in java generally we use get() method but in Set interface we do not have get() method.But we have get in List interface and we can convert Set to list.
        * */
        String currentWindowUniqueValue = driver.getWindowHandle();
        System.out.println("Current Window Value Before clicking the button: "+currentWindowUniqueValue);//Just for comparison print the current window unique value before clicking the button which redirects to new window

        WebElement newWindowButton = driver.findElement(By.id("buttonToOpenNewWindow"));
        newWindowButton.click();//It will redirect to new window

        String currentWindowUniqueValueAfter = driver.getWindowHandle();//
        System.out.println("Current Window Value after clicking the button: "+currentWindowUniqueValueAfter);//After clicking the button it will open the new window just compare this value with before one it should be same but the control remains on first window eventhough new window appears.

        Set<String> allWindowsUniqueValue = driver.getWindowHandles();//This set of string hold all opened windows unique value why Set? because set holds only unique data.
        int numberOfWindows = allWindowsUniqueValue.size();
        System.out.println("Number of windows opened: "+numberOfWindows);
        List<String> getAllWindowsUniqueValue = new ArrayList<String>(allWindowsUniqueValue);//To move to new window we can get the string value of new window but in set we do not have get() method so we converting set into list. Since list is an interface we cannot create object so we use ArrayList class which implements List interface. and here pass all the unique values of windows which we stored in Set object.
        String newWindow = getAllWindowsUniqueValue.get(1);//After converting Set into list. now we can use the get () method.get always start from 0. 0 means current window so to move to new window use get(1) and store that unique value in string.(get() returns string)
        driver.switchTo().window(newWindow);//now newWindow object holds the new window unique value pass it in switchTo().window method. now the control should move to new window and all the elements in new window should be accessible

        String newWindowUniqueValue = driver.getWindowHandle();
        System.out.println("New Window Value: "+newWindowUniqueValue);//new window unique value
        driver.close();//It will close the current window
        driver.quit();//It will close all the windows
    }
}
