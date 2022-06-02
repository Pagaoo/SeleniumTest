package com.example.trabalhotestes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MainTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }

    @Test
    void openGoogle() {
        driver.get("https://m.manganelo.com/www");

        searchManga();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        navigateIntoManga();
    }

    public void searchManga() {
        WebElement searchManga = driver.findElement(By.id("search-story"));
        searchManga.sendKeys("Naruto");
    }

    public void navigateIntoManga() {
        WebElement clickManga = driver.findElement(By.xpath("//*[@id=\"1332\"]"));
        clickManga.click();

        WebElement clickChapter = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/ul/li[748]/a"));
        clickChapter.click();
    }
}
