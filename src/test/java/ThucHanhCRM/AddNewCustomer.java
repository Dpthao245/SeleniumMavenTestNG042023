package ThucHanhCRM;

import Common.BaseTest;
import Locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddNewCustomer extends BaseTest {


    private static final String COMPANY_NAME = "NAME OF COMPANY 01";
    public void LoginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(),"Không đến được trang Dashboard");
    }
    @Test (priority = 1)
    public void testAddNewCustomer() {

        // Login CRM page
        LoginCRM();

        // Customer page

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Tên header Customers Page không đúng");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();

        //Add New Customer
        driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("5");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("01213456789");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("company@.com");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("50 NVC");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("900000");
        driver.findElement(By.xpath(LocatorCRM.buttonCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.buttonSaveCustomer)).click();
        sleep(3);

        // Search Custormer đã thêm
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy Customer");

        // Kiểm tra giá trị Customer đã thêm
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).getAttribute("value"), COMPANY_NAME, "Giá trị COMPANY không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).getAttribute("value"), "5", "Giá trị VAT không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "01213456789", "Giá trị Phone không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "company@.com", "Giá trị Website không đúng");

        softAssert.assertAll();
    }
    @Test (priority = 2)

     public void testAddNewContactForCustomer() {

        // Login CRM page

        LoginCRM();

        //Customer page

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(),"Customers Summary", "Tên header Customers Page không đúng");
        sleep(1);

        // Search Custormer cần thêm contact

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy Customer");
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();

        // Contact page

        driver.findElement(By.xpath(LocatorCRM.menuContacts)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Không đến được trang Contact");

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Không đến được dialog Add New Contact");

        //Add New Contact Page

        String First_Name = "Duong";
        String Last_Name = "Phuong";

        CharSequence profileURL = System.getProperty("user.dir")+ "\\src\\test\\resources\\datatest\\profile-image-female.png";
        driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys(profileURL);
        driver.findElement(By.xpath(LocatorCRM.inputFirstName)).sendKeys(First_Name);
        driver.findElement(By.xpath(LocatorCRM.inputLastName)).sendKeys(Last_Name);
        driver.findElement(By.xpath(LocatorCRM.inputPosition)).sendKeys("Nhân viên");
        driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).sendKeys("test123@mail.com");
        driver.findElement(By.xpath(LocatorCRM.inputPhoneContact)).sendKeys("0134765987");
        //driver.findElement(By.xpath(LocatorCRM.buttonGeneratePassword)).click();
        driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonShowPassword)).click();
        driver.findElement(By.xpath(LocatorCRM.checkboxDoNotSendEmail)).click();
        driver.findElement(By.xpath(LocatorCRM.buttonSaveContact)).click();
        sleep(2);

        // Search contact vừa được thêm
        driver.findElement(By.xpath(LocatorCRM.inputSearchContacts)).sendKeys(First_Name + " " + Last_Name);
        sleep(2);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemContactOnTable)).isDisplayed(), "Không tìm thấy Contact");

        // Kiểm tra giá trị Contact đã thêm
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath(LocatorCRM.firstItemContactOnTable)).click();

        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputFirstName)).getAttribute("value"), First_Name, "Giá trị First Name không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputLastName)).getAttribute("value"),Last_Name, "Giá trị Last Name không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).getAttribute("value"), "test123@mail.com", "Giá trị Email không đúng");
        //softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).getAttribute("value"), "123456", "Giá trị Password không đúng");

        softAssert.assertAll();


    }
}
