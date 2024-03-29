package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://erail.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //To take snap use getScreenShotAs method which has input argument as OutputType interface which holds three types of memory File, BASE64 and BYTE
        File memory = driver.getScreenshotAs(OutputType.FILE);//Since we are using File type store the taken screenshot in FILE
        FileUtils.copyFile(memory, new File("./snap/snap1.jpg"));//FileUtils ia=s a class which used to perform file system operations, such as copying, moving, deleting, reading, and writing files and directories
    }
}
