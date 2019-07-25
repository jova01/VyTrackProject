package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public WebDriver driver;
    public  Actions ac;
    public JavascriptExecutor js;
    public  WebDriverWait wait;

    public  String usernameManager= ConfigurationReader.getProperty("usernamemanager");
    public  String usernameStoreManager= ConfigurationReader.getProperty("usernamestore");
    public  String usernameDriver=ConfigurationReader.getProperty("usernamedriver");
    public  String password=ConfigurationReader.getProperty("password");

    public String loginIDLocator="prependedInput";
    public String passwordIDLocator="prependedInput2";
    public String logoutButton="a[class='no-hash']";

    public String pageNameLocator ="oro-subtitle";

    public String dashboardTabLocator="Dashboards";
    public String fleetTabLocator ="Fleet";
    public String customersTabLcoator="Customers";
    public String activitiesTabLocator="Activities";
    public String salesTabLocator="Sales";

    public String dashboardModuleLocator="Dashboard";
    public String vehiclesModuleLocator ="Vehicles";
    public String accountsModuleLocator="Accounts";
    public String contactsModuleLocator="Contacts";
    public String calendarEventsModuleLocator="Calendar Events";
    public String opportunitiesModuleLocator="Opportunities";
    public String callsModuleLocator="Calls";
    public String vehiclesContractsModuleLocator="Vehicle Contracts";



    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver();
        js= (JavascriptExecutor) driver;
        ac= new Actions(driver);
        wait= new WebDriverWait(driver,10);

        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}