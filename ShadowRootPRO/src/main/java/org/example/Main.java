package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://app-stg.converted.in/login");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("M.abolela+1+1+1@converted.in");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("password");
           WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
           loginButton.click();
           Thread.sleep(2000);
//            WebElement root = driver.findElement(By.tagName("convertedin-sidebar"));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
//            WebElement displayAccordion =shadowDom.findElement(By.id("displayAccordion"));
//            // displayAccordion.click();
//            WebElement displayList =displayAccordion.findElement(By.xpath("//a[@data-target='#collapseDisplay']"));
//            displayList.click();
//            WebElement adroll =displayList.findElement(By.id("displayAccordion"));
//            adroll.click();

      //  driver.findElement(By.tagName("convertedin-sidebar")).getShadowRoot().findElement(By.cssSelector("div.convertedin-sidebar")).findElement(By.cssSelector("div[class='sidebar__container flex flex-column flex-grow-1 ng-star-inserted']")).findElement(By.cssSelector("div[class='flex flex-column gap-1 mb-1']")).findElement(By.cssSelector("p-accordion[class='p-element sidebar__accordion ng-star-inserted']")).findElement(By.cssSelector("div[class='p-accordion p-component']")).findElement(By.cssSelector("p-accordiontab[class='p-element ng-tns-c823280842-2 sidebar__main-accordion ng-star-inserted']")).findElement(By.cssSelector("div[class='p-accordion-tab ng-tns-c823280842-2']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Example JavaScript command to find elements inside a shadow DOM
        String script = "return document.querySelector('convertedin-sidebar').shadowRoot.querySelector('div.convertedin-sidebar')";

        WebElement convertedinSidebar = (WebElement) js.executeScript(script);

// Interact with elements within the shadow DOM
        WebElement desiredElement = convertedinSidebar.findElement(By.cssSelector("div.sidebar__container.flex.flex-column.flex-grow-1.ng-star-inserted"));
        WebElement desiredElement2 = desiredElement.findElement(By.cssSelector("div.flex-grow-1.flex.flex-column.justify-content-between"));
        WebElement parentAccordion = desiredElement2.findElement(By.cssSelector("div.flex.flex-column.gap-1.mb-1"));
        WebElement DirectMesgParent = parentAccordion.findElement(By.cssSelector("p-accordiontab.p-element.ng-tns-c823280842-2.sidebar__main-accordion.ng-star-inserted"));
        DirectMesgParent.click();
        WebElement EmailParent = DirectMesgParent.findElement(By.cssSelector("div.p-accordion-content.ng-tns-c823280842-2"));
        WebElement EmailDropdown = EmailParent.findElement(By.cssSelector("p-accordiontab.p-element.ng-tns-c823280842-3.sidebar__sub-accordion.ng-star-inserted"));
        Thread.sleep(1000);
        EmailDropdown.click();
        WebElement EmailParent2 = EmailDropdown.findElement(By.cssSelector("div.p-toggleable-content.ng-tns-c823280842-3.ng-trigger.ng-trigger-tabContent"));
        WebElement EmailClick= EmailParent2.findElement(By.cssSelector("a.flex.justify-content-between.align-items-center.ng-star-inserted"));
        Thread.sleep(1000);
        EmailClick.click();
        // Wait to observe the result
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}