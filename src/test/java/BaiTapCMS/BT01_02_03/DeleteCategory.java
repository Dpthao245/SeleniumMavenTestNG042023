package BaiTapCMS.BT01_02_03;

import Common.BaseTest;
import Locators.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteCategory extends BaseTest {
    public void LoginCMS() {
        driver.get("https://cms.anhtester.com/login");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerLoginPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        driver.findElement(By.xpath(LocatorCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCMS.buttonLogin)).click();
        sleep(1);

    }

    @Test
    public void testDeleteCategory() {

        // Login CMS
        LoginCMS();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin", "Không đến được trang Admin");        // Categories page

        // Categories page

        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerCategories)).isDisplayed(), "Không đến được trang All Categories");
        sleep(1);

        String Category_Name = "Name of Category 01";

        // Tìm kiếm Category đã thêm

        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Category_Name);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Keys.ENTER);
        sleep(5);

        // Xóa category
        driver.findElement(By.xpath(LocatorCMS.buttonDeleteCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.buttonDeletepopup)).click();

        // Tìm kiếm Category đã xóa

        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Category_Name);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Keys.ENTER);
        sleep(5);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.textNothingFound)).isDisplayed(), "Xóa category không thành công.");
    }

    }
