package BaiTapCMS.BT01_02_03;

import Common.BaseTest;
import Locators.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddCategory extends BaseTest {
    public void LoginCMS() {
        driver.get("https://cms.anhtester.com/login");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerLoginPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        driver.findElement(By.xpath(LocatorCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCMS.buttonLogin)).click();
        sleep(1);

    }

    @Test
    public void testAddCategory () {

        // Login CMS
        LoginCMS();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin", "Không đến được trang Admin");

        // Categories page

        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerCategories)).isDisplayed(), "Không đến được trang All Categories");
        sleep(1);

        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerAddCategory)).isDisplayed(), "Không đến được trang Add Category");
        sleep(1);

        // Add Category

        String Category_Name = "Name of Category 01";

        driver.findElement(By.xpath(LocatorCMS.inputNameCategory)).sendKeys(Category_Name);
        driver.findElement(By.xpath(LocatorCMS.dropdownParentCategory)).click();
        driver.findElement(By.xpath(LocatorCMS.inputSearchParentCategory)).sendKeys("Demo category 2");
        driver.findElement(By.xpath(LocatorCMS.inputSearchParentCategory)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.inputOrderingNumber)).sendKeys("123");

        driver.findElement(By.xpath(LocatorCMS.dropdownType)).click();
        driver.findElement(By.xpath(LocatorCMS.selctType)).click();
        driver.findElement(By.xpath(LocatorCMS.buttonBanner)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.selectBanner)).click();
        sleep(1);

        driver.findElement(By.xpath(LocatorCMS.buttonAddFiles)).click();

//        driver.findElement(By.xpath(LocatorCMS.buttonIcon)).click();
//        sleep(1);
//        driver.findElement(By.xpath(LocatorCMS.selectIcon)).click();
//        sleep(1);

        driver.findElement(By.xpath(LocatorCMS.buttonAddFiles)).click();

        driver.findElement(By.xpath(LocatorCMS.inputMetaTitle)).sendKeys("Title");
        driver.findElement(By.xpath(LocatorCMS.inputMetadescription)).sendKeys("Description");
        driver.findElement(By.xpath(LocatorCMS.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(LocatorCMS.inputSearchFilteringAttributes)).sendKeys("Size");
        driver.findElement(By.xpath(LocatorCMS.inputSearchFilteringAttributes)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCMS.buttonSaveCategory)).click();

        // Tìm kiếm Category đã thêm

        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Category_Name);
        driver.findElement(By.xpath(LocatorCMS.inputSearchCategories)).sendKeys(Keys.ENTER);
        sleep(5);

        // Kiểm tra giá trị name của Category đã thêm

        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemOnCategoryTable)).getText(), Category_Name, "Giá trị name của Category không đúng");

    }
}
