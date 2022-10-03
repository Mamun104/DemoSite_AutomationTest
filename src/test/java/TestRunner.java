import org.testng.annotations.Test;

public class TestRunner extends Setup {
    Elements elements;

    @Test(priority = 1, description = "Form fill-up with valid data")
    public void testTestBox() throws InterruptedException {
        driver.get("https://demoqa.com/");
        elements = new Elements(driver);
        elements.textBox();


    }

    @Test(priority = 2, description = "Check box validation")
    public void checkBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        elements = new Elements(driver);
        elements.checkBox();
    }

    @Test(priority = 3, description = "radio button validation")
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        elements = new Elements(driver);
        elements.radioButton();
    }

    @Test(priority = 4, description = "multiple buttons handle")
    public void multipleButtonsTest() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        elements = new Elements(driver);
        elements.multipleButtons();
    }

    @Test(priority = 5, description = "new tab and window handle")
    public void newTabTest() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        elements = new Elements(driver);
        elements.linksNewTabHandle();
    }

   @Test(priority = 6, description = "broken links handle")
    public void brokenLinksTest() throws InterruptedException {
        driver.get("https://demoqa.com/broken");
        elements = new Elements(driver);
        elements.brokenLinks();
    }

    @Test(priority = 7, description = "upload image and download files  handle")
    public void uploadImgAndDownloadFileTest() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        elements = new Elements(driver);
        elements.uploadAndDownload();
    }

}
