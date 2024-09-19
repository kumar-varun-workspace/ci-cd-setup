package packageName;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class basic {

    @Test(groups = {"calling_this_method_from_testng"}, description = "Simple description about this method")
    public void method(){
        System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        //Reporting code starts below
        ExtentSparkReporter reporter;
        ExtentReports extent;
        ExtentTest test;
        String path="Reports/index.html";           //Path of the report
        reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation test results");         //Sets the name of the reports
        reporter.config().setDocumentTitle("Spicejet-P7 Batch Results");    //Sets the title of report in browser tab
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Environment","UAT");                    //Sets some additional info
        extent.setSystemInfo("TesterName","Varun Kumar");             //Sets some additional info
        test = extent.createTest("Test Case 1");                      //Sets the name of the test
        test.log(Status.PASS,"Test case pass");                      //Mark the test case as pass or fail
        extent.flush();
    }

}
