package ShadowDOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app-stg.converted.in/login");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("M.abolela+1+1+1@converted.in");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        String script = "return document.querySelector('convertedin-sidebar').shadowRoot.querySelector('div.convertedin-sidebar')";

        WebElement convertedinSidebar = (WebElement) ((JavascriptExecutor) driver).executeScript(script);

        WebElement childSideBar = convertedinSidebar.findElement(By.cssSelector("div.sidebar__container.flex.flex-column.flex-grow-1.ng-star-inserted"));
        WebElement childSideBar2 = childSideBar.findElement(By.cssSelector("div.flex-grow-1.flex.flex-column.justify-content-between"));
        WebElement parentAllDropdown = childSideBar2.findElement(By.cssSelector("div.flex.flex-column.gap-1.mb-1"));
        WebElement directMessageParent = parentAllDropdown.findElement(By.cssSelector("p-accordiontab.p-element.ng-tns-c823280842-2.sidebar__main-accordion.ng-star-inserted"));
        directMessageParent.click();
        WebElement EmailParent = directMessageParent.findElement(By.cssSelector("div.p-accordion-content.ng-tns-c823280842-2"));
        WebElement EmailDropdown = EmailParent.findElement(By.cssSelector("p-accordiontab.p-element.ng-tns-c823280842-3.sidebar__sub-accordion.ng-star-inserted"));
        Thread.sleep(1000);
        EmailDropdown.click();
        WebElement EmailParent2 = EmailDropdown.findElement(By.cssSelector("div.p-toggleable-content.ng-tns-c823280842-3.ng-trigger.ng-trigger-tabContent"));
        WebElement EmailClick = EmailParent2.findElement(By.cssSelector("a.flex.justify-content-between.align-items-center.ng-star-inserted"));
        Thread.sleep(1000);
        EmailClick.click();


    }
}