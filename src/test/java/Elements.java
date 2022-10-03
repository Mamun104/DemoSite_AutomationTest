import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Elements {
    public WebDriver driver;
    WebDriverWait wait;

    public Elements(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void textBox() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement elementCheck = wait.until(ExpectedConditions.elementToBeClickable(By.className("card")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", elementCheck);
        Thread.sleep(3000);
        WebElement textBox = driver.findElement(By.className("btn"));
        textBox.click();
        Thread.sleep(2000);
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Adam Smith");
        Thread.sleep(2000);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("test@gmail.com");
        Thread.sleep(2000);
        WebElement userAddress = driver.findElement(By.id("currentAddress"));
        userAddress.sendKeys("Uttara,Dhaka");
        Thread.sleep(2000);
        WebElement parmanentAddress = driver.findElement(By.id("permanentAddress"));
        parmanentAddress.sendKeys("Uttara,Dhaka");
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        js.executeScript("arguments[0].click()", submitBtn);

    }
    public void checkBox() throws InterruptedException {

        Thread.sleep(2000);

        WebElement click = driver.findElement(By.cssSelector("[class$='rct-icon rct-icon-uncheck']"));

        boolean isSelected = click.isSelected();//isDisplayed(), isEnabled()

        if (isSelected == false) {

            click.click();
        } else {

            System.out.println("not found");
        }

    }

    public void radioButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement radioBtn = driver.findElement(By.xpath("//label[.='Yes']"));

        boolean status = radioBtn.isSelected();

        if (status == false) {

            radioBtn.click();
        }

        Thread.sleep(2000);
        WebElement radioBtn1 = driver.findElement(By.xpath("//label[.='Impressive']"));

        boolean impressive = radioBtn1.isDisplayed();

        if (impressive == true) {

            radioBtn1.click();
        }

        Thread.sleep(2000);
        WebElement enableBtn = driver.findElement(By.xpath("//label[.='Impressive']"));

        boolean enableButton = radioBtn1.isEnabled();

        if (enableButton == false) {

            radioBtn1.click();
        }
    }

    public void multipleButtons() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> multipleBtn = driver.findElements(By.tagName("button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(multipleBtn.get(1)).perform();
        Thread.sleep(2000);
        actions.contextClick(multipleBtn.get(2)).perform();
        Thread.sleep(2000);
        actions.click(multipleBtn.get(3)).perform();
        Thread.sleep(2000);
        List<WebElement> textBtn = driver.findElements(By.tagName("p"));
        String text1 = textBtn.get(0).getText();
        Assert.assertTrue(text1.contains("You have done a double click"));
        Thread.sleep(2000);
        String text2 = textBtn.get(1).getText();
        Assert.assertTrue(text2.contains("You have done a right click"));
        Thread.sleep(2000);
        String text3 = textBtn.get(2).getText();
        Assert.assertTrue(text1.contains("You have done a double click"));
    }

    public void linksNewTabHandle() throws InterruptedException {
        Thread.sleep(2000);
        WebElement clickLink = driver.findElement(By.cssSelector("[id$='simpleLink']"));
        clickLink.click();
        Thread.sleep(3000);

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement getImg = driver.findElement(By.cssSelector("[class$='banner-image']"));
                getImg.isDisplayed();


            }
        }
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
        WebElement clickNewLink = driver.findElement(By.cssSelector("[id$='dynamicLink']"));
        clickNewLink.click();
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
    }

    public void brokenLinks() throws InterruptedException {
        Thread.sleep(2000);
        WebElement validUrl = driver.findElement(By.cssSelector("[href$='http://demoqa.com']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", validUrl);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement invalidUrl = driver.findElement(By.xpath("//a[.='Click Here for Broken Link']"));
        if (invalidUrl != null) {

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].click()", invalidUrl);
        } else {
            System.out.println("Element Not found ");
        }

        Thread.sleep(3000);
       driver.navigate().back();

    }
    public void uploadAndDownload() throws InterruptedException {
        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement download = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        download.click();
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement uploadPicture = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
        uploadPicture.sendKeys("D:\\log.png");


    }


}
