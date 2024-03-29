package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    public static void main(String[] args) {
        //The Select class in Selenium is used to work with dropdown elements in web pages, providing methods to interact with and manipulate dropdown options.
        //Select class provide three important methods to interact with dropdown
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://leafground.com/select.xhtml");
        driver.manage().window().maximize();
        WebElement dropDownElementFavTool = driver.findElement(By.className("ui-selectonemenu"));//store the dropdown element in WebElement
        Select dropDownFavTool = new Select(dropDownElementFavTool);//Pass the stored dropdown element as argument to the Select class constructor(To confirm which dropdown we are referring). Select class is
        dropDownFavTool.selectByVisibleText("Selenium");//Use selectByVisibleText method when you know the application is in complete english language

        WebElement dropDownElementCountry = driver.findElement(By.id("j_idt87:country_input"));
        Select dropDownCountry = new Select(dropDownElementCountry);
        dropDownCountry.selectByValue("4");//Use selectByValue method when the application is multilingual. Values cannot be change

        WebElement dropDownElementLanguage = driver.findElement(By.id("j_idt87:lang_input"));
        Select dropDownLanguage = new Select(dropDownElementLanguage);
        dropDownLanguage.selectByIndex(0);//Use selectByIndex method when you want to choose dropdown randomly.
    }
}
