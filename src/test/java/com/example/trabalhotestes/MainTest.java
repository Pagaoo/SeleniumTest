package com.example.trabalhotestes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
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
    void browseManga() {
        driver.get("https://m.manganelo.com/www");
        driver.manage().window().maximize();

        searchManga();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        navigateToManga();
        nextChapter();
    }

    public void searchManga() {
        WebElement searchManga = driver.findElement(By.id("search-story"));
        searchManga.sendKeys("Modern Romanesco");
    }

    public void navigateToManga() {
        WebElement clickManga = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/form/div/ul/a/li"));
        clickManga.click();
    }

    public void nextChapter() {
        int countElement = countChapters();

        WebElement clickChapter = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/ul/li[last()]"));
        clickChapter.click();

        for(int i = 0; i < countElement - 1; i++) {
            WebElement clickNextChapter = driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/a[last()]"));
            clickNextChapter.click();
        }
    }
    public int countChapters() {
        int countElement = driver.findElements(By.tagName("li")).size();
        return countElement;
    }
}
