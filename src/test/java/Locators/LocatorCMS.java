package Locators;

public class LocatorCMS {

    //Login CMS
    public static String headerLoginPage = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    //Menu Products
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuAllProducts = "//span[normalize-space()='All products']";
    public static String menuAddNewProduct = "//span[normalize-space()='Add New Product']";
    public static String menuCategory = "//span[normalize-space()='Category']";

    // Products list Page
    public static String inputSearchProducts = "//input[@id='search']";
    public static String popupAddProductSuccess = "//span[@data-notify='message']";
    public static String firstItemOnProducts = "//span[@class='text-muted text-truncate-2']";


    // Add New Product Page
    public static String headerAddNewCustomer = "//h5[normalize-space()='Add New Product']";

    // Product Information

    public static String inputProductName = "//input[@placeholder='Product Name']";
    public static String dropdownCategory = "//div[@id='category']//button[@type='button']";
    public static String inputSearchCategory = "//div[@id='category']//input[@type='search']";
    public static String dropdownBrand = "//div[@id='brand']//button[@type='button']";
    public static String inputSearchBrand = "//div[@id='brand']//input[@type='search']";
    public static String inputUnit = "//input[@name='unit']";
    public static String inputWeight = "//input[@name='weight']";
    public static String inputMinimumPurchaseQty = "//input[@name='min_qty']";
    public static String inputTags = "//span[@role='textbox']";

    //Product Images table
    public static String buttonGalleryImages = "//div[@data-multiple='true']//div[@class='input-group-text bg-soft-secondary font-weight-medium'][normalize-space()='Browse']";
    public static String selectGalleryImages = "//div[@title='product01.jpg']//img[@class='img-fit']";
    public static String buttonAddFilesPro = "//button[normalize-space()='Add Files']";

    // Product Videos table
    public static String dropdownVideoProvider = "//button[@title='Youtube']";
    public static String inputVideoLink = "//input[@placeholder='Video Link']";

    // Product Variation tab
    public static String checkboxColorsActive = "//div[@class='col-md-1']//span";
    public static String dropdownColors = "//button[@data-id='colors']";

    public static String inputSearchColors = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    // Product price + stock table
    public static String inputUnitprice = "//input[@placeholder='Unit price']";
    public static String inputDiscount = "//input[@placeholder='Discount']";

    // Button Save
    public static String buttonSaveAndUnpublish  = "//button[normalize-space()='Save & Unpublish']";
    public static String buttonSaveAndPublish  = "//button[normalize-space()='Save & Publish']";

    // Categories list Page

    public static String headerCategories = "//h1[normalize-space()='All categories']";
    public static String buttonAddNewCategory = "//a[normalize-space()='Add New category']";
    public static String inputSearchCategories = "//div[@class='card-header d-block d-md-flex']//input[@type='text']";
    public static String firstItemOnCategoryTable ="//tbody/tr[1]/td[2]";
    public static String buttonEditCategory ="//tbody/tr[1]/td[10]/a[1]";
    public static String buttonDeleteCategory ="//tbody/tr[1]/td[10]/a[2]";
    public static String buttonDeletepopup ="//a[@id='delete-link']";
    public static String textNothingFound ="//td[normalize-space()='Nothing found']";



    // Add Category
    public static String headerAddCategory = "//h5[normalize-space()='Category Information']";

    public static String inputNameCategory = "//input[@id='name']";
    public static String dropdownParentCategory = "//div[contains(text(),'No Parent')]";
    public static String inputSearchParentCategory = "//div[@class='col-md-9']//input[@type='search']";
    public static String inputOrderingNumber = "//input[@id='order_level']";

    public static String dropdownType = "//div[contains(text(),'Physical')]";
    public static String selctType = "//span[normalize-space()='Digital']";

    public static String buttonBanner = "//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div[@class='row']/div[@class='col-lg-8 mx-auto']/div[@class='card']/div[@class='card-body']/form[@class='form-horizontal']/div[5]/div[1]/div[1]/div[1]";
    public static String selectBanner = "//div[@title='Banner.png']//img[@class='img-fit']";
    public static String buttonAddFiles = "//button[normalize-space()='Add Files']";

//    public static String buttonIcon = "//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div[@class='row']/div[@class='col-lg-8 mx-auto']/div[@class='card']/div[@class='card-body']/form[@class='form-horizontal']/div[6]/div[1]/div[1]/div[1]";
//    public static String selectIcon = "//div[@title='icon.jpg']//img[@class='img-fit']";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetadescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes = "//button[@title='Nothing selected']";
    public static String inputSearchFilteringAttributes = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    public static String buttonSaveCategory = "//button[@type='submit']";



}