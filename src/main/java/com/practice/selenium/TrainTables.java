package com.practice.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TrainTables {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://erail.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        WebElement txtStationFrom = driver.findElement(By.id("txtStationFrom"));
        txtStationFrom.clear();
        txtStationFrom.sendKeys("MAS", Keys.TAB);
        System.out.println("From: "+txtStationFrom.getAttribute("value"));
        WebElement txtStationTo = driver.findElement(By.id("txtStationTo"));
        txtStationTo.clear();
        txtStationTo.sendKeys("NDLS", Keys.TAB);
        System.out.println("To: "+txtStationTo.getAttribute("value"));
        WebElement chkSelectDateOnly = driver.findElement(By.id("chkSelectDateOnly"));
        chkSelectDateOnly.click();
        /*boolean selected = chkSelectDateOnly.isSelected();
        System.out.println("Verification"+selected);*/

        List<WebElement> tableRowsNoOfTrains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));
        int tableRowSize = tableRowsNoOfTrains.size()-1;
        System.out.println("Number of available trains: "+tableRowSize);

        /*List<WebElement> tableDataTrainNum = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[1]"));
        for (WebElement eachTrain: tableDataTrainNum){
            System.out.println("Train number"+eachTrain.getText());
        }*/
        /*List<WebElement> tableDataNameOfTrains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[1]"));
        for (int i = 0; i < tableRowSize; i++) {
            String trainNumber = tableDataNameOfTrains.get(i).getText();
            System.out.println("Train number " + (i + 1) + ": " + trainNumber);
        }*/
        List<WebElement> tableDataTrainNum = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[1]"));
        int i = 1;
        for(WebElement eachTrainNum:tableDataTrainNum){
            String trainNum = eachTrainNum.getText();
            System.out.println("Train number "+i+": "+trainNum);
            i++;
        }
        List<WebElement> tableDataTrainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
        int j = 1;
        for(WebElement eachTrainName:tableDataTrainName){
            String trainName = eachTrainName.getText();
            System.out.println("Train name "+j+": "+trainName);
            j++;
        }
    }
}
