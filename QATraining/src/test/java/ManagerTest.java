import com.wavemaker.BasePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ManagerTest {
    BasePage basePage;
    @BeforeTest
    public void launchBrowser(){
        basePage = BasePage.getInstance();
        basePage.launchBrowser();
    }

    @Test(description = "applying leave in my application")
    public void acceptLeave() {

        basePage.write(By.id("email"), "pavan@email.com");
        basePage.write(By.id("password"), "pavan@123");
        basePage.click(By.id("login-btn"));
        basePage.click(By.id("my-team-leaves-btn"));
        basePage.click(By.id("48"));
        basePage.click(By.id("leave-accept-btn"));
        basePage.click(By.id("profile-icon"));
        basePage.click(By.id("logout-btn"));
    }

    @AfterTest
    public void closeBrowser() {
        basePage.quit();
    }
}
