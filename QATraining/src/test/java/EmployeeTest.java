import com.wavemaker.BasePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTest {
    BasePage basePage;
    @BeforeTest
    public void launchBrowser(){
        basePage = BasePage.getInstance();
        basePage.launchBrowser();
    }

    @Test(description = "applying leave by manager in my application")
    public void applyLeave() {
        basePage.write(By.id("email"),"priya@email.com");
        basePage.write(By.id("password"),"priya@123");
        basePage.click(By.id("login-btn"));
        basePage.click(By.name("apply-leave"));
        basePage.select(By.name("leaveTypeInput"),"PERSONAL TIME OFF");
        basePage.write(By.id("fromDate"),"09/05/2024");
        basePage.write(By.id("toDate"),"09/05/2024");
        basePage.write(By.xpath("//textarea[@name='description']"),"Team lunch");
        basePage.click(By.xpath("//button[@type='submit']"));
        basePage.click(By.id("profile-icon"));
        basePage.click(By.id("logout-btn"));
    }

    @AfterTest
    public void closeBrowser(){
        basePage.quit();
    }
}
